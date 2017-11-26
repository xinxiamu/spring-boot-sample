package com.javasampleapproach.hateoas.repo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.javasampleapproach.hateoas.model.Order;
import com.javasampleapproach.hateoas.model.Person;

@Repository
public class PersonRepository {

	private final List<Person> persons = new ArrayList<>();

	public PersonRepository() {
		this.persons.add(
				new Person(1L, "Jack", new ArrayList<Order>(Arrays.asList(new Order(1L, "A"), new Order(2L, "B")))));
		this.persons.add(
				new Person(2L, "Adam", new ArrayList<Order>(Arrays.asList(new Order(1L, "C"), new Order(2L, "D")))));
		this.persons.add(
				new Person(3L, "Kim", new ArrayList<Order>(Arrays.asList(new Order(1L, "E"), new Order(2L, "F")))));
	}

	public List<Person> findAll() {
		return this.persons;
	}

	public Person findOne(Long id) {

		for (Person person : this.persons) {
			if (person.getPersonId().equals(id)) {
				return person;
			}
		}
		return null;
	}
}
