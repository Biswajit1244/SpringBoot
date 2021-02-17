package com.biss.runner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Component;

import com.biss.model.Ticket;
//@Component
public class FindRunner implements CommandLineRunner {
	@Autowired
	MongoTemplate mt;
	@Override
	public void run(String... args) throws Exception {
		mt.findAll(Ticket.class).forEach(System.out::println);
		System.out.println("*******************");
		Query q1=new Query();
	//	q1.addCriteria(Criteria.where("code").is("TICA"));
	//	q1.addCriteria(Criteria.where("cost").gte(650.0));
	//	q1.addCriteria(Criteria.where("info.toLoc").in("BHC","HYD"));
	//	q1.addCriteria(Criteria.where("cost").exists(true)
	//			.andOperator
			//  .orOperator
	//				(Criteria.where("cost").gte(700.0),
	//				Criteria.where("info.fromLoc").is("HYD"))		
	//			);
		q1.addCriteria(Criteria.where("formats").is("TRAIN"));
		mt.find(q1,Ticket.class).forEach(System.out::println);
	}

}
