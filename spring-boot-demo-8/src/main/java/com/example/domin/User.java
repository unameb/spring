package com.example.domin;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
@Table(name="user")
//@NamedQuery(name="us",query="select u from User u")
@Entity
public class User {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
  public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
@Column(name="name")
  private String name;
  @Column(name="password")
private String password;
  @Column
  private int sex;
public int getSex() {
	return sex;
}
public void setSex(int sex) {
	this.sex = sex;
}
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public String getPassword() {
	return password;
}
public void setPassword(String password) {
	this.password = password;
}
public User() {
	super();
	// TODO Auto-generated constructor stub
}
@Override
public String toString() {
	return "User [id=" + id + ", name=" + name + ", password=" + password + "]";
}
  
}
