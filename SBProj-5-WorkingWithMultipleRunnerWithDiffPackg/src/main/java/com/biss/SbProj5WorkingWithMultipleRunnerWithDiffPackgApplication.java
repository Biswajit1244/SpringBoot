package com.biss;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan({"com.runner","runner.in","com.biss"})
public class SbProj5WorkingWithMultipleRunnerWithDiffPackgApplication {

	public static void main(String[] args) {
		SpringApplication.run(SbProj5WorkingWithMultipleRunnerWithDiffPackgApplication.class, args);
	}

}
