package com.biss;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class SbProj33aMicroServiceSpringEurekaServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(SbProj33aMicroServiceSpringEurekaServerApplication.class, args);
	}

}
