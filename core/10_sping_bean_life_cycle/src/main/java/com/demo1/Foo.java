package com.demo1;

import org.springframework.beans.factory.BeanNameAware;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

public class Foo implements BeanNameAware {

	private String message;

	public Foo() {
		System.out.println("ctr of foo");
	}

	@PostConstruct
	public void myInitMethodUsingAnnotation(){
		System.out.println("myInitMethod using annotation @PostConstuct..");
	}

	@PreDestroy
	public void myDestroyMethodUsingAnnotation(){
		System.out.println("myDestoryMethod using annotation @PreDestroy..");
		//return  "hello to all champs";
	}

	public void setMessage(String message) {
		System.out.println("setMessage is called");
		this.message = message;
	}

	public  void print(){
		System.out.println("value of message is :"+ message);
	}

	@Override
	public void setBeanName(String name) {
		//log4j2
		System.out.println("setBeanName(String name) is called :"+ name);
	}
}















