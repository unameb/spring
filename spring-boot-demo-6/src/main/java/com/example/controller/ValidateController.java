package com.example.controller;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.example.beans.User;

@Controller
@SessionAttributes({"user","users"})
public class ValidateController {
	ArrayList<User> list=new ArrayList<User>();
	@Autowired
	JdbcTemplate jdbcTemplate;
	@Autowired
	MessageSource message;
	
     @RequestMapping("/index")
     public String index( User user){
	  return "test01";
   }
     @RequestMapping("/join")
     public String join( @Validated User user,BindingResult result,Model model,HttpServletRequest request) {
    	 Locale locale=LocaleContextHolder.getLocale();
    	 if(!user.getEmail().contains(user.getName())) {
    		 FieldError error01=new FieldError("user", "eemail", message.getMessage("eemail", null, locale));
    		 result.addError(error01);
    	 }
    	 System.out.println(model);
    	 System.out.println(request.getLocale());
    	 System.out.println(locale);
    	 if(result.hasErrors()) {
    		 return "test01";
    	 }
    	 this.jdbcTemplate.update("insert into user(age,name,password,sex,email) values("+user.getAge()+",'"+user.getName()+"','"+user.getPassword()+"','"+user.getSex()+"','"+user.getEmail()+"')");
    	 return "login";
     }
     @RequestMapping("/login")
     public String login(User user,Model model) {
    	 String name=user.getName();
    	 String password=user.getPassword();
    	 System.out.println(name+"......"+password);
    	 //判断
    	 model.addAttribute("user",user);
    	 List<User> users = this.jdbcTemplate.query(
    			 "select * from user",
    			 new RowMapper<User>(){
    			 public User mapRow(ResultSet rs, int rowNum) throws SQLException {
    				 User user = new User();
    				 user.setName(rs.getString("name"));
    				 user.setEmail(rs.getString("email"));
    				 user.setAge(rs.getInt("age"));
    				 user.setPassword(rs.getString("password"));
    				 user.setSex(rs.getString("sex"));
    			 return user;
    			 }
    			 });
    	 model.addAttribute("users", users);
    	 return "sub";
     }
}
