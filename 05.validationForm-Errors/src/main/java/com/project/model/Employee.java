package com.project.model;

public class Employee {
	private int employeeId;
	private String employeeName;
	private String employeeSurname;
	private long employeeSalary;

	public Employee() {
	}
	public Employee(int employeeId, String employeeName, String employeeSurname, long employeeSalary) {
		this.employeeId = employeeId;
		this.employeeName = employeeName;
		this.employeeSurname = employeeSurname;
		this.employeeSalary = employeeSalary;
	}
	public int getEmployeeId() {
		return employeeId;
	}
	public void setEmployeeId(int employeeId) {
		this.employeeId = employeeId;
	}
	public String getEmployeeName() {
		return employeeName;
	}
	public void setEmployeeName(String employeeName) {
		this.employeeName = employeeName;
	}
	public String getEmployeeSurname() {
		return employeeSurname;
	}
	public void setEmployeeSurname(String employeeSurname) {
		this.employeeSurname = employeeSurname;
	}
	public long getEmployeeSalary() {
		return employeeSalary;
	}
	public void setEmployeeSalary(long employeeSalary) {
		this.employeeSalary = employeeSalary;
	}
	@Override
	public String toString() {
		return "Employee [employeeId=" + employeeId + ", employeeName=" + employeeName + ", employeeSurname="
				+ employeeSurname + ", employeeSalary=" + employeeSalary + "]";
	}
}
