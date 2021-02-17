package com.biss.controller.rest;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EmployeeRestController {
	
	@GetMapping("/show")
	public String getMsg() {
		return "FROM PRODUCER";
	}
}
