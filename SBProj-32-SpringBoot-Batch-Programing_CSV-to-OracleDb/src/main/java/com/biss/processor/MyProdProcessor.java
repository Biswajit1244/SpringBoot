package com.biss.processor;

import org.springframework.batch.item.ItemProcessor;

import com.biss.model.Product;

public class MyProdProcessor implements ItemProcessor<Product,Product> {
	@Override
	public Product process(Product item) throws Exception {
		var cost=item.getProdCost();
		item.setGst(cost*0.08);
		item.setDiscount(cost*0.04);
		return item;
	}
}
