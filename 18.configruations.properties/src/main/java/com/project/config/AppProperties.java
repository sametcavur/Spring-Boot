package com.project.config;

import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties(prefix = "infos")
public class AppProperties {
	private String site;
	
	private String emailAdress;
	public AppProperties() {
	}
	public AppProperties(String site, String emailAdress) {
		this.site = site;
		this.emailAdress = emailAdress;
	}
	public String getSite() {
		return site;
	}
	public void setSite(String site) {
		this.site = site;
	}
	public String getEmailAdress() {
		return emailAdress;
	}
	public void setEmailAdress(String emailAdress) {
		this.emailAdress = emailAdress;
	}
	@Override
	public String toString() {
		return "AppProperties [site=" + site + ", emailAdress=" + emailAdress + "]";
	}
}
