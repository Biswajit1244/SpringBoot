package com.biss.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.biss.model.Employee;

public class EmployeeMapper implements RowMapper<Employee> {

	@Override
	public Employee mapRow(ResultSet rs, int rowNum) throws SQLException {
		Employee e=new Employee();
		e.setEid(rs.getInt(1));
		e.setEname(rs.getString(2));
		e.setSal(rs.getDouble(3));
		
		return e;
	}

}
