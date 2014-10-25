package com.optilab.phonebook.crud;

import java.util.List;
import java.util.logging.Logger;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import com.optilab.phonebook.entity.Item;

@Stateless
public class ItemCRUD {


    @Inject
    private EntityManager em;


    public void addItem(Item item) throws Exception {
        //log.info("Inserting " + item.getName());
        em.persist(item);
    }
    
    public List<Item> getAll() {
    	return (List <Item>) em.createNamedQuery("Item.findAll")
        .getResultList();
    }
}
