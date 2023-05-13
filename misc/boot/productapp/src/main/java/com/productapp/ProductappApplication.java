package com.productapp;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ProductappApplication implements CommandLineRunner {

	private Logger logger= LoggerFactory.getLogger(ProductappApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(ProductappApplication.class, args);
		System.out.println("hello...");
		System.out.println("hello...$$$$.");

	}

	@Override
	public void run(String... args) throws Exception {
		logger.info("hello to spring boot");
		logger.error("something is not working");
	}
}
