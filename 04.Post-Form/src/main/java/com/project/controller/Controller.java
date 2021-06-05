package com.project.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.project.model.Employee;

@RestController
public class Controller {

	@GetMapping("/employee")
	public ModelAndView getMethod() {
		ModelAndView modelAndView = new ModelAndView("index");
		Employee employee = new Employee(0, "", "", 0);
		modelAndView.addObject("employee", employee);
		return modelAndView;
	}

	@PostMapping("/employee")
	public ModelAndView postMethod(Employee employee) {
		System.out.println("Çalışan ID : " + employee.getEmployeeId());
		System.out.println("Çalışan Adı : " + employee.getEmployeeName());
		System.out.println("Çalışan Soyadı : " + employee.getEmployeeSurname());
		System.out.println("Çalışan Maaşı : " + employee.getEmployeeSalary());
		ModelAndView modelAndView = new ModelAndView("index");
		return modelAndView;
	}
}
