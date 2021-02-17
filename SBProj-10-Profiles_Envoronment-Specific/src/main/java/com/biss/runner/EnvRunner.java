package com.biss.runner;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
@Component
public class EnvRunner implements CommandLineRunner {
	@Value("${msg}")
	private String Message;
	@Override
	public void run(String... args) throws Exception {
		System.out.println("From Runner");
		System.out.println(Message);
	}

}
