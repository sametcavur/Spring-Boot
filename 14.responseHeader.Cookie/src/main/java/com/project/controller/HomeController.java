package com.project.controller;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.client.RestTemplate;

@Controller
public class HomeController {

	//Aslında Request Header'da yaptığımız işlemin tam tersi orada client'tan servise 
	//bir header yolluyorduk burdada servisten client'a bir header yollayacağız.
	
	
	// Request Param,Path Variable gibi değişkenler url'de gözüküyor.
	// Fakat headerlar gözükmez.Sayfanın arkasından gönderilir.

	@GetMapping(value = "/getheader")
	@ResponseBody
	public String getHeader() {
		String url = "http://localhost:8080/transferheader";
		RestTemplate restTemplate = new RestTemplate();
		ResponseEntity<String> responseEntity = restTemplate.exchange(url, HttpMethod.GET,HttpEntity.EMPTY, String.class);
		String header = responseEntity.getHeaders().getFirst("header");
		return responseEntity.getBody() + "  >>  Header Alındı >> " + header ;
	}

	
	@GetMapping(value = "/transferheader")
	public ResponseEntity<?> transferheader() {
		return ResponseEntity.ok().header("header","GÖNDERDIGIMIZ HEADER'IMIZ").body("Header Gönderildi...");
	}
	
	
	
	
	
	//************************************************************************************************************************************************
	//COOKİE-ÇEREZLER
	//Cookieler zaten header içinde gönderiliyor. O yüzden büyük bi değişiklik yok aşağıda
	
	@GetMapping(value = "/getcookie")
	@ResponseBody
	public String getCookie() {
		String url = "http://localhost:8080/transfercookie";
		RestTemplate restTemplate = new RestTemplate();
		ResponseEntity<String> responseEntity = restTemplate.exchange(url, HttpMethod.GET,HttpEntity.EMPTY, String.class);
		String header = responseEntity.getHeaders().getFirst(HttpHeaders.SET_COOKIE);
		return responseEntity.getBody() + "  >>  Cookie Alındı >> " + header ;
	}

	
	@GetMapping(value = "/transfercookie")
	public ResponseEntity<?> transferCookie() {
		return ResponseEntity.ok().header(HttpHeaders.SET_COOKIE,"GÖNDERILEN COOKIE").body("Cookie Gönderildi...");
	}
	
	
	
	
	
	
}
