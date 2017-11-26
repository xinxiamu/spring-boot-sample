package com.javasampleapproach.hateoas.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.*;

import java.util.List;

import com.javasampleapproach.hateoas.model.Person;
import com.javasampleapproach.hateoas.model.Order;
import com.javasampleapproach.hateoas.repo.PersonRepository;

@RestController
@RequestMapping("/persons")
public class PersonController {

	@Autowired
	private PersonRepository repository;

	@RequestMapping("")
	public List<Person> getAllPersons() {

		List<Person> persons = this.repository.findAll();

		persons.forEach(person -> {
			person.removeLinks();
			person.add(linkTo(PersonController.class).slash(person.getPersonId()).withSelfRel());
		});

		return persons;
	}

	@RequestMapping("/{id}/orders")
	public List<Order> getOrdersForPerson(@PathVariable Long id) {

		return this.repository.findOne(id).getOrders();
	}

	@RequestMapping("/{id}")
	public Person getTestPerson(@PathVariable Long id) {

		Person person = this.repository.findOne(id);

		person.removeLinks();
		person.add(linkTo(PersonController.class).slash(person.getPersonId()).withSelfRel());
		person.add(linkTo(methodOn(PersonController.class).getOrdersForPerson(id)).withRel("allOrders"));

		return person;
	}
}
