package com.project.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import com.project.entity.Employee;


@Repository
public interface EmployeeRepository extends CrudRepository<Employee,Long> {

	//@Query("SELECT d FROM Department d WHERE d.department.departmentId = :departmentId")
	//public List<Employee> findEmployeeByDepartmentID(@Param (value = "departmentId") Long departmentId);
	
	@Query("SELECT COUNT(e.employeeId) FROM Employee e WHERE e.department.departmentId = :departmentId")
	public int getCountEmployeeByDepartment(Long departmentId);
}
