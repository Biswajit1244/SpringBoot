package com.biss.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.biss.model.Product;

@Controller
public class RegisterController {
	/**
	* This method is used to show
	* ProductRegister.jsp at browser
	* when they enter URL /reg
	*/
	@RequestMapping("/reg")
	public String regProd() {
		return "RegFrom";
	}
	/**
	* On click Form Submit, container
	* creates object, same object
	* reading in Controller using
	* @ModelAttribute, this data
	* sending to UI using Model
	* so that form data is displayed
	* at ProductData.jsp page
	*/
	@RequestMapping(value = "/save",method=RequestMethod.POST)
	public String showData(@ModelAttribute Product product,
								Model model) {
		model.addAttribute("ob",product);
		
		return "ShowData";
	}
}
