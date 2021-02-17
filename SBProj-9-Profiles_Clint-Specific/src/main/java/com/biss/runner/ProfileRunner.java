package com.biss.runner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.biss.service.AlertService;
@Component
public class ProfileRunner implements CommandLineRunner {
	@Autowired
	private AlertService as;
	@Override
	public void run(String... args) throws Exception {
		as.execute();

	}

}
