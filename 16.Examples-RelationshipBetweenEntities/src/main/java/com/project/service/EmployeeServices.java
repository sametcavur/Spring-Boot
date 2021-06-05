package com.project.service;

import com.project.dto.EmployeeDTO;
import com.project.dto.EmployeeSummary;

public interface EmployeeServices {

	public void createEmployee(EmployeeDTO employeeDto);
	public void updateEmployee(EmployeeDTO employeeDto);
	public void deleteEmployee(Long employeeId);
	public EmployeeDTO findEmployeeById(Long employeeId);
	public EmployeeSummary employeeSummaryList();
//	public EmployeeSummary listByDepartment(long departmentId);
	public Integer countByDepartment(long deparmentId);
	
}
