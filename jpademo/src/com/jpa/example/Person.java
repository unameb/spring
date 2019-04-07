package com.jpa.example;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Person {
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
private int pid;
@Column
private String pname;
@OneToMany(mappedBy="person")
private List<Book> list;
public List<Book> getList() {
	return list;
}
public void setList(List<Book> list) {
	this.list = list;
}
public int getPid() {
	return pid;
}
public void setPid(int pid) {
	this.pid = pid;
}
public String getPname() {
	return pname;
}
public void setPname(String pname) {
	this.pname = pname;
}
public Person() {
	super();
	// TODO Auto-generated constructor stub
}


}
