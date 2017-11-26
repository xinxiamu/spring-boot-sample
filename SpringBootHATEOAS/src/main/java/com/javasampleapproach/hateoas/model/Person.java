package com.javasampleapproach.hateoas.model;

import java.util.ArrayList;
import java.util.List;

import org.springframework.hateoas.ResourceSupport;

public class Person extends ResourceSupport {

	private Long id;
	private String name;

	private List<Order> orders;

	public Person(Long id, String name, ArrayList<Order> orders) {
		this.id = id;
		this.name = name;
		this.orders = new ArrayList<Order>(orders);
	}

	public Long getPersonId() {
		return id;
	}

	public void setPersonId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Order> getOrders() {
		return orders;
	}

	public void setOrders(List<Order> orders) {
		this.orders = orders;
	}

}
