package com.biss;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class SbProj33bMicroServiceSpringEurekaProducerApplication {

	public static void main(String[] args) {
		SpringApplication.run(SbProj33bMicroServiceSpringEurekaProducerApplication.class, args);
	}
	
}
