package com.optilab.phonebook.rest;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Logger;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.optilab.phonebook.crud.ItemCRUD;
import com.optilab.phonebook.entity.Item;

@Path("/items")
@RequestScoped
public class ItemRestService {
	
	@Inject
	private ItemCRUD itemCRUD;
	
	@GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Item> listAllMembers() {
		return itemCRUD.getAll();
    }
	
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response createMember(Item item) {
		Response.ResponseBuilder builder = null;

        try {
            // Validates member using bean validation

            itemCRUD.addItem(item);;

            // Create an "ok" response
            builder = Response.ok();
        } catch (Exception e) {
            // Handle generic exceptions
            Map<String, String> responseObj = new HashMap<String, String>();
            responseObj.put("error", e.getMessage());
            builder = Response.status(Response.Status.BAD_REQUEST).entity(responseObj);
        }

        return builder.build();
	}

}
