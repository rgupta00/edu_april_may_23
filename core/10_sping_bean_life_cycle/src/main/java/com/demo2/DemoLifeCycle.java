package com.demo2;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class DemoLifeCycle {
	public static void main(String[] args) {

		AbstractApplicationContext ctx=new ClassPathXmlApplicationContext("demo2.xml");
		Foo foo=ctx.getBean("foo", Foo.class);
		foo.print();
		ctx.registerShutdownHook();

		//ApplicationContext dont have shutdown hook, can not apply close method it it
		
	}
}
