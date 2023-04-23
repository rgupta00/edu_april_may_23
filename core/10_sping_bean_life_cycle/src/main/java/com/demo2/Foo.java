package com.demo2;

import org.springframework.beans.factory.BeanNameAware;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

public class Foo {

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


}















