package com.biss.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.biss.model.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

}
