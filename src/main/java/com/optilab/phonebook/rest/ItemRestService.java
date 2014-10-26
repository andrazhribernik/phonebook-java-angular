package com.optilab.phonebook.rest;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Logger;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.WebApplicationException;
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
	@Path("/{id:[0-9][0-9]*}")
    @Produces(MediaType.APPLICATION_JSON)
    public Item getItem(@PathParam("id") long id) {
		try {
			return itemCRUD.getItem(id);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
    }
	
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
            itemCRUD.addItem(item);;
            builder = Response.ok();
        } catch (Exception e) {
            Map<String, String> responseObj = new HashMap<String, String>();
            responseObj.put("error", e.getMessage());
            builder = Response.status(Response.Status.BAD_REQUEST).entity(responseObj);
        }

        return builder.build();
	}
	
	@PUT
    @Path("/{id:[0-9][0-9]*}")
	@Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response editItem(@PathParam("id") long id, Item item) {
		Response.ResponseBuilder builder = null;
        try {
	        itemCRUD.editItemById(item);
	        builder = Response.ok();
        }
        catch(Exception e){
        	Map<String, String> responseObj = new HashMap<String, String>();
            responseObj.put("error", e.getMessage());
            builder = Response.status(Response.Status.BAD_REQUEST).entity(responseObj);
        }
        
        return builder.build();
    }
	
	@DELETE
    @Path("/{id:[0-9][0-9]*}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response deleteItem(@PathParam("id") long id) {
		Response.ResponseBuilder builder = null;
        try {
	        itemCRUD.deleteItemById(id);;
	        builder = Response.ok();
        }
        catch(Exception e){
        	Map<String, String> responseObj = new HashMap<String, String>();
            responseObj.put("error", e.getMessage());
            builder = Response.status(Response.Status.BAD_REQUEST).entity(responseObj);
        }
        
        return builder.build();
    }

}
