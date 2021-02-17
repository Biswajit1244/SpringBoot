package com.biss.runner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.biss.mail.MailService;
@Component
public class EmailRunner implements CommandLineRunner {
	@Autowired
	MailService service;
	
	@Override
	public void run(String... args) throws Exception {
		 
		boolean sent=service.send("biss9861@gmail.com","From Program","Hello Biswa");
		
		if(sent) {
			System.out.println("Done");
		}else {
			System.out.println("Error");
		}
	}

}
