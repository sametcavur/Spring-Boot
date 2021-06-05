package com.project.controller;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
public class Controller {

	@RequestMapping(value = "/variable/{myId}")
	public ModelAndView pathVariable(@PathVariable(value = "myId") String myId) {
		ModelAndView modelAndView = new ModelAndView("pathvariable");
		modelAndView.addObject("myId", myId);
		return modelAndView;
	}
	@RequestMapping(value = "/variable/{myName}/{myId}")
	public ModelAndView multiPathVariable(@PathVariable(value = "myId") String myId,@PathVariable(value = "myName") String myName) {
		ModelAndView modelAndView = new ModelAndView("pathvariable");
		modelAndView.addObject("myId", myId);
		modelAndView.addObject("myName", myName);
		return modelAndView;
	}
	
	//RequestParam Anotasyonu url'de eğer myId=... bişi varsa onu alır burdaki myId değişkenine atar
	//Fakat url'de /request sorgusuyla çağıracağımız için requestten sonra tire olmaz.
	//Buradaki gibi bir url olmalı >>>>>   http://localhost:8080/request?myId=1234
	@RequestMapping(value = "/request")
	public ModelAndView requestParam(@RequestParam(value = "myId") String myId) {
		ModelAndView modelAndView = new ModelAndView("requestparam");
		modelAndView.addObject("myId", myId);
		return modelAndView;
	}
	@RequestMapping(value = "/multirequest")
	public ModelAndView multiRequestParam(
			@RequestParam(value = "myId") String myId,
			@RequestParam(value = "myName") String myName) {
		ModelAndView modelAndView = new ModelAndView("requestparam");
		modelAndView.addObject("myId", myId);
		modelAndView.addObject("myName", myName);
		return modelAndView;
	}
	
}
