package com.demo3;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;

public class RealLifeUseOfBFPP {
	public static void main(String[] args) {


		AbstractApplicationContext ctx=new ClassPathXmlApplicationContext("demo3.xml");

		Account account=ctx.getBean("acc", Account.class);
		System.out.println(account);

		//What i want to do i want to read the prop file and populate the value before i get bean
		//from the container
		//PropertySourcesPlaceholderConfigurer <--BFPP
	}
}
