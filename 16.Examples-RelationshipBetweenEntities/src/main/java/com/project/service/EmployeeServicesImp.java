package com.project.service;

import java.util.ArrayList;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.dto.EmployeeDTO;
import com.project.dto.EmployeeSummary;
import com.project.entity.Department;
import com.project.entity.Employee;
import com.project.repository.DepartmentRepository;
import com.project.repository.EmployeeRepository;

@Service
public class EmployeeServicesImp implements EmployeeServices {

	@Autowired
	EmployeeRepository employeeRepository;
	@Autowired
	DepartmentRepository departmentRepository;

	public Employee dtoToEntity(EmployeeDTO employeeDTO) {
		Employee employee = new Employee();
		employee.setEmployeeId(employeeDTO.getEmployeeId());
		employee.setEmployeeName(employeeDTO.getEmployeeName());
		employee.setMonthlySalary(employeeDTO.getMonthlySalary());
		Optional<Department> department = departmentRepository.findById(employeeDTO.getDepartmentId());
		employee.setDepartment(department.get());
		return employee;
	}

	public EmployeeDTO entityToDto(Employee employee) {
		EmployeeDTO employeeDTO = new EmployeeDTO();
		employeeDTO.setEmployeeId(employee.getEmployeeId());
		employeeDTO.setEmployeeName(employee.getEmployeeName());
		employeeDTO.setMonthlySalary(employee.getMonthlySalary());
		employeeDTO.setDepartmentName(employee.getDepartment().getDepartmentName());
		employeeDTO.setDepartmentId(employee.getDepartment().getDepartmentId());
		return employeeDTO;

	}

	@Override
	public void createEmployee(EmployeeDTO employeeDto) {
		employeeRepository.save(dtoToEntity(employeeDto));
	}

	@Override
	public void updateEmployee(EmployeeDTO employeeDto) {
		employeeRepository.save(dtoToEntity(employeeDto));
	}

	@Override
	public void deleteEmployee(Long employeeId) {
		employeeRepository.deleteById(employeeId);

	}

	@Override
	public EmployeeDTO findEmployeeById(Long employeeId) {
		Optional<Employee> employee = employeeRepository.findById(employeeId);
		Employee employee2 = employee.get();
		EmployeeDTO employeeDTO = entityToDto(employee2);
		return employeeDTO;
	}

	@Override
	public EmployeeSummary employeeSummaryList() {
		EmployeeSummary employeeSummary = new EmployeeSummary();
		employeeSummary.setFindEmployeeDTOList(new ArrayList<>());
		for (Employee employee : employeeRepository.findAll()) {
			EmployeeDTO employeeDTO = entityToDto(employee);
			employeeSummary.getFindEmployeeDTOList().add(employeeDTO);
		}
		return employeeSummary;
	}
/*
	@Override
	public EmployeeSummary listByDepartment(long departmentId) {
		EmployeeSummary employeeSummary = new EmployeeSummary();
		employeeSummary.setFindEmployeeDTOList(new ArrayList<>());
		for (Employee employee : employeeRepository.findEmployeeByDepartmentID(departmentId)) {
			EmployeeDTO employeeDTO = entityToDto(employee);
			employeeSummary.getFindEmployeeDTOList().add(employeeDTO);
		}
		return employeeSummary;
	}
*/
	@Override
	public Integer countByDepartment(long deparmentId) {
		return employeeRepository.getCountEmployeeByDepartment(deparmentId);
	}

}
