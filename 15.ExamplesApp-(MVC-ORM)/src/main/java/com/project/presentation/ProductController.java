package com.project.presentation;

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

import com.project.entity.Product;
import com.project.repository.ProductRepository;

@Controller
public class ProductController {
	
	//UPDATE OPERATİONS'DA BİR SORUN VAR,ONUNLA UĞRAŞ

	@Autowired
	ProductRepository productRepository;

	//**************WELCOME***************
	@GetMapping("/welcome")
	public String welcomePage() {
		return "welcome";
	}

	// **************İNSERT****************
	@GetMapping("/productinsert")
	public String insertProduct(Model model) {
		Product product = new Product(0," ",0.0); // Gösterim Katmanına ilk boş bir sayfa gitmeli o yüzden değerler boş	
		model.addAttribute("product", product);
		return "/productinsert";
	}
 
	@PostMapping("/productinsert")
	public String insertProduct(Product product, BindingResult bindingResult, Model model) {
		productRepository.save(product);
		if (bindingResult.hasErrors()) {
			return "/productinsert";
		} else {
			model.addAttribute("mesaj", "Ürününüz Başarıyla Kaydedilmiştir.");
			return "/productsuccess";
		}
	}
	
	//************UPDATE**************
	@GetMapping("/productedit")
	public String editProduct() {
		return "/productedit";
	}
	
	@PostMapping("/productedit") 
	public String editProduct(@RequestParam long productId, Model model) {
		Optional<Product> optional =  productRepository.findById(productId);
		Product product = optional.get();
		model.addAttribute("product", product);
		return "/productinsert";
	}

	// **************DELETE****************
	@GetMapping("/productdelete")
	public String deleteProduct() {
		return "/productdelete";
	}

	@RequestMapping(value = "/productdelete", method = RequestMethod.POST)
	public String deleteProduct(@RequestParam long productId, Model model) {
		productRepository.deleteById(productId);

		Iterable<Product> products = productRepository.findAll();
		model.addAttribute("product", products);
		return "/productlist";
	}

	// **************LİST******************
	@GetMapping("/productlist")
	public String listProduct(Model model) {
		Iterable<Product> products = productRepository.findAll();
		model.addAttribute("product", products);
		return "/productlist";
	}
}
