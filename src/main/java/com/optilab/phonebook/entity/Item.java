package com.optilab.phonebook.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.Digits;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

@SuppressWarnings("serial")
@Entity
@XmlRootElement
@Table(uniqueConstraints = @UniqueConstraint(columnNames = "phoneNumber"))
@NamedQueries({
    @NamedQuery (name="Item.findAll", query="SELECT i FROM Item i"),
    @NamedQuery (name="Item.findById", query="SELECT i FROM Item i WHERE i.id = :id"),
}) 
public class Item implements Serializable {
	
	@Id
    @GeneratedValue
    private Long id;
	
	@NotNull
    @Size(min = 1, max = 25)
    @Pattern(regexp = "[^0-9]*", message = "Name should be composed of letters.")
    private String name;
	
	@NotNull
    @Size(min = 9, max = 12)
    @Digits(fraction = 0, integer = 12)
    private String phoneNumber;
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
}
