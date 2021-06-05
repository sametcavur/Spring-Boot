package com.project.client;

import java.util.List;

import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.client.RestTemplate;

import com.project.model.Customer;

@Controller
public class CustomerClient {

	@GetMapping("/getcustomer/{id}")
	@ResponseBody
	public String getCustomer(@PathVariable(value = "id") Integer id) {
		
		//BU HATAYA 1632 KEZ DÜŞTÜN ARTIK ŞU İŞİ DOĞRU YAP....! ALLTAKİ URL BİR REST VERMELİ,
		//CUSTOMER CONTROLLER CLASSINDA O URLYİ GİRİNCE BİR CUSTOMER GETİRİYOR.CLİENT'TA İSE
		//O RESTİ ALIP BURADA KULLANIYOSUN....!!!
		//XML YADA JSON FARKETMEZ CONTROLLER'DA URL'YE NE YOLLADIYSAN ONU ÇIKARTIR BURADA
		String url = "http://localhost:8080/customer/"+id; 
		
		RestTemplate restTemplate = new RestTemplate();
		
		//BU ALTTA JAVADA KULLANABİLECEĞİMİZ BİR NESNE OLARAK ALDIK URL'DEKİ RESTİ
		Customer customer = restTemplate.getForObject(url, Customer.class);
		System.out.println(customer);
		
		//BU ALTTA İSE DİREK JSON OLARAK ALDIK URL'DEKİ RESTİ
		String json = restTemplate.getForObject(url, String.class);
		System.out.println(json);
		
		return "Kullanıcı Alındı,Alınan Kullanıcı İsmi = " + customer.getName();
	}

	
	
	
	//Bu alttaki üsttekinin alternatif yoludur,Üstte yada altta bazen hatalar çıkabiliyor,birbirinin yerine kullanılıyor.
	@GetMapping("/getcustomeralternatif/{id}")
	@ResponseBody
	public String getCustomerAlternatif(@PathVariable(value = "id") Integer id) {
		String url = "http://localhost:8080/customer/"+id; 
		
		RestTemplate restTemplate = new RestTemplate();
		ResponseEntity<Customer> responseEntity = restTemplate.exchange(url, HttpMethod.GET, HttpEntity.EMPTY,Customer.class);
		
		Customer customer = responseEntity.getBody();
		System.out.println(customer);
		
		return "Kullanıcı Alındı,Alınan Kullanıcı İsmi = " + customer.getName();
	}
	
	
	//Eğer tek bir veri değilde client'a list gönderecek olsaydık alttaki gibi gönderecektik.
	@GetMapping("/getcustomerlist")
	@ResponseBody
	public String getCustomerList() {
		String url = "http://localhost:8080/customerjson"; 
		
		RestTemplate restTemplate = new RestTemplate();
		ResponseEntity<List<Customer>> responseEntity = restTemplate.exchange(url, HttpMethod.GET, HttpEntity.EMPTY,new ParameterizedTypeReference<List<Customer>>(){});
		
		List<Customer> customers = responseEntity.getBody();
		for (Customer customer : customers) {
			System.out.println(customer);
		}
		
		return "Kullanıcılar Alındı,Alınan Kullanıcı İsimleri = " + customers;
	}
	
}
