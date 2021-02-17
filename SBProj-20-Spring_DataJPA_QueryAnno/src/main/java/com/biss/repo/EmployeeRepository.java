package com.biss.repo;

import java.util.Collection;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.biss.model.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {
	@Query("select e from Employee e where e.job=:job and e.empSal>=:sal")
	public List<Employee> getDataByJobAndSal(String job,Double sal);
	
	
}
