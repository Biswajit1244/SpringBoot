package com.biss.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.biss.model.Employee;
@Repository
public class EmployeeDaoImpl implements IEmployeeDao {
	@Autowired
	private JdbcTemplate jt;
	
	@Override
	public int saveEmployee(Employee e) {
		String sql="INSERT INTO EMPLYE VALUES(?,?,?)";
		int count =jt.update(sql,e.getEid(),e.getEname(),e.getSal());
		return count;
	}

	@Override
	public int updateEmployee(Employee e) {
		String sql="UPDATE EMPLYE SET ENAME=?,SAL=? WHERE EID=?";
		int count =jt.update(sql,e.getEname(),e.getSal(),e.getEid());
		return count;
	}

	@Override
	public int deleteEmployee(Integer id) {
		String sql="DELETE FROM EMPLYE WHERE EID=?";
		int count=jt.update(sql, id);
		return count;
	}

	@Override
	public Employee getOneEmployee(Integer id) {
		String sql="SELECT EID,ENAME,SAL FROM EMPLYE WHERE EID=?";
		Employee e=jt.queryForObject(sql,(rs,count)->
			 new Employee(rs.getInt(1),rs.getString(2),rs.getDouble(3))
			,id );
		return e;
	}

	@Override
	public List<Employee> getAllEmployee() {
		String sql="SELECT * FROM EMPLYE";
		List<Employee> list=jt.query(sql, (rs,count)->
			 new Employee(rs.getInt(1),rs.getString(2),rs.getDouble(3)));
		return list;
	}

}
