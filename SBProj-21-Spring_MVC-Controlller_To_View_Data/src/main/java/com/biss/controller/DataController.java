package com.biss.controller;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import in.biss.model.Employee;

@Controller
public class DataController {
	@RequestMapping("/data")
	public String showData(Model model) {
		//primitive data 
		model.addAttribute("sid",120);
		model.addAttribute("sname" ,"BISWAJIT");
		model.addAttribute("sfee",3.65);
		//Object Data
		Employee e1=new Employee(1555,"DjBravo",36.21);
		Employee e2=new Employee(8556,"Miju",545);
		model.addAttribute("Emp1",e1);
		model.addAttribute("Emp2",e2);
		//list Collection
		List<Integer> list=List.of(545,545,54,5,87,8,8,8);
		model.addAttribute("list",list);
		//Map Collection
		Map<String,Integer> map=Map.of("Biss",63,"Dj",87,"Sam",83);
		model.addAttribute("map",map);
		return "Data";
	}
}
