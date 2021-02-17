package com.runner;

import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
@Component
@Order(12)
public class BatchRunner implements CommandLineRunner {

	@Override
	public void run(String... args) throws Exception {
		System.out.println("Batch Runner");
	}

}
