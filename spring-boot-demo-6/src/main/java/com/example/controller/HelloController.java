package com.example.controller;

import java.io.File;
import java.io.IOException;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.multipart.MultipartFile;

import com.example.beans.User;

@Controller
public class HelloController {
	@Autowired
	private User user;
	
   @RequestMapping("/hello")
   @ResponseBody
   public User Hello(@RequestParam("age") int age) {
	   user.setAge(age);
	   System.out.println(age);
	   return user;
   }
   
   @RequestMapping("/thymeleaf")
   public String thymeleaf(User user) {
	   return "sub";
   }
   
   //1.@RequestParam
  /* @GetMapping("/param")
   @ResponseBody
   public String demo01(@RequestParam("name")String name) {
	   System.out.println("name=:"+name);
          return "name=:"+name;  
   }*/
   @GetMapping("/param")
   public String demo01(@RequestParam("name")String name,Model model) {
	   return "test01";
	   //test02报错
   }
   //2.@RequestBody
   //用postmapping在浏览器上报错
   @PostMapping("/body")
   @ResponseBody
   public void demo02(/*@RequestBody*/ User user) {
	   System.out.println(user.toString());
	   //return user;
   }
 /*  @GetMapping("/cookie")
   @ResponseBody
   public void demo03(@RequestHeader(name="header") String header,@CookieValue(name="cookie") String cookie) {
	   System.out.println("header=:"+header);
	   System.out.println("cookis=:"+cookie);
   }
   @GetMapping("/request")
   @ResponseBody
   public void demo04(HttpServletRequest request) {
	   System.out.println(request.getHeader("header"));
   }
   @RequestMapping("/demo05")
   public String demo05(String name,String age) {
	   System.out.println("name"+name);
	   System.out.println("age"+age);
	   return "test01";
   }
   @RequestMapping("/demo06")
   public String demo06(HttpServletRequest request) {
	   System.out.println(request.getParameter("name"));
	   System.out.println(request.getParameter("age"));
	   return "test01";
	   }
   @RequestMapping("/demo07/{name}/{age}")
   public String demo07(@PathVariable String name,@PathVariable int age) {
	   System.out.println("name"+name);
	   System.out.println("age"+age);
	   return "test01";
   }*/
  /* @RequestMapping("/sub")
   public String demo08(Model model, User user) {
	   model.addAttribute("age",user.getAge());
	   System.out.println(user.toString());
	   return "sub";
   }*/
   @RequestMapping("/file")
   @ResponseBody
   public String fileupload(MultipartFile file) throws IllegalStateException, IOException {
	   File dfile=new File("D://app/"+file.getOriginalFilename());
	   file.transferTo(dfile);
	   return "success!";
   }
}
