package com.project.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {

	@Bean
	public AppProperties appProperties() {
		AppProperties appProperties = new AppProperties();
		return appProperties;
	}
}
