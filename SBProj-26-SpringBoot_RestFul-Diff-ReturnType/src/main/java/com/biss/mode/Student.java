package com.biss.mode;

import java.util.List;
import java.util.Map;

import javax.xml.bind.annotation.XmlRootElement;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@NoArgsConstructor
@AllArgsConstructor
@XmlRootElement
public class Student {
	private int sid;
	private String sname;
	private Double sfee;
	private List<String> subj;
	private Map<String,Integer> mark;
	
}
