package com.project.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import com.project.bean.MyBean;
import com.project.bean.MyBeann;

@Controller
public class AppController {

	@Autowired
	MyBean myBean1;
	
	@Autowired
	MyBean myBean2;
	
	@Autowired
	MyBeann myBean3;
	
	@ResponseBody
	@GetMapping("/getbean1")
	public String getBean1() {
		return "Bean=" +myBean1.toString() +"-----"+ myBean1.hashCode();
	}
	
	@ResponseBody
	@GetMapping("/getbean2")
	public String getBean2() {
		return "Bean=" +myBean2.toString() +"-----"+ myBean2.hashCode();
	}
	
	@ResponseBody
	@GetMapping("/getbean3")
	public String getBean3() {
		return "Bean=" +myBean3;
	}
}
