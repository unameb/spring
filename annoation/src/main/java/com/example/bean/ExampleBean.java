package com.example.bean;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
@Component
public class ExampleBean {
	@Autowired
       private YetAnorherBean yetbean;
	@Autowired
       private AnotherBean anotherbean;
	
       private int i;
	public int getI() {
		return i;
	}
	public void setI(int i) {
		this.i = i;
	}
	public YetAnorherBean getYetbean() {
		return yetbean;
	}
	public void setYetbean(YetAnorherBean yetbean) {
		this.yetbean = yetbean;
	}
	public AnotherBean getAnotherbean() {
		return anotherbean;
	}
	public void setAnotherbean(AnotherBean anotherbean) {
		this.anotherbean = anotherbean;
	}
	
	public ExampleBean(int i, YetAnorherBean yetbean, AnotherBean anotherbean) {
		super();
		this.i = i;
		this.yetbean = yetbean;
		this.anotherbean = anotherbean;
	}
	public ExampleBean() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "ExampleBean [yetbean=" + yetbean.getYetName() + ", anotherbean=" + anotherbean.getAnotherName()+ ", i=" + i+ "]";
	}
       
}
