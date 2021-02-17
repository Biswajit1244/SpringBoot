package com.biss.service.impl;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

import com.biss.service.AlertService;
@Component
@Profile("social")
public class SocialAlert implements AlertService {

	@Override
	public void execute() {
		System.out.println("SocialAlert::Service");

	}

}
