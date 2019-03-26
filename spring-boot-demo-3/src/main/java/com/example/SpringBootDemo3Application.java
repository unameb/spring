package com.example;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.impl.MessageService;

@SpringBootApplication
public class SpringBootDemo3Application implements CommandLineRunner  {
     @Autowired
     private MessageService ms;
	 
     
	
	public static void main(String[] args) {
		SpringApplication.run(SpringBootDemo3Application.class, args);
	}



	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		System.out.println(ms.getMessage());
		
	}

}
