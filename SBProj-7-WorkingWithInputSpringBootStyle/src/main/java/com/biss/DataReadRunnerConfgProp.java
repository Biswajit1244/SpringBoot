package com.biss;

import java.util.List;
import java.util.Map;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import com.biss.bean.Address;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
@Component
@ConfigurationProperties("my.emp")
@Getter
@Setter
@ToString
public class DataReadRunnerConfgProp implements CommandLineRunner {
	private int empId;
	private String empName;
	private double empSal;
	private List<String> proj;
//	private Set<String> proj;
//	private String[] proj;
	private Map<String,Double> detls;
	private Address addrs;
	@Override
	public void run(String... args) throws Exception {
		System.out.println("Welcome To Boot");
		System.out.println(this);

	}

}
