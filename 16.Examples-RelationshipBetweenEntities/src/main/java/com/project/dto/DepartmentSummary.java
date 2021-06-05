package com.project.dto;

import java.util.List;

public class DepartmentSummary {
	List<DepartmentDTO> findAllDepartment;
	
	public DepartmentSummary() {
	}

	public DepartmentSummary(List<DepartmentDTO> findAllDepartment) {
		this.findAllDepartment = findAllDepartment;
	}

	public List<DepartmentDTO> getFindAllDepartment() {
		return findAllDepartment;
	}

	public void setFindAllDepartment(List<DepartmentDTO> findAllDepartment) {
		this.findAllDepartment = findAllDepartment;
	}

	@Override
	public String toString() {
		return "DepartmentSummary [findAllDepartment=" + findAllDepartment + "]";
	}
}
