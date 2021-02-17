package com.biss.runner;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DataReadRunner implements CommandLineRunner {
	@Value("${std.id}")
	private int sid;
	@Value("${std.name}")
	private String sname;
	@Value("${std.fee}")
	private double sfee;
	@Override
	public void run(String... args) throws Exception {
		System.out.println(sid+"  "+sname+"  "+sfee);

	}

}
