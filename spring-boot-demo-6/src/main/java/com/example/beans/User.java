package com.example.beans;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;

import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.stereotype.Component;

@Component
public class User {
	@NotEmpty
   private  String name;
	@Max(100)
	@Min(0)
   private int age;
	@NotEmpty
	private String password;
	
	private String sex;
	private String email;
   private String eemail;
	public String getEemail() {
	return eemail;
}
public void setEemail(String eemail) {
	this.eemail = eemail;
}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
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
public User() {
	super();
	// TODO Auto-generated constructor stub
}
@Override
public String toString() {
	return "User [name=" + name + ", age=" + age + ", password=" + password + ", sex=" + sex + ", email=" + email + "]";
}

   
}
