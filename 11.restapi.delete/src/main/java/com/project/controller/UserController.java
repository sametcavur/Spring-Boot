package com.project.controller;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.project.model.User;

@RestController
public class UserController {

	// POST GET OLAYLARINI DAHA İYİ ANLAMAK İÇİN KENDİNİ KULLANICININ YERİNE KOY,
	// SEN KULLANICISIN KARŞINA BİR EKRAN GELECEK EKRANI ALACAKSIN YANİ GET
	// BİLGİ GİRDİN VS BİR İŞLEM YAPACAKSIN İSTEK YOLLADIN YANİ POST

	// EKRANDA KULLANICININ GÖNDERECEĞİ BİR EKRAN(VİEW),BİR URL FALAN OLMALI İŞTE BU
	// ALLTAKİ METOD O
	@GetMapping("/deleteuserinfo/{name}")
	@ResponseBody
	public String getCustomerList(@PathVariable(value = "name") String name) {
		String url = "http://localhost:8080/deleteuser/"+name;
		RestTemplate restTemplate = new RestTemplate();
		restTemplate.exchange(url, HttpMethod.DELETE, HttpEntity.EMPTY, Void.class);
		// Void class herhangi bir sonuç almıyor demek
		// String sonuc = restTemplate.exchange..... diyip en sona String.class yazıp
		// String sonuç döndürebilirdik.
		return "Kayıt Silindi...!";
	}

	// BUDA KULLANICININ POST ETTİĞİ BİLGİLERİN BURADA YAZDIRILMASI İŞLEMİ,
	// ÜSTTE VALİD,KONTROL FALAN YAPIP ONAYLARSAK BURAYA GÖNDERİRİZ
	// BURAYA GELEN VERİYİDE VERİ TABANINA KAYDEDERİZ.GÜNCELLERİZ YADA SİLERİZ.
	@DeleteMapping(value = "/deleteuser/{name}")
	public void postUser(@PathVariable(value = "name") String name) {
		System.out.println("Kayıt Siliniyor..." + name);
		// Normalde burada veri tabanıyla silme işlemi yapardık.Ama konuyu anlamak için
		// basit bir örnek olduğu için yapmadık.
	}
}
