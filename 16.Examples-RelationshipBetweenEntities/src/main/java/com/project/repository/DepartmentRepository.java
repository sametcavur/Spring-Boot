package com.project.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.project.entity.Department;

@Repository
public interface DepartmentRepository extends CrudRepository<Department,Long> {

}
