package com.biss.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
@Controller
@RequestMapping("/sal")
public class EmployeeSalController{
	@RequestMapping("/cal")
	public String calcSal(@RequestParam(value ="eid",required = false)Integer id,
			  			  @RequestParam(value="ename",defaultValue ="NONE")String name,
			  			   @RequestParam("esal")Double sal,
						  Model m){
		double hra=sal*0.08;
		double ta=sal*0.03;
		double da=sal*0.02;
		double profTax=400;
		
		double netSal=sal+hra+ta+da-profTax;
		
		m.addAttribute("id", id);
		m.addAttribute("name", name);
		m.addAttribute("sal", sal);
		m.addAttribute("hra",hra);
		m.addAttribute("ta", ta);
		m.addAttribute("da", da);
		m.addAttribute("ptax",profTax);
		m.addAttribute("net",netSal);
		
		
		return "SalPage";
	}
}
