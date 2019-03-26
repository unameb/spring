package com.example.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.bean.ConfigBean;

@RestController
@EnableConfigurationProperties({ConfigBean.class})
public class ConfigControlller {
 @Autowired
 ConfigBean cbean;
 @RequestMapping(value="config")
 public String config() {
	 return cbean.toString();
 }
}
