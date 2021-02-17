package com.biss.runner;

import org.springframework.boot.CommandLineRunner;
import org.springframework.core.Ordered;
import org.springframework.stereotype.Component;
@Component
public class JdbcRunner implements CommandLineRunner,Ordered {

	@Override
	public void run(String... args) throws Exception {
		System.out.println("Jdbc Runner");
	}

	@Override
	public int getOrder() {
		// TODO Auto-generated method stub
		return 66;
	}

}
