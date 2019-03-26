package com.example.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.bean.PropertyBean;

@RestController
//@ComponentScan(basePackages="com.example.bean")
@EnableConfigurationProperties({PropertyBean.class})
public class PropertyController {
     @Autowired
     private PropertyBean properbean;
     
     @RequestMapping("/prop")
     public String property() {
    	 return properbean.toString();
     }
}
