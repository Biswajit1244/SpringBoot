package com.biss.listener;

import org.springframework.batch.core.JobExecution;
import org.springframework.batch.core.JobExecutionListener;

public class MyJobListener implements JobExecutionListener {

	@Override
	public void beforeJob(JobExecution je) {
		System.out.println("Started");
		System.out.println(System.currentTimeMillis());
		System.out.println(je.getStatus());
	}

	@Override
	public void afterJob(JobExecution je) {
		System.out.println("End");
		System.out.println(System.currentTimeMillis());
		System.out.println(je.getStatus());
		
	}

}
