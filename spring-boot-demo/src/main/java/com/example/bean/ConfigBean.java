package com.example.bean;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

import groovy.transform.ToString;

@Configuration
@ConfigurationProperties(prefix="my")
@ToString
public class ConfigBean {
     private String name;
     private int age;
     private int number;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public int getNumber() {
		return number;
	}
	public void setNumber(int number) {
		this.number = number;
	}
	public ConfigBean() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "ConfigBean [name=" + name + ", age=" + age + ", number=" + number + "]";
	}
	
}
