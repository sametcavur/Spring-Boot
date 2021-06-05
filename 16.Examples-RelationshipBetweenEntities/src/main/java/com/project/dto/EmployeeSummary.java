package com.project.dto;

import java.util.List;

public class EmployeeSummary {
	private long employeeCount;
	private long departmentId;
	private String departmentName;
	private List<EmployeeDTO> findEmployeeDTOList;
	
	public EmployeeSummary() {
	}

	public EmployeeSummary(long employeeCount, long departmentId, String departmentName,
			List<EmployeeDTO> findEmployeeDTOList) {
		this.employeeCount = employeeCount;
		this.departmentId = departmentId;
		this.departmentName = departmentName;
		this.findEmployeeDTOList = findEmployeeDTOList;
	}

	public long getEmployeeCount() {
		return employeeCount;
	}

	public void setEmployeeCount(long employeeCount) {
		this.employeeCount = employeeCount;
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

	public List<EmployeeDTO> getFindEmployeeDTOList() {
		return findEmployeeDTOList;
	}

	public void setFindEmployeeDTOList(List<EmployeeDTO> findEmployeeDTOList) {
		this.findEmployeeDTOList = findEmployeeDTOList;
	}

	@Override
	public String toString() {
		return "EmployeeSummary [employeeCount=" + employeeCount + ", departmentId=" + departmentId
				+ ", departmentName=" + departmentName + ", findEmployeeDTOList=" + findEmployeeDTOList + "]";
	}
	
	}
