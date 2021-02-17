package com.biss.model;

import java.util.List;

import lombok.Data;

@Data
public class Product {
	private Integer prodId;
	private String prodCode;
	private Double prodCost;
	private String prodModel;
	private String prodDesc;
	private String prodFormat;
	//checkbox
	private List<String> prodGrd;
	//multi-select dropdown
	private List<String> prodBrnd;

}
