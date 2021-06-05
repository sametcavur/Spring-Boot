package com.project.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Department {

	@Id
	@GeneratedValue
	private long departmentId;
	private String departmentName;
	@OneToMany(mappedBy = "department",cascade = CascadeType.PERSIST)
	private List<Employee> employeeList;
	
	public Department() {
	}

	public Department(long departmentId, String departmentName, List<Employee> employeeList) {
		this.departmentId = departmentId;
		this.departmentName = departmentName;
		this.employeeList = employeeList;
	}

	public long getDepartmentId() {
		return departmentId;
	}

	public void setDepartmentId(long departmentId) {
		this.departmentId = departmentId;
	}

	public String getDepartmentName() {
		return departmentName;
	}

	public void setDepartmentName(String departmentName) {
		this.departmentName = departmentName;
	}
	

	public List<Employee> getEmployeeList() {
		return employeeList;
	}

	public void setEmployeeList(List<Employee> employeeList) {
		this.employeeList = employeeList;
	}

	@Override
	public String toString() {
		return "Department [departmentId=" + departmentId + ", departmentName=" + departmentName + ", employeeList="
				+ employeeList + "]";
	}

}
