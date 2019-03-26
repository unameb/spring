package com.example.bean;

import org.springframework.stereotype.Component;

@Component
public class AnotherBean {
      private String anotherName;

	public AnotherBean() {
		super();
		// TODO Auto-generated constructor stub
	}

	public AnotherBean(String anotherName) {
		super();
		this.anotherName = anotherName;
	}

	public String getAnotherName() {
		return anotherName;
	}

	public void setAnotherName(String anotherName) {
		this.anotherName = anotherName;
	}
   
      
}
