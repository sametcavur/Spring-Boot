package com.project.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.project.config.AppProperties;

@Controller
public class AppController {

	@Autowired
	AppProperties appProperties;
	
	@ResponseBody
	@GetMapping("/getbean")
	public String getBean() {
		return "Bean site =" + appProperties.getSite()   + "      ||||      Bean mail ="+ appProperties.getEmailAdress() ;
	}
}
