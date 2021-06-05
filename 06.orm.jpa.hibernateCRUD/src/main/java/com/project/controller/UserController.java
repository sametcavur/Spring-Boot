package com.project.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.project.model.User;
import com.project.repository.UserRepository;

@Controller
public class UserController {

	@Autowired
	private UserRepository userRepository;

	// *******************NORMAL KAYIT**************************
	// http://localhost:8080/usersave
	@RequestMapping(value = "/usersave", method = RequestMethod.GET)
	@ResponseBody
	public String saveUser() {
		User user = new User("resul", "mimar", "le19");
		userRepository.save(user);
		return "ID :" + user.getUserName();
	}
	// ************************************************************

	// *******************REQUEST PARAM KAYIT**********************
	// http://localhost:8080/usersave/request?userName=ReqName&userSurname=ReqSurname&password=999L
	@RequestMapping(value = "/usersave/request", method = RequestMethod.GET)
	@ResponseBody
	public String saveUserParam1(@RequestParam(value = "userName") String userName,
			@RequestParam(value = "userSurname") String userSurname,
			@RequestParam(value = "password") String password) {
		User user = new User(userName, userSurname, password);
		userRepository.save(user);
		return "ID :" + user.getUserName();
	}
	// ************************************************************

	// *******************PATH VARİABLE KAYIT**********************
	// http://localhost:8080/usersave/pathName/pathSurname/888L
	@RequestMapping(value = "/usersave/{userName}/{userSurname}/{password}", method = RequestMethod.GET)
	@ResponseBody
	public String saveUserParam2(@PathVariable(value = "userName") String userName,
			@PathVariable(value = "userSurname") String userSurname,
			@PathVariable(value = "password") String password) {
		User user = new User(userName, userSurname, password);
		userRepository.save(user);
		return "User Bilgileri:" + user;
	}
	// ************************************************************

	// *******************FİND İŞLEMİ*******************************
	// http://localhost:8080/finduser/1
	@RequestMapping(value = "/finduser/{userId}", method = RequestMethod.GET)
	@ResponseBody
	public String findUser(@PathVariable(value = "userId") Integer userId) {
		Optional<User> user = userRepository.findById(userId);
		if (user.isPresent()) {
			return "User Bulundu " + user.get().getUserName();
		} else {
			return "User Bulunamadı";
		}
	}
	// *************************************************************

	// *******************UPDATE İŞLEMİ*****************************
	// http://localhost:8080/updateuser/1
	@RequestMapping(value = "/updateuser/{userId}", method = RequestMethod.GET)
	@ResponseBody
	public String updateUser(@PathVariable(value = "userId") Integer userId) {
		Optional<User> optionaluser = userRepository.findById(userId);
		User user = optionaluser.get();
		if (optionaluser.isPresent()) {
			user.setUserName("Güncel Samet");
			userRepository.save(user);
			return "User Güncellendi :" + user.getUserName();
		} else {
			return "User Bulunamadı";
		}
	}
	// *************************************************************

	// *******************SİLME İŞLEMİ*****************************
	// http://localhost:8080/deleteuser/1
	@RequestMapping(value = "/deleteuser/{userId}", method = RequestMethod.GET)
	@ResponseBody
	public String deleteUser(@PathVariable(value = "userId") Integer userId) {
		userRepository.deleteById(userId);
		return "User Silindi";
	}
	// ************************************************************

	// *******************FİND ALL İŞLEMİ*****************************
	// http://localhost:8080/findalluser
	@RequestMapping(value = "/findalluser", method = RequestMethod.GET)
	@ResponseBody
	public String findAllUser() {
		Iterable<User> users = userRepository.findAll();
		int userCount = 0;
		for (@SuppressWarnings("unused")
		User user : users) {
			userCount++;
		}

		return "Kayıtlı User Sayısı : " + userCount;
	}
	// ************************************************************

	// *******************FİND BY NAME İŞLEMİ*****************************
	/*
	 * Bu hazır repository'nin içinde ada göre bulma sorgusu olmadığı için
	 * repository interfacesinin içine gidip kendimiz yazacağız.Normalde birde bu
	 * interfaceyi implement eden class olmalıydı çünkü interfacenin içideki
	 * metodlar doldurulmaz fakat spring boot özelliklerinden biri olan @Query
	 * anotasyonu ile repository interfacesini implement eden başka bir class
	 * olmadan query'i interface içine yazabildik.
	 */
	// http://localhost:8080/findalluser
	@RequestMapping(value = "/finduseruserbyname/{username}", method = RequestMethod.GET)
	@ResponseBody
	public String findUserByName(@PathVariable(value = "username") String userName) {

		List<User> users = userRepository.findByUserName(userName);
		int userCount = 0;

		for (@SuppressWarnings("unused")
		User user : users) {
			userCount++;
		}
		return "Aradığınız isimde kayıtlı olan User sayısı : " + userCount;
	}
	// ************************************************************
}
