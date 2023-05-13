package com.demo;

import com.demo.entities.UserEntity;
import com.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;

@SpringBootApplication
public class DemosecurityApplication implements CommandLineRunner {

	@Autowired
	private UserService userService;

	public static void main(String[] args) {
		SpringApplication.run(DemosecurityApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
/*
username;
    private String password;
    private String email;
 */
//		userService
//				.addUserEntity(new UserEntity("raj","raj123",
//						"raj@gmail.com",
//						List.of("ROLE_ADMIN","ROLE_MGR","ROLE_EMP") ));
//
//		userService
//				.addUserEntity(new UserEntity("ekta","ekta123",
//						"ekta@gmail.com",
//						List.of("ROLE_MGR","ROLE_EMP") ));
//
//		userService
//				.addUserEntity(new UserEntity("gunika","gun123",
//						"gun@gmail.com",
//						List.of("ROLE_EMP") ));
		System.out.printf("--------------------------------------------------");
	}
}
