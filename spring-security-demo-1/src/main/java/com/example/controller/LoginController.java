package com.example.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.example.bean.User;

@Controller
@SessionAttributes("user")
public class LoginController {
	 private static Logger log=LoggerFactory.getLogger(LoginInterceport.class);
	
    @RequestMapping("/login")
    @ResponseBody
    public String login(User user,Model model) {
    	model.addAttribute("user",user);
    	log.info(user.toString());
    	return "login success";
    }
    @RequestMapping("/join")
    @ResponseBody
    public String join(Model model) {
    	return "join success";
    }
    @RequestMapping("/admin")
    @ResponseBody
    public String admin() {
    	return "admin success";
    }
    @ResponseBody
    @GetMapping("/loginout")
    public String loginOut() {
    	return "loginout";
    }
}
