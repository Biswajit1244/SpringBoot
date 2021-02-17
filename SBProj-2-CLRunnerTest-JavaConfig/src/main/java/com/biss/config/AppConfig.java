package com.biss.config;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.biss.runner.RunnerClass;

@Configuration
public class AppConfig {
	@Bean
	public CommandLineRunner clr() {
		return new RunnerClass();
	}
}
