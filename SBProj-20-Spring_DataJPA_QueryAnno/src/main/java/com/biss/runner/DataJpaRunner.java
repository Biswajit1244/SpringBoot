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
		
		repo.getDataByJobAndSal("engineer",50000.0)
		.forEach(System.out::println);
	}

}
