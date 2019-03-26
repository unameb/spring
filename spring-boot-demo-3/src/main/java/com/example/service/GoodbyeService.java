package com.example.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

import com.example.impl.MessageService;
@Component
@Profile("goodbye")
public class GoodbyeService implements MessageService {
     @Value("${name}")
     private String name;
	@Override
	public String getMessage() {
		// TODO Auto-generated method stub
		return name;
	}

}
