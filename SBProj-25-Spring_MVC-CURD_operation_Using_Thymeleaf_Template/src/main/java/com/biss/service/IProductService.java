package com.biss.service;

import java.util.List;
import java.util.Optional;

import com.biss.model.Product;

public interface IProductService {
	List<Product> getAllProducts();
	void deleteProduct(Integer id);
	Optional<Product> getOneproduct(Integer id);
	Integer saveProduct(Product p);
}
