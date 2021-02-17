package com.biss.runner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Component;

import com.biss.model.Employee;
import com.biss.repo.EmployeeRepository;

@Component
public class DataJpaRunner implements CommandLineRunner {
	@Autowired
	private EmployeeRepository repo;
	@Override
	public void run(String... args) throws Exception {
//		Employee e1=new Employee("Nikiu", 35022.00,"Clerk");
//		e1=repo.save(e1);
//		//with PK
//		Employee e2=new Employee(e1.getEmpId(),"kiloio",36225.2,"HR");
//		repo.save(e2);
		//Delete Row
//		System.out.println("------------DELETE---------------");
//		repo.deleteById(1);
//		repo.deleteById(2);
//		repo.deleteAll();//it delete all record one by one
//		repo.deleteAllInBatch();//It delete all record in at a time in batch
		
//		System.out.println("---------SELECT----------------");
//		repo.findAll().forEach(System.out::println);
//		//get one row based on ID
//		Optional<Employee> p2=repo.findById(103);
//		if(p2.isPresent()) {
//			System.out.println(p2.get());
//		}else {
//			System.out.println("Not Found");
//		}
//		//JDK 9
//		//IFPresentOrElse
//		repo.findById(1253).ifPresentOrElse(System.out::println,()->
//												System.out.println("No Data Found"));
//		System.out.println("---------SORT------------");
//		repo.findAll(Sort.by(Direction.DESC,"empId"))
//			.forEach(System.out::println);
//		repo.findAll(Sort.by("empId"))
//		.forEach(System.out::println);
//		System.out.println("---------PagiNation-----------");
//		Page<Employee> p=repo.findAll(PageRequest.of(1,3)).forEach(System.out::println);
		
		Page<Employee> p=repo.findAll(PageRequest.of(2,4));
		System.out.println(p.getTotalElements());
		System.out.println(p.getTotalPages());
		//To get Current Page Content
		p.getContent().forEach(System.out::println);
		//get Page details
		System.out.println(p.isFirst());
		System.out.println(p.isLast());
		System.out.println(p.hasNext());
		System.out.println(p.hasPrevious());
		//Get current Page details
		System.out.println(p.getNumber());
		System.out.println(p.getSize());
	}
	
}
