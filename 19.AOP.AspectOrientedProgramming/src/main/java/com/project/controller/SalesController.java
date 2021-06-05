package com.project.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;

import com.project.services.SalesServicesImp;

@Controller
public class SalesController {
	
	@Autowired
	SalesServicesImp salesServicesImp;
	
	@ResponseBody
	@GetMapping("/sales/{product}")
	public String sales(@PathVariable (value ="product") String product) {
	return salesServicesImp.salesMessages(product);
	}
}
