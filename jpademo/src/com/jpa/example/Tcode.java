package com.jpa.example;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

@Entity
public class Tcode {
@Id
//@GeneratedValue
private int cid;
@Column
private String cname;
 @ManyToMany(mappedBy = "tcodelist")
private List<Troler> rolerList;

public List<Troler> getRolerList() {
	return rolerList;
}
public void setRolerList(List<Troler> rolerList) {
	this.rolerList = rolerList;
}
public int getCid() {
	return cid;
}
public void setCid(int cid) {
	this.cid = cid;
}
public String getCname() {
	return cname;
}
public void setCname(String cname) {
	this.cname = cname;
}
public Tcode() {
	super();
	// TODO Auto-generated constructor stub
}

}
