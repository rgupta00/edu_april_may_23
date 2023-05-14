package com.demo;

import com.demo.entities.UserEntity;
import com.demo.service.UserService;
import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.List;

@SpringBootApplication
public class DemosecurityApplication implements CommandLineRunner {

	@Autowired
	private UserService userService;

	@Autowired
	private PasswordEncoder passwordEncoder;

	public static void main(String[] args) {
		SpringApplication.run(DemosecurityApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		//String username, String password, List<String> roles
//		userService
//				.addUserEntity(new UserEntity("raj",passwordEncoder.encode("raj123"), List.of("ROLE_ADMIN","ROLE_MGR","ROLE_EMP")));
//		userService
//				.addUserEntity(new UserEntity("ekta",passwordEncoder.encode("ekta123"), List.of("ROLE_MGR","ROLE_EMP")));
//		userService
//				.addUserEntity(new UserEntity("gunika",passwordEncoder.encode("gun123"), List.of("ROLE_EMP")));

		System.out.printf("-------------------");

	}
}
