package com.javasampleapproach.corsjavaconfig.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.javasampleapproach.corsjavaconfig.model.Customer;

@Service
public class CustomerService {

	public List<Customer> getCustomers() {

		List<Customer> list = new ArrayList<>();
		list.add(new Customer(1L, "Jack"));
		list.add(new Customer(2L, "Adam"));
		list.add(new Customer(3L, "Kim"));

		return list;
	}
}
