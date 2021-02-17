package com.biss.runner;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
@Component
public class ChildProfileRunner implements CommandLineRunner{
	@Value("${x}")
	private int x;
	@Value("${y}")
	private int y;
	@Value("${z}")
	private int z;
	@Override
	public void run(String... args) throws Exception {
		System.out.println(this);
	}
	@Override
	public String toString() {
		return "ChildProfileRunner [x=" + x + ", y=" + y + ", z=" + z + "]";
	}

}
