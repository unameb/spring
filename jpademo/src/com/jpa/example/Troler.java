package com.jpa.example;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

@Entity
public class Troler {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private int rid;
	@Column
	private String rname;
	@ManyToMany
	@JoinTable(joinColumns =@JoinColumn(name="rid"),
			inverseJoinColumns = @JoinColumn(name="cid"))
	private List<Tcode> tcodelist;
	public int getRid() {
		return rid;
	}
	public void setRid(int rid) {
		this.rid = rid;
	}
	public List<Tcode> getTcodelist() {
		return tcodelist;
	}
	public void setTcodelist(List<Tcode> tcodelist) {
		this.tcodelist = tcodelist;
	}
	public String getRname() {
		return rname;
	}
	public void setRname(String rname) {
		this.rname = rname;
	}
	public Troler() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "Troler [rid=" + rid + ", rname=" + rname + ", tcodelist=" + tcodelist + "]";
	}
	
}
