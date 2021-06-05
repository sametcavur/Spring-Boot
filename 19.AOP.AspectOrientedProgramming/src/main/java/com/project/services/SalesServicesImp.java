package com.project.services;

import org.springframework.stereotype.Service;

@Service
public class SalesServicesImp implements SalesServices{

	@Override
	public String salesMessages(String product) {
		return "Ürün Satılıyor >>" +product;
	}

}
