package com.project.controller;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
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
	
	
	
	//*****ÖNEMLİ******//
	//Bu ResponseEntity'nin olayı aslıdna değiş-tokuş kiii resttemplate.exchange diyoruz.
	//Şöyle ki ResponseEntity<User> responseEntity = restTemplate.exchange(url, HttpMethod.POST, new HttpEntity<User>(user),User.class);
	//Bu üstteki kodun türkçesi şu :
	//1-ResponseEntity<XXXX> = Bu bizim post işlemini yaptığımız yani en altta ki metodun return değeri XXXX,
	//Yani biz post etmen için sana birşey veriyoruz sende bize birşey ver(değiş-tokuş)
	//2-restTemplate.exchange = restTemplate şablonu sayesinde değiş-tokuş işlemini yap
	//3-url = değiştokuş yapılacak url adresi
	//4-HttpMethod.POST = değiştokuş yapılacak metodun post mu get mi put mu olduğu
	//5-new HttpEntity<User>(user) = değiştokuş yapılacak metoda gönderilecek olan entity
	//6-User.class = değiştokuş yapılacak classtan gelecek XXXX'in türü
	
	//User user1 = responseEntity.getBody();
	//Bu üsttekinin türkçesi ise
	//responseEntity.getBody() = değiştokuş yaptığın metoddan her ne aldıysan bunun içinde tut.
	

	
	
	
	
	
	
	// EKRANDA KULLANICININ GÖNDERECEĞİ BİR EKRAN(VİEW),BİR URL FALAN OLMALI İŞTE BU
	// ALLTAKİ METOD O 
	//BUNUN ALTINDAKİ METODDA BUNUN YAPTIĞI İŞİ YAPIYOR
	@GetMapping(value = "/getuser")
	@ResponseBody
	public String getUser(@RequestParam(value = "name") String name, @RequestParam(value = "surname") String surname,
			@RequestParam(value = "password") String password) {
		User user = new User(name, surname, password);

		String url = "http://localhost:8080/postuser";
		RestTemplate restTemplate = new RestTemplate();
		restTemplate.postForObject(url, user, Void.class);

		return "KAYIT GÖNDERİLDİ..!";
	}

	// Bu alttaki üsttekinin alternatif yoludur,Üstte yada altta bazen hatalar
	// çıkabiliyor,birbirinin yerine kullanılıyor.
	@GetMapping("/getuseralternatif")
	@ResponseBody
	public String getCustomerList(@RequestParam(value = "name") String name,@RequestParam(value = "surname") String surname,
			@RequestParam(value = "password") String password) {

		User user = new User(name, surname, password);
		String url = "http://localhost:8080/postuser";
		RestTemplate restTemplate = new RestTemplate();
		ResponseEntity<User> responseEntity = restTemplate.exchange(url, HttpMethod.POST, new HttpEntity<User>(user),User.class);
		User user1 = responseEntity.getBody();
		return "Kayıt Gönderildi...!" + user1.getName();
	}

	
	// BUDA KULLANICININ POST ETTİĞİ BİLGİLERİN BURADA YAZDIRILMASI İŞLEMİ,
	// ÜSTTE VALİD,KONTROL FALAN YAPIP ONAYLARSAK BURAYA GÖNDERİRİZ
	// BURAYA GELEN VERİYİDE VERİ TABANINA KAYDEDERİZ.GÜNCELLERİZ YADA SİLERİZ.
	@PostMapping(value = "/postuser")
	@ResponseBody
	public User postUser(@RequestBody User user) {
		System.out.println(user.getName());
		System.out.println(user.getSurname());
		System.out.println(user.getPassword()); 
		return user;
	}
}
