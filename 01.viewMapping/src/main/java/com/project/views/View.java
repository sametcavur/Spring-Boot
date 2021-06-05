package com.project.views;

import java.util.Date;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.project.model.User;

@Controller
public class View {
	@RequestMapping(value = "/index",method = RequestMethod.GET)
	public String view(Model model) {
		Date date = new Date(1997, 8, 27);
		User user = new User(1, "Samet", "Çavur",date);
		model.addAttribute("user",user);
		return "index";
	}
}
