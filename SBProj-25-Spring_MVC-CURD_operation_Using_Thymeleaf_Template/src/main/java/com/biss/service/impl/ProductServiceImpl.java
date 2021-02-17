package com.biss.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.biss.model.Product;
import com.biss.repo.ProductRepository;
import com.biss.service.IProductService;

@Service
public class ProductServiceImpl
implements IProductService
{
	@Autowired
	private ProductRepository repo; //HAS-A
	@Override
	public List<Product> getAllProducts() {
		List<Product> list=repo.findAll();
		return list;
	}
			@Override
			public void deleteProduct(Integer id) {
		repo.deleteById(id);
	}
	@Override
	public Optional<Product> getOneproduct(Integer id) {
		Optional<Product> opt=repo.findById(id);
		return opt;
	}
	@Override
	public Integer saveProduct(Product p) {
		double gst=p.getProdCost() * 8/100.0;
		double discount=p.getProdCost() * 12/100.0;
		p.setGst(gst);
		p.setDiscount(discount);
		Integer id=repo.save(p).getProdId();
		return id;
	}
}
