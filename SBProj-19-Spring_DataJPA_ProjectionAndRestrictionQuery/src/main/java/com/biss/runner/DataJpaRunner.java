package com.biss.runner;

import java.util.Arrays;

import org.hibernate.criterion.Example;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.biss.model.Employee;
import com.biss.repo.EmployeeRepository;
@Component
public class DataJpaRunner implements CommandLineRunner {
	@Autowired
	private EmployeeRepository repo;
	@Override
	public void run(String... args) throws Exception {
		/*RESTRICTION TEST*/
		
//		repo.save(new Employee("hiki", 20366.0,"Dj"));
//		repo.findByEmpSalGreaterThanEqual(30000.00)
//		.forEach(System.out::println);
	
//		repo.findByJobAndEmpSal("cleark", 60000.0)
//		.forEach(System.out::println);
		
//		repo.findByEmpIdIn(Arrays.asList(102,103,3,122,108))
//		.forEach(System.out::println);
		
//		repo.findByEmpNameLike("S%")
//		.forEach(System.out::println);
		
		/*PROJECTION TEST*/
		repo.findByEmpSalGreaterThan(50000.0)
		.stream().map(m->m.getEmpId()+"  "+m.getEmpName())
		.forEach(System.out::println);
		
	}

}
