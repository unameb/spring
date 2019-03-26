package com.example.controller;


import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SrpingController {
	//调用properties的属性值
	@Value("${name}")
	private String name;
  @RequestMapping(value="/hello")
  public String hello() {
	  return "hello"+name;
  }
}
