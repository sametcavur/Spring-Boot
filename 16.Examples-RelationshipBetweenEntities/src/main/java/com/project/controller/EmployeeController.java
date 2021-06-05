package com.project.controller;

import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import com.project.entity.Employee;
import com.project.repository.EmployeeRepository;

@Controller
public class EmployeeController {

	@Autowired
	EmployeeRepository employeeRepository;

	// **************WELCOME***************
	@GetMapping("/welcome")
	public String welcomePage() {
		return "welcome";
	}

	// **************İNSERT****************
	@GetMapping("/employeeinsert")
	public String insertEmployee(Model model) {
		Employee employee = new Employee(null, " ", 0, null);
		model.addAttribute("employee", employee);
		return "/employeeinsert";
	}

	@PostMapping("/employeeinsert")
	public String insertEmployee(Employee employee, BindingResult bindingResult, Model model) {
		
		employeeRepository.save(employee);
		if (bindingResult.hasErrors()) {
			return "/employeeinsert";
		} else {
			model.addAttribute("mesaj", "Employee Başarıyla Kaydedilmiştir.");
			return "/employeesuccess";
		}
	}

	// ************UPDATE**************
	@GetMapping("/employeeedit")
	public String editEmployee() {
		return "/employeeedit";
	}

	@PostMapping("/employeeedit")
	public String editEmployee(@RequestParam long employeeId, Model model) {
		Optional<Employee> optional = employeeRepository.findById(employeeId);
		Employee employee = optional.get();
		model.addAttribute("employee", employee);
		employeeRepository.save(employee);
		return "/employeeinsert";
	}

	// **************DELETE****************
	@GetMapping("/employeedelete")
	public String employeeProduct() {
		return "/employeedelete";
	}

	@RequestMapping(value = "/employeedelete", method = RequestMethod.POST)
	public String deleteProduct(@RequestParam long employeeId, Model model) {
		employeeRepository.deleteById(employeeId);

		Iterable<Employee> employee = employeeRepository.findAll();
		model.addAttribute("employee", employee);
		return "/employeelist";
	}

	// **************LİST******************
	@GetMapping("/employeelist")
	public String listEmployee(Model model) {
		Iterable<Employee> employee = employeeRepository.findAll();
		model.addAttribute("employee", employee);
		return "/employeelist";
	}
}
