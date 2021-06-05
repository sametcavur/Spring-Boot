package com.project.controller;

import org.springframework.http.HttpCookie;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.client.RestTemplate;

@Controller
public class HomeController {

	// Request Param,Path Variable gibi değişkenler url'de gözüküyor.
	// Fakat headerlar gözükmez.Sayfanın arkasından gönderilir.

	@GetMapping(value = "/getheader")
	@ResponseBody
	public String getHeader() {
		String url = "http://localhost:8080/transferheader";
		HttpHeaders httpHeaders = new HttpHeaders(); // Header oluşturabilmek için Header nesnesi oluşturmak lazım
		httpHeaders.add("inputheader", "HEADERIMIZ"); // Birden fazla headerımız olabilir bu yüzden,list gibi işliyo  buda
		//Üstteki key göndereceğimiz metodda ki request headerdaki value ile aynı olmalı
		
		HttpEntity<String> httpEntity = new HttpEntity<String>("GÖVDE-BODY", httpHeaders); // Header gönderebilmek için bir http entitymizin
																							// olması lazım ki onun için koyabilelim
		RestTemplate restTemplate = new RestTemplate();
		ResponseEntity<String> responseEntity = restTemplate.exchange(url, HttpMethod.GET, httpEntity, String.class);
		
		return "Headers Gönderildi : " + responseEntity.getBody();
	}

	
	
	@GetMapping(value = "/transferheader")
	public ResponseEntity<?> transferheader(@RequestHeader(value = "inputheader") String inputHeader) {
		String geriDonecekString = "Gelen Header >>>" + inputHeader;
		return ResponseEntity.ok(geriDonecekString);
	}
	
	
	
	
	
	//************************************************************************************************************************************************
	//COOKİE-ÇEREZLER
	//Cookieler zaten header içinde gönderiliyor. O yüzden büyük bi değişiklik yok aşağıda
	
	
	@GetMapping(value = "/getcookie")
	@ResponseBody
	public String getCookie() {
		String url = "http://localhost:8080/transfercookie";
		HttpHeaders httpHeaders = new HttpHeaders(); // Cookie oluşturabilmek için Header nesnesi oluşturmak lazım
		httpHeaders.add(HttpHeaders.COOKIE, "cookie=COOKİEMİZ-ÇEREZİMİZ"); // Birden fazla cookiemiz olabilir bu yüzden,list gibi işliyo  buda
		//Headerla arasındaki tek fark bu üstteki kodda ufak bi değişiklik var,cookieler zaten header içinde gönderiliyor.
		
		HttpEntity<String> httpEntity = new HttpEntity<String>("GÖVDE-BODY", httpHeaders); // Cookie gönderebilmek için bir http entitymizin
																							// olması lazım ki onun için koyabilelim
		RestTemplate restTemplate = new RestTemplate();
		ResponseEntity<String> responseEntity = restTemplate.exchange(url, HttpMethod.GET, httpEntity, String.class);
		
		return "Cookie Gönderildi : " + responseEntity.getBody();
	}

	
	//COOKİE VALUE ANOTASYONU
	@GetMapping(value = "/transfercookie")
	public ResponseEntity<?> transferCookie(@CookieValue(value = "cookie") String cookie) { 
		String geriDonecekString = "Gelen Cookie >>>" + cookie;
		return ResponseEntity.ok(geriDonecekString);
	}
	
	
	
	
	
	
}
