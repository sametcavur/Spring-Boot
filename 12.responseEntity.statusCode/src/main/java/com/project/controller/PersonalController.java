package com.project.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.project.model.Personal;

@RestController
public class PersonalController {

	// BU BİZİM NORMAL DÖNDÜRDÜĞÜMÜZ REST'İN BASİT YAPILIŞI
	@GetMapping("/getpersonal")
	public Personal getPersonal() {
		Personal personal = new Personal(1, "Samet", "Çavur", "1234");
		return personal;
	}

	// BUDA OLMASI GEREKEN,ÜSTÜNDE DEĞİŞİKLİKLER YAPABİLECEĞİMİZ REST
	@GetMapping("/getpersonall")
	public ResponseEntity<?> getPersonall() {
		Personal personal = new Personal(1, "Samet", "Çavur", "1234");
		return ResponseEntity.ok(personal);
		// return ResponseEntity.ok().body(personal);
		// return ResponseEntity.status(HttpStatus.OK).body(personal);
		// return new ResponseEntity<>(personal,HttpStatus.OK);
	}

	//Eğer 404 NOT FOUND HATASI GELİRSE KULLANICIYI NASIL KARŞILAYACAĞIZ?
	@GetMapping("/getpersonalnotfound/{id}")
	public ResponseEntity<?> getPersonalNotFound(@PathVariable(value = "id") Integer id) {
		Personal personal = new Personal(id, "Samet", "Çavur", "1234");
		if (id == 0) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("SAYFA BULUNAMADI...!");
		} else {
			return ResponseEntity.ok(personal);
		}
	}
}
