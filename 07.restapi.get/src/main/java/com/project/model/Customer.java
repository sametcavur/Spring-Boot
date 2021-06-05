package com.project.model;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class Customer {
	@XmlElement(name = "name")
	private String name;
	@XmlElement(name = "surname")
	private String surname;
	@XmlElement(name = "password")
	private String password;
	public Customer() {
	}
	public Customer(String name, String surname, String password) {
		this.name = name;
		this.surname = surname;
		this.password = password;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSurname() {
		return surname;
	}
	public void setSurname(String surname) {
		this.surname = surname;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	@Override
	public String toString() {
		return "Customer [name=" + name + ", surname=" + surname + ", password=" + password + "]";
	}
}
