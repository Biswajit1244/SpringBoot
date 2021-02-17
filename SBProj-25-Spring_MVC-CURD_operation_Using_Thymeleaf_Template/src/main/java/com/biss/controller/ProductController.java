package com.biss.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.biss.model.Product;
import com.biss.service.IProductService;

@Controller
@RequestMapping("/product")
public class ProductController {
	@Autowired
	private IProductService service;
	/**
	 * URL : /all , GET
	 * showProducts() send data to UI
	 * Page : ProductsData
	 */
	@RequestMapping("/all")
	public String showProducts(Model model) {
		List<Product> list=service.getAllProducts();
		model.addAttribute("list", list);
		return "ProductsData";
	}
	/**
	 * on click DELETE hyperLink this
	 * method is called.
	 * as: /delete/{id} , GET
	 * deleteProduct
	 */
	@RequestMapping("/delete/{id}")
	public String deleteProduct(
			@PathVariable("id")Integer id,
			Model model
			)
	{
		//deleting row
		service.deleteProduct(id);
		//fetching new data
		List<Product> list=service.getAllProducts();
		//send to ui
		model.addAttribute("list", list);
		model.addAttribute("message", id+" deleted");
		return "ProductsData";
		//return "redirect:../all";
	}
	/**
	 * On click View HyperLink display
	 * one row data at ProductOne HTML
	 * Page, URL : /view/{id}
	 * method: getOneProduct
	 */
			@RequestMapping("/view/{id}")
	public String getOneProduct(
			@PathVariable("id")Integer id,
			Model model
			)
	{
		Optional<Product> opt=service.getOneproduct(id);
		if(opt.isPresent()) {
			model.addAttribute("ob", opt.get());
		}else {
			model.addAttribute("message", "NO DATA FOUND");
		}
		return "ProductOne";
	}
	/**
	 * This method is used to display
	 * Form with empty inputs
	 * Page: ProductReg.html
	 * URL : /reg, Type:GET
	 * method: showRegPage()
	 * Form Backing Obj: product
	 */
	@RequestMapping("/reg")
	public String showRegPage(Model model) {
		model.addAttribute("product", new Product());
		return "ProductReg";
	}
	/**
	 * On click Form submit
	 * read ModelAttribute
	 * call service layer save method
	 * return ProduReg with success
	 * message.
	 * URL : /save, type:POST
	 * method: saveProduct()
	 */
	@RequestMapping(value = "/save"
			,method = RequestMethod.POST)
	public String saveProduct(
			@ModelAttribute Product product,
			Model model)
	{
		Integer id=service.saveProduct(product);
		String message="Product saved with :"+id;
		model.addAttribute("message", message);
		//clear Form
		model.addAttribute("product", new Product());
		return "ProductReg";
	}
	/***
	 * On click Edit HyperLink
	 * load object data from DB
	 * and display at UI using Model
	 * URL : /edit/{id} , Type:GET
	 * showEditPage() : ProductEdit.html
	 */
	@RequestMapping("/edit/{id}")
	public String showEditPage(
			@PathVariable("id")Integer pid,
			Model model)
	{
		Optional<Product> ob=service.getOneproduct(pid);
		if(ob.isPresent()) {
			model.addAttribute("product", ob.get());
		}else {
			model.addAttribute("product", new Product());
		}
		return "ProductEdit";
	}
	/**
	 * On click Update button,
	 * Read Form Data using @ModelAttribute
	 * call service layer save()
	 * Return to UI : ProductData.html
	 * updateProduct() , URL /update, POST
	 * Also fetch new data
	 */
	@RequestMapping(value = "/update",
			method = RequestMethod.POST)
	public String updateProduct(
			@ModelAttribute Product product,
			Model model )
	{
		Integer id=service.saveProduct(product);
		model.addAttribute("message", "Product updated:"+id);
		//fetch new data from DB
		List<Product> list=service.getAllProducts();
		model.addAttribute("list", list);
		return "ProductsData";
	}
}