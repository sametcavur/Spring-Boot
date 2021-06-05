package com.project.model;
	
public class User {
	private String name;
	private String surname;
	private String password;

	public User() {
	}

	public User(String name, String surname, String password) {
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
		return "User [name=" + name + ", surname=" + surname + ", password=" + password + "]";
	}

}
