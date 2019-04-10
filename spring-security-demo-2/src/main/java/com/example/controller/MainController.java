package com.example.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {
    @GetMapping("/")
    public String main() {
    	return "hello";
    }
    @GetMapping("/a")
    public String a() {
    	return "aaaaaaa";
    }
    @GetMapping("/lg")
    public String login() {
    	return "lg";
    }
    @GetMapping("/success")
    public String success() {
    	return "success";
    }
    @GetMapping("/admin/1")
    public String admin() {
    	return "admin";
    }
    @GetMapping("/db/1")
    public String db() {
    	return "db";
    }
    @GetMapping("/test")
    public String test() {
    	return "db";
    }
    @GetMapping("/about")
    public String about() {
    	return "about";
    }
}
