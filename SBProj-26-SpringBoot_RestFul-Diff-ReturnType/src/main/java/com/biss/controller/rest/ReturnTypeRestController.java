package com.biss.controller.rest;

import java.util.List;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.biss.mode.Student;

@RestController
public class ReturnTypeRestController {
	@GetMapping("/showA")
	public String ShowA() {
		return "Hello Kn Karucha";
	}
	
	@GetMapping("/showB")
	public ResponseEntity<Student> showStd(){
		Student s=new Student(45,"Siju",6.32,
									List.of("Math","SCI","ENG"),
								    Map.of("Math",46,"SCI",69,"ENG",98));
		return new ResponseEntity<Student>(s,HttpStatus.OK);
	}
	@GetMapping("/showC")
	public ResponseEntity<Map<String,String>> showMap(){
		return new ResponseEntity<Map<String,String>>(Map.of("Miki","Tiki","Biki","Liki"),HttpStatus.OK);
	}
	@GetMapping("/showD")
	public ResponseEntity<List<Integer>> showList(){
		return new ResponseEntity<List<Integer>>(List.of(65,698,654,64,6,64),HttpStatus.OK);
	}
}
