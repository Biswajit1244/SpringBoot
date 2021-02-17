package com.biss.controller.rest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.biss.model.Employee;

@RestController
public class InputRestController {
	//-----Read QueryParam qry?id=_&ename=_
	@GetMapping("/qry")
	public ResponseEntity<String> showQueryPData(
							@RequestParam Integer id,
							@RequestParam String ename){
		String code="ID="+id+" NAME="+ename;
		return new ResponseEntity<String>(code,HttpStatus.OK);
	}
	//--------Read Header Param user/pwd
	@GetMapping("/header")
	public ResponseEntity<String> showHeader(@RequestHeader String user,
											@RequestHeader String pwd){
		String body="User="+user+" Pwd="+pwd;
		return new ResponseEntity<String>(body,HttpStatus.OK);
	}
	//-----------Read JSON/XML data-------------
	@PostMapping("/emp")
	public ResponseEntity<String> showBody(@RequestBody Employee emp) {
		return new ResponseEntity<String>(emp.toString(),HttpStatus.OK);
	}
}
