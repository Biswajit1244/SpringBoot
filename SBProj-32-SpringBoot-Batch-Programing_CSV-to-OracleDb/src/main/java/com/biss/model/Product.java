package com.biss.model;

import lombok.Data;

@Data
public class Product {
	private String prodId;
	private String prodCode;
	private Double prodCost;
	private Double gst;
	private Double discount;
}
