package com.example.bean;

import org.springframework.stereotype.Component;

@Component
public class Bean01 {
    private int age;
     private String name;
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Bean01(int age, String name) {
		super();
		this.age = age;
		this.name = name;
	}
	public Bean01() {
		super();
		// TODO Auto-generated constructor stub
	}
	public void hello() {
		System.out.println("hellllllll");
	}
}
