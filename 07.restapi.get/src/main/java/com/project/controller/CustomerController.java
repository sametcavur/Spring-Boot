package com.project.controller;


import java.util.ArrayList;
import java.util.List;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project.model.Customer;

@RestController
public class CustomerController {


	// POST GET OLAYLARINI DAHA İYİ ANLAMAK İÇİN KENDİNİ KULLANICININ YERİNE KOY,
	// SEN KULLANICISIN KARŞINA BİR EKRAN GELECEK EKRANI ALACAKSIN YANİ GET
	// BİLGİ GİRDİN VS BİR İŞLEM YAPACAKSIN İSTEK YOLLADIN YANİ POST
	
	
	//Alttaki produces default olarak json döner
	@GetMapping(value = "/customer",produces = MediaType.APPLICATION_XML_VALUE)
	public List<Customer> customerRest() {
		List<Customer> customers = new ArrayList<Customer>();
		Customer customer1 = new Customer("Samet", "Çavur", "1234");
		Customer customer2 = new Customer("Temas", "Ruvac", "1f13");
		Customer customer3 = new Customer("Kral", "Herkül", "gfm9");
		customers.add(customer3);
		customers.add(customer2);
		customers.add(customer1);
		return customers;
	}
}
