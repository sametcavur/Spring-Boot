package com.project.dto;

public class EmployeeDTO {
	private Long employeeId;
	private String employeeName;
	private double monthlySalary;
	private long departmentId;
	private String departmentName;
	
	public EmployeeDTO() {

	}

	public EmployeeDTO(Long employeeId, String employeeName, double monthlySalary, long departmentId,
			String departmentName) {
		this.employeeId = employeeId;
		this.employeeName = employeeName;
		this.monthlySalary = monthlySalary;
		this.departmentId = departmentId;
		this.departmentName = departmentName;
	}

	public Long getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(Long employeeId) {
		this.employeeId = employeeId;
	}

	public String getEmployeeName() {
		return employeeName;
	}

	public void setEmployeeName(String employeeName) {
		this.employeeName = employeeName;
	}

	public double getMonthlySalary() {
		return monthlySalary;
	}

	public void setMonthlySalary(double monthlySalary) {
		this.monthlySalary = monthlySalary;
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

	@Override
	public String toString() {
		return "EmployeeDTO [employeeId=" + employeeId + ", employeeName=" + employeeName + ", monthlySalary="
				+ monthlySalary + ", departmentId=" + departmentId + ", departmentName=" + departmentName + "]";
	}
}