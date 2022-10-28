package com.training.pms.galaxe.aop;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Before;

public class SecurityAspect {

	public SecurityAspect() {
		// TODO Auto-generated constructor stub
	}

	@Before(value =  "execution(* com.training.pms.galaxe.service.ProductServiceImpl.*(..))")
	public void doLogging() {
		//	code for logging goes here
		System.out.println("####Logging done before!!! called "+ new java.util.Date());
	}
	
	@After(value =  "execution(* com.training.pms.galaxe.service.ProductServiceImpl.*(..))")
	public void doLogging2() {
		//	code for logging goes here
		System.out.println("####Logging done after !!! called "+ new java.util.Date());
	}
}
