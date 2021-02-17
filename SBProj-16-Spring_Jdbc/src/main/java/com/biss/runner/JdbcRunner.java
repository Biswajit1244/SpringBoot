package com.biss.runner;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.biss.model.Employee;
import com.biss.service.IEmployeeService;
@Component
public class JdbcRunner implements CommandLineRunner {
	@Autowired
	private IEmployeeService service;
	@Override
	public void run(String... args) throws Exception {
		Employee e=new Employee();
		e.setEid(101);
		e.setEname("Nalu");
		e.setSal(63.55);
	
		/*Insert Data
	
		  int count=service.saveEmployee(e);
		if(count>0)
			System.out.println("Inserted");
		else
			System.out.println("Insertion failed");
	*/
		
		/*Update data
		 * 
		 * int count=service.updateEmployee(e); if(count>0)
		 * System.out.println("Updated "); else System.out.println("Update failed");
		 */
		
//		  //Delete Data 
//		int count=service.deleteEmployee(102); 
//		if(count>0)
//			System.out.println("Deleted");
//		else
//			System.out.println("not Delete");
		
//		//Get one Employee Details
//		Employee e1=service.getOneEmployee(101);
//		System.out.println(e1);
		
		//Get All Employee Details
		List<Employee> list=service.getAllEmployee();
		list.forEach(System.out::println);
		
		 
		 
	}
}
