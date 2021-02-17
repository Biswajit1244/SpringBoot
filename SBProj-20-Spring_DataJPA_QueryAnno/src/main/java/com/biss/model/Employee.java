package com.biss.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@RequiredArgsConstructor
@Entity(name="EMPLYE")
public class Employee {
		@Id
		@GeneratedValue(strategy=GenerationType.SEQUENCE)
		@Column(name="EMP_ID")
		private Integer empId;
		@NonNull
		@Column(name="ENAME")
		private String empName;
		@NonNull
		@Column(name="SAL")
		private Double empSal;
		@NonNull
		private String job;
		
}
