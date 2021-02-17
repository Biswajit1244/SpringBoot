package com.biss.service;

import java.util.List;

import com.biss.model.Employee;

public interface IEmployeeService {
	public int saveEmployee(Employee e);
	public int updateEmployee(Employee e);
	public int deleteEmployee(Integer id);
	public Employee getOneEmployee(Integer id );
	public List<Employee> getAllEmployee();
}
