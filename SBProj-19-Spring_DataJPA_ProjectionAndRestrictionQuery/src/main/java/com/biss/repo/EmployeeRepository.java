package com.biss.repo;

import java.util.Collection;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.biss.model.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {
	////////RESTRICTION////////
	//select *from employee where Sal>=?
	List<Employee> findByEmpSalGreaterThanEqual(Double sal);
	//select * from employee where job=? and sal=?
	List<Employee> findByJobAndEmpSal(String job,Double sal);
	//select *from employee where emp_id in(?,?,?,?,?..)
	List<Employee> findByEmpIdIn(Collection<Integer> ids);
	//select *from employee where Ename like '?'
	List<Employee> findByEmpNameLike(String ename);
	
	//////PROJECTION////////
	//Select emp_id,ename from employee where sal>?
	interface NameAndId{
		Integer getEmpId();
		String getEmpName();
	}
	List<NameAndId> findByEmpSalGreaterThan(Double sal);
}
