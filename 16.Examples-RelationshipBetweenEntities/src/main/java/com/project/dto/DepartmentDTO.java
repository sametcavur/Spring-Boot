package com.project.dto;

public class DepartmentDTO {
	private long departmentId;
	private String departmentName;

	public DepartmentDTO() {
		
	}

	public DepartmentDTO(long departmentId, String departmentName) {
		this.departmentId = departmentId;
		this.departmentName = departmentName;
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
		return "DepartmentDTO [departmentId=" + departmentId + ", departmentName=" + departmentName + "]";
	}
}