package com.biss.model;

import java.util.List;
import java.util.Map;

import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@NoArgsConstructor
@AllArgsConstructor
@Document
public class Student {
	private Integer id;
	private String sname;
	private Double sfee;
	@Transient
	private String classType;
	private List<String> subs;
	private Map<String,Integer> marks;
	private Address addrs;
}
