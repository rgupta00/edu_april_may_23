package com.productapp;

import com.productapp.entities.Product;
import com.productapp.repo.ProductRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.ApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.persistence.EntityManager;
import java.math.BigDecimal;
import java.util.Arrays;

@SpringBootApplication
public class Productapp01Application implements CommandLineRunner {

	@Autowired
	private ProductRepo productRepo;

	public static void main(String[] args) {
		ApplicationContext ctx= SpringApplication.run(Productapp01Application.class, args);
	}
	@Override
	public void run(String... args) throws Exception {

		Product product=Product.builder().name("dell laptop").price(new BigDecimal(100000)).build();
		Product product2=Product.builder().name("laptop coolpad").price(new BigDecimal(1800)).build();

//		productRepo.save(product);
//		productRepo.save(product2);

		System.out.println("--------------------------");

	}
}
