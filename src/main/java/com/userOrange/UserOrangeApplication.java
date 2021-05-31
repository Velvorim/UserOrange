package com.userOrange;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;


@SpringBootApplication
@EnableFeignClients
public class UserOrangeApplication {

	public static void main(String[] args) {
		SpringApplication.run(UserOrangeApplication.class, args);
	}

}
