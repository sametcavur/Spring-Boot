package com.project.controller;

import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.project.model.Employee;

@RestController
public class Controller {

	//Ekranda ilk boş bir sayfa,boş bir form gözükmesi için get ile form yolladık.
	@GetMapping("/employee")
	public ModelAndView getMethod() {
		ModelAndView modelAndView = new ModelAndView("index");
		Employee employee = new Employee(0, "", "", 0);
		modelAndView.addObject("employee", employee);
		return modelAndView;
	}

	@PostMapping("/employee")
	public ModelAndView postMethod(Employee employee, BindingResult bindingResult) {
		// Bu alttaki metotta hata olursa aynı sayfada kalmasını söyledik
		if (bindingResult.hasErrors()) {
			ModelAndView modelAndView = new ModelAndView("index");
			return modelAndView;
		}

		// Bir fieldi kapsülleyip özel hata döndürdük.
		if (employee.getEmployeeName().length() < 3) {
			// Bu alttaki hata bütün formu kapsayacak en üstte gösterilen hata
			bindingResult.addError(new ObjectError("employee", "Lütfen Bilgileri Tekrar Kontrol Ediniz."));
			// Bu alttaki hata ise formun belli bir fieldinda çıkacak hata içindir
			bindingResult.addError(new FieldError("employee", "employeeName", "Lütfen Geçerli Bir İsim Giriniz."));
			ModelAndView modelAndView = new ModelAndView("index");
			return modelAndView;
		}

		// Buradaysa hata yoksa success form adında viewe git dedik
		else {
			System.out.println("Çalışan ID : " + employee.getEmployeeId());
			System.out.println("Çalışan Adı : " + employee.getEmployeeName());
			System.out.println("Çalışan Soyadı : " + employee.getEmployeeSurname());
			System.out.println("Çalışan Maaşı : " + employee.getEmployeeSalary());
			ModelAndView modelAndView = new ModelAndView("successform");
			modelAndView.addObject("mesaj", "Tebrikler Giriş Başarılı.!");
			return modelAndView;
		}

	}
}
