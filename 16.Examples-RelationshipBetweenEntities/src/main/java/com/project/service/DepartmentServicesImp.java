package com.project.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.dto.DepartmentDTO;
import com.project.dto.DepartmentSummary;
import com.project.entity.Department;
import com.project.repository.DepartmentRepository;
@Service
public class DepartmentServicesImp implements DepartmentServices {

	@Autowired
	DepartmentRepository departmentRepository;
	
	public DepartmentSummary list() { 
		DepartmentSummary departmentSummary = new DepartmentSummary();
		departmentSummary.setFindAllDepartment(new ArrayList<>());
		for (Department department : departmentRepository.findAll()) {
			DepartmentDTO departmentDTO = entityToDto(department);
			departmentSummary.getFindAllDepartment().add(departmentDTO);
		}
		return departmentSummary;
	}

	private DepartmentDTO entityToDto(Department department) {
		DepartmentDTO departmentDTO = new DepartmentDTO();
		departmentDTO.setDepartmentId(department.getDepartmentId());
		departmentDTO.setDepartmentName(department.getDepartmentName());
		return departmentDTO;
	}

}
