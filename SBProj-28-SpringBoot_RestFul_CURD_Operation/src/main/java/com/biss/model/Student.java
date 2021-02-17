package com.biss.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="stdTab2")
@XmlRootElement
public class Student {
	@Id
	@GeneratedValue
	private Integer stdId;
	private String stdName;
	private Double stdFee;
	private String grade;
}
