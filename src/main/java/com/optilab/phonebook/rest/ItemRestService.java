package com.optilab.phonebook.rest;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.optilab.phonebook.entity.Item;

@Path("/items")
public class ItemRestService {
	
	@Inject
    private Logger log;
	
	@GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Item> listAllMembers() {
		Item i = new Item();
		i.setName("Milan");
		i.setPhoneNumber("123456789");;
        List<Item> items = new ArrayList<Item>();
        items.add(i);
        
        return items;
    }

}
