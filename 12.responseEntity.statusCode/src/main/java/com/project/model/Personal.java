package com.project.model;

public class Personal {
	private Integer id;
	private String name;
	private String surname;
	private String password;
	public Personal() {
	}
	public Personal(Integer id, String name, String surname, String password) {
		this.id = id;
		this.name = name;
		this.surname = surname;
		this.password = password;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
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
		return "Personal [id=" + id + ", name=" + name + ", surname=" + surname + ", password=" + password + "]";
	}
}
