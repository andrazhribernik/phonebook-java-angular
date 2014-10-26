package com.optilab.phonebook.crud;

import java.util.List;
import java.util.logging.Logger;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import com.optilab.phonebook.entity.Item;

@Stateless
public class ItemCRUD {
	
	@Inject
	private Logger log;

    @Inject
    private EntityManager em;
    
    public Item getItem(Long id) throws Exception {
    	Item i = (Item) em.createNamedQuery("Item.findById").setParameter("id", id)
    		      .getSingleResult();
    	return i;
    }
    

    public void addItem(Item item) throws Exception {
        log.info("Inserting " + item.getName());
        em.persist(item);
    }
    
    public void deleteItemById(Long id) throws NoResultException, Exception {
    	Item i = (Item) em.createNamedQuery("Item.findById").setParameter("id", id)
  		      .getSingleResult();
    	if (i == null) {
    		throw new NoResultException();
    	}
    	
    	try {
	    	em.remove(i);
	    	log.info("Item with id " + id + "is deletted");
    	}
    	catch (Exception e){
    		throw e;
    	}
    }
    
    public void editItemById(Item item) throws NoResultException, Exception {
    	Item i = (Item) em.createNamedQuery("Item.findById").setParameter("id", item.getId())
  		      .getSingleResult();
    	if (i == null) {
    		throw new NoResultException();
    	}
    	
    	try {
    		i.setName(item.getName());
    		i.setPhoneNumber(item.getPhoneNumber());
	    	em.persist(i);;
	    	log.info("Item with id " + i.getId() + "is updated");
    	}
    	catch (Exception e){
    		throw e;
    	}
    }
    
    public List<Item> getAll() {
    	return (List <Item>) em.createNamedQuery("Item.findAll")
        .getResultList();
    }
}
