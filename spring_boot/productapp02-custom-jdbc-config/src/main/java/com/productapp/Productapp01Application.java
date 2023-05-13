package com.productapp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.autoconfigure.jdbc.DataSourceTransactionManagerAutoConfiguration;
import org.springframework.context.ApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.Arrays;

//hey spring boot dont give ur own infra bean (For whatever purpose i want to define my own)
@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class,
		DataSourceTransactionManagerAutoConfiguration.class})
public class Productapp01Application implements CommandLineRunner {

	//SB =Spring - infra bean + cloud ready

	@Autowired
	private JdbcTemplate jdbcTemplate;

	public static void main(String[] args) {
		ApplicationContext ctx= SpringApplication.run(Productapp01Application.class, args);
//		Arrays.stream(ctx.getBeanDefinitionNames()).forEach(name-> System.out.println(name));
	}
	@Override
	public void run(String... args) throws Exception {

		if(jdbcTemplate!=null){
			System.out.println("jdbcTemplate is configured..");
		}else{
			System.out.println("not jdbcTemplate");
		}
	}
}
