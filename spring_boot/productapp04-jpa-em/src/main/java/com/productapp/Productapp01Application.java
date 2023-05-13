package com.productapp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.ApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.persistence.EntityManager;
import java.util.Arrays;

@SpringBootApplication//	(exclude = {DataSourceAutoConfiguration.class})
public class Productapp01Application implements CommandLineRunner {
	@Autowired
	private EntityManager em;

	public static void main(String[] args) {
		ApplicationContext ctx= SpringApplication.run(Productapp01Application.class, args);
//		Arrays.stream(ctx.getBeanDefinitionNames()).forEach(name-> System.out.println(name));
	}
	@Override
	public void run(String... args) throws Exception {

		if(em!=null){
			System.out.println("em is configured..");
		}else{
			System.out.println("not em");
		}
	}
}
