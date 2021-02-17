package com.biss.bean;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
@Getter
@Setter
@ToString
@NoArgsConstructor
public class Address {
	private String area;
	private String landmark;
	private String state;
	private int pincode;
}
