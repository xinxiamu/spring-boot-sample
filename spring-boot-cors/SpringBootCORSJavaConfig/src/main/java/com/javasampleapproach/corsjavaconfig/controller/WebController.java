package com.javasampleapproach.corsjavaconfig.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.javasampleapproach.corsjavaconfig.model.Customer;
import com.javasampleapproach.corsjavaconfig.service.CustomerService;

@RestController
public class WebController {

	@Autowired
	private CustomerService service;

	@RequestMapping("customers")
	public List<Customer> getCustomers() {

		List<Customer> list = service.getCustomers();
		return list;
	}

	@RequestMapping("data")
//	@CrossOrigin(origins = { "http://localhost:63342", "http://localhost:9000" }, maxAge = 6000) //覆盖全局跨域
	public List<Customer> getData() {

		List<Customer> list = service.getCustomers();
		list.forEach(item -> item.setName(item.getName().toUpperCase()));

		return list;
	}
}