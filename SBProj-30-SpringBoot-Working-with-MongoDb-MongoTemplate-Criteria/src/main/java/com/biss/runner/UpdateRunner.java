package com.biss.runner;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Component;

import com.biss.model.Ticket;
import com.biss.model.TicketInfo;
@Component
public class UpdateRunner implements CommandLineRunner {
	@Autowired
	private MongoTemplate mt;
	@Override
	public void run(String... args) throws Exception {
			mt.findAll(Ticket.class).forEach(System.out::println);
			System.out.println("*************************");
			Query q1=new Query();
			Update up=new Update();
			q1.addCriteria(Criteria.where("code").is("TIJK"));
			
			up.set("cost",873.20);
			up.set("info",new TicketInfo("VH","BNG","IOP"));
			up.set("formats",List.of("CYCLE"));
			
			mt.findAndModify(q1, up, Ticket.class);
			
			mt.findAll(Ticket.class).forEach(System.out::println);
	}

}
