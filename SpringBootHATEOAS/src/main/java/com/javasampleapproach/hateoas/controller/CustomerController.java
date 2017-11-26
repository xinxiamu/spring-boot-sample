package com.javasampleapproach.hateoas.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.EntityLinks;
import org.springframework.hateoas.ExposesResourceFor;
import org.springframework.hateoas.Resource;
import org.springframework.hateoas.Resources;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.*;

import java.util.List;

import com.javasampleapproach.hateoas.model.Customer;
import com.javasampleapproach.hateoas.model.Order;
import com.javasampleapproach.hateoas.repo.CustomerRepository;

@RestController
@ExposesResourceFor(Customer.class)
@RequestMapping("/customers")
public class CustomerController {

	@Autowired
	private CustomerRepository repository;

	@Autowired
	private EntityLinks entityLinks;

	@RequestMapping(produces = MediaType.APPLICATION_JSON_VALUE)
	public Resources<Customer> getCustomers() {

		Resources<Customer> resources = new Resources<>(this.repository.findAll());
		resources.add(this.entityLinks.linkToCollectionResource(Customer.class));

		return resources;
	}

	@RequestMapping(path = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public Resource<Customer> getCustomer(@PathVariable Long id) {

		Customer customer = this.repository.findOne(id);

		Resource<Customer> resource = new Resource<>(customer);
		resource.add(this.entityLinks.linkToSingleResource(Customer.class, id));
		resource.add(linkTo(methodOn(CustomerController.class).getOrdersForCustomer(id)).withRel("allOrders"));

		return resource;
	}

	@RequestMapping(path = "/{id}/orders")
	public List<Order> getOrdersForCustomer(@PathVariable Long id) {

		return this.repository.findOne(id).getOrders();
	}

}
