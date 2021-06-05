package com.project.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.project.model.Customer;

@RestController
public class CustomerController {
	
	@GetMapping(value = "/customerxml",produces = MediaType.APPLICATION_XML_VALUE)
	public List<Customer> customerRestXML() {
		List<Customer> customers = new ArrayList<Customer>();
		Customer customer1 = new Customer(1,"Samet", "Çavur", "1234");
		Customer customer2 = new Customer(2,"Temas", "Ruvac", "1f13");
		Customer customer3 = new Customer(3,"Kral", "Herkül", "gfm9");
		customers.add(customer3);
		customers.add(customer2);
		customers.add(customer1);
		return customers;
	}
	

	@GetMapping(value = "/customerjson",produces = MediaType.APPLICATION_JSON_VALUE)
	public List<Customer> customerRestJson() {
		List<Customer> customers = new ArrayList<Customer>();
		Customer customer1 = new Customer(1,"Samet", "Çavur", "1234");
		Customer customer2 = new Customer(2,"Temas", "Ruvac", "1f13");
		Customer customer3 = new Customer(3,"Kral", "Herkül", "gfm9");
		customers.add(customer3);
		customers.add(customer2);
		customers.add(customer1);
		return customers;
	}
	
	//Producese göre xml döndürecek
	@RequestMapping(value = "/customer/{id}",method = RequestMethod.GET,produces = MediaType.APPLICATION_JSON_VALUE)
	public Customer getCustomerById(@PathVariable (value = "id") Integer id) {
		Customer customer = new Customer(id, "ClientName", "ClientSurname", "ClientPassword");
		return customer;
	}
}
