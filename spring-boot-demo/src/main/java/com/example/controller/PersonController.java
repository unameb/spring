package com.example.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PersonController {
	//调用yml中的属性值
    @Value("${my.name}")
    private String name;
    @Value("${my.age}")
    private int age;
    @RequestMapping("/my")
    public String my() {
    	return name+","+age;
    }
}
