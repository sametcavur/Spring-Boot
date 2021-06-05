package com.project.model;

import java.util.Date;

public class User {
	private int userId;
	private String userName;
	private String userSurname;
	private Date birthOfDate;
	public User() {
	}
	public User(int userId, String userName, String userSurname, Date birthOfDate) {
		this.userId = userId;
		this.userName = userName;
		this.userSurname = userSurname;
		this.birthOfDate = birthOfDate;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getUserSurname() {
		return userSurname;
	}
	public void setUserSurname(String userSurname) {
		this.userSurname = userSurname;
	}
	public Date getBirthOfDate() {
		return birthOfDate;
	}
	public void setBirthOfDate(Date birthOfDate) {
		this.birthOfDate = birthOfDate;
	}
	@Override
	public String toString() {
		return "User [userId=" + userId + ", userName=" + userName + ", userSurname=" + userSurname + "]";
	}
	
}
