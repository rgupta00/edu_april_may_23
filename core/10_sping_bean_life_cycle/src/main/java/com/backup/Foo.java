package com.backup;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

public class Foo implements InitializingBean, DisposableBean {

	private String message;

	public Foo() {
		System.out.println("ctr of foo");
	}

	@PostConstruct
	public void myInitMethodUsingAnnotation(){
		System.out.println("myInitMethod using annotation @PostConstuct..");
		//return  "hello to all champs";
	}

	@PreDestroy
	public void myDestroyMethodUsingAnnotation(){
		System.out.println("myDestoryMethod using annotation @PreDestroy..");
		//return  "hello to all champs";
	}

	//call back
	public void myInitMethod(){
		System.out.println("myInitMethod using xml..");
		//return  "hello to all champs";
	}

	public void myDestoryMethod(){
		System.out.println("myDestoryMethod using xml");
	}
	public void setMessage(String message) {
		System.out.println("setMessage is called");
		this.message = message;
	}

	public  void print(){
		System.out.println("value of message is :"+ message);
	}

	@Override
	public void destroy() throws Exception {
		System.out.println("destroy using DisposableBean");
	}

	@Override
	public void afterPropertiesSet() throws Exception {
		System.out.println("afterPropertiesSet using InitializingBean");
	}
}















