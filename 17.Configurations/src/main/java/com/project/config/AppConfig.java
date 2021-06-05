package com.project.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.project.bean.MyBean;
import com.project.bean.MyBeann;

@Configuration
public class AppConfig {

	@Bean(initMethod = "initMetod",destroyMethod = "destroyMetod") //init metod bu metoddan önce çağrılacak metod,destroy sonra çağrılacak metod
	//@Scope("prototype")//Aşağıdaki nesneden birden fazla üretirsek,farklı farklı nesneler olacak,değerler aynı ama nesne farklı
	public MyBean myBean() {
		MyBean bean = new MyBean(1, "First Bean", 10);
		return bean;
	}
	@Bean
	public MyBeann myBeann() {
		MyBeann bean = new MyBeann(1,"Main Bean",myBean());
		return bean;
	}
}
