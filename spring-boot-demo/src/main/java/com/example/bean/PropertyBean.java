package com.example.bean;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

import groovy.transform.ToString;

@Configuration
@PropertySource("classpath:/application.properties")
@ConfigurationProperties("person")
@ToString
public class PropertyBean {
    private String name;
    private int age;
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
	public PropertyBean() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "PropertyBean [name=" + name + ", age=" + age + "]";
	}
    
}
