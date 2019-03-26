package com.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import de.codecentric.boot.admin.config.EnableAdminServer;

@SpringBootApplication
@EnableAdminServer
public class SpringBootDemo4Application {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootDemo4Application.class, args);
	}

}
