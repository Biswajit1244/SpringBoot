package com.biss.config;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ConfigUsingLambdaExpCLRunner {
	@Bean
	public CommandLineRunner clr() {
		return s->System.out.println("Lambda Expression Config");
	}
}
