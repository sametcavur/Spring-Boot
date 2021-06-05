package com.project.controller;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
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
	@GetMapping("/getuserinfo")
	@ResponseBody
	public String getCustomerList(@RequestParam(value = "name") String name,
			@RequestParam(value = "surname") String surname, @RequestParam(value = "password") String password) {

		User user = new User(name, surname, password);
		String url = "http://localhost:8080/putuser";
		RestTemplate restTemplate = new RestTemplate();
		ResponseEntity<User> responseEntity = restTemplate.exchange(url, HttpMethod.PUT, new HttpEntity<User>(user),
				User.class);
		User user1 = responseEntity.getBody();
		//Bu üstteki zorunlu değil sadece bilgiyi burada kullanmak için yaptık 
		//Fakat diğer classın dönüş değer olmadığı için istesekte kullanamayız burada
		return "Kayıt Gönderildi...!";
	}

	// BUDA KULLANICININ POST ETTİĞİ BİLGİLERİN BURADA YAZDIRILMASI İŞLEMİ,
	// ÜSTTE VALİD,KONTROL FALAN YAPIP ONAYLARSAK BURAYA GÖNDERİRİZ
	// BURAYA GELEN VERİYİDE VERİ TABANINA KAYDEDERİZ.GÜNCELLERİZ YADA SİLERİZ.
	@PutMapping(value = "/putuser")
	public void postUser(@RequestBody User user) {
		System.out.println(user.getName());
		System.out.println(user.getSurname());
		user.setName("Güncel Samet");
		System.out.println(user.getName());
	}
}
