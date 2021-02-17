package com.biss.runner;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.biss.model.Address;
import com.biss.model.Student;
import com.biss.repo.StudentRepo;
@Component
public class Studentrunner implements CommandLineRunner {
	@Autowired
	private StudentRepo repo;
	@Override
	public void run(String... args) throws Exception {
		repo.save(new Student(
				898,"Kalia",698.0,"",
				List.of("Math","Eng","TLS"),
				Map.of("Math",45,"Eng",98,"TLS",69),
				new Address("6DP/09", "JAJ",755621)
				));
		System.out.println("Done Dana Done");
	}

}
