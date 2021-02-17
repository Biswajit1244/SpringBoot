package com.biss.service.impl;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

import com.biss.service.AlertService;

@Component
@Profile("default")
public class EmailAlert implements AlertService {

	@Override
	public void execute() {
		System.out.println("Email::Service");

	}

}
