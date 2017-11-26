package com.javasampleapproach.hateoas.repo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.javasampleapproach.hateoas.model.Customer;
import com.javasampleapproach.hateoas.model.Order;

@Repository
public class CustomerRepository {

	private final List<Customer> customers = new ArrayList<>();

	public CustomerRepository() {
		this.customers.add(
				new Customer(1L, "Jack", 
						new ArrayList<Order>(Arrays.asList(new Order(1L, "A"), new Order(2L, "B")))
							));
		this.customers.add(
				new Customer(2L, "Adam", 
						new ArrayList<Order>(Arrays.asList(new Order(1L, "C"), new Order(2L, "D")))
							));
		this.customers.add(
				new Customer(3L, "Kim", 
						new ArrayList<Order>(Arrays.asList(new Order(1L, "E"), new Order(2L, "F")))
							));
	}

	public List<Customer> findAll() {
		return this.customers;
	}

	public Customer findOne(Long id) {

		for (Customer customer : this.customers) {
			if (customer.getCustomerId().equals(id)) {
				return customer;
			}
		}
		return null;
	}
}
