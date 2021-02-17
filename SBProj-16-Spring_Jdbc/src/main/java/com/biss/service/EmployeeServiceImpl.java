package com.biss.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.biss.dao.IEmployeeDao;
import com.biss.model.Employee;
@Service
public class EmployeeServiceImpl implements IEmployeeService {
	
	@Autowired
	private IEmployeeDao dao;
	
	@Override
	public int saveEmployee(Employee e) {
		return dao.saveEmployee(e);
	}
	@Override
	public int updateEmployee(Employee e) {
		return dao.updateEmployee(e);
	}
	@Override
	public int deleteEmployee(Integer id) {
		return dao.deleteEmployee(id);
	}
	@Override
	public Employee getOneEmployee(Integer id) {
		return dao.getOneEmployee(id);
	}
	@Override
	public List<Employee> getAllEmployee() {
		return dao.getAllEmployee();
	}

}
