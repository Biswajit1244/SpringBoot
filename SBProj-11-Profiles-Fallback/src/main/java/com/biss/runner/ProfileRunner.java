package com.biss.runner;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
@Component
public class ProfileRunner implements CommandLineRunner {
	@Value("${sid}")
	private int sid;
	@Value("${sname}")
	private String sname;
	@Value("${sfee}")
	private double sfee;
	@Value("${addrs}")
	private String addrs;
	@Override
	public void run(String... args) throws Exception {
		System.out.println(this);
	}
	@Override
	public String toString() {
		return "ProfileRunner [sid=" + sid + ", sname=" + sname + ", sfee=" + sfee + ", addrs=" + addrs + "]";
	}
	
}
