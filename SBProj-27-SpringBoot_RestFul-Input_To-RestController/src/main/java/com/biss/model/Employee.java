package com.biss.model;

import javax.xml.bind.annotation.XmlRootElement;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@XmlRootElement
public class Employee {
	private int eid;
	private String ename;
	private double esal;
}
