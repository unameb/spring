package com.example.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

import com.example.impl.MessageService;
@Component
@Profile({"generic"})
public class GenericService implements MessageService {
      @Value("${name}")
      private String name;
      
      @Value("${hello}")
      private String hello;
	
	@Override
	public String getMessage() {
		// TODO Auto-generated method stub
		return this.hello+"  "+name;
	}

}
