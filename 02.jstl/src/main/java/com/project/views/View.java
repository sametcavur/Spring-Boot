package com.project.views;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.project.model.User;

@Controller
public class View {
	@RequestMapping(value = "/users",method = RequestMethod.GET)
	public String view(Model model) {
		List<User> users = new ArrayList<User>();
		Date date1 = new Date(1997, 8, 27);
		User user1 = new User(1, "Samet", "Çavur",date1);
		Date date2 = new Date(1983, 11, 24);
		User user2 = new User(2, "Metin", "Yıldız",date2);
		Date date3 = new Date(2002, 6, 4);
		User user3 = new User(3, "Fırat", "Arslan",date3);
		users.add(user1);
		users.add(user2);
		users.add(user3);
		model.addAttribute("users",users);
		return "index";
	}
}
