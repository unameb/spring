package com.example;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.example.domin.User;
import com.example.service.UserService;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.core.type.TypeReference;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringBootDemo8ApplicationTests {
   @Autowired
   UserService userservice;
  	@Autowired
  	ObjectMapper objectMapper;
   
   private static final Logger log=LoggerFactory.getLogger(SpringBootDemo8ApplicationTests.class);
	/*@Test
	public void contextLoads() {
		User user=new User();
		user.setName("lkl");
		user.setPassword("33333333");
		userservice.save(user);
	}
   @Test
   public void test() {
	   System.out.println(userservice.findAllUser());
   }
   @Test
   public void test01() {
	   System.out.println(userservice.findUserById(1));
   }*/
 /*  @Test
   public void test02() {
	   User user=new User();
		user.setName("yyyyyuu");
		user.setId(1);
		userservice.upUser(user);
   }*/
   @Ignore
   @Test
   public void test04() {
	   User user=new User();
		user.setName("ww");
		user.setPassword("123");
	  System.out.println(userservice.findByNameAndPassword(user)); 
   }
   
   //@Ignore
   @Test
   public void test03() {
		String map = "{\"page\" : 1,\"pageSize\" : 5, \"filter\":{ \"filters\":[{ \"field\" : \"password\", \"value\":\"123\"},{ \"field\" : \"name\", \"value\":\"long\"}]}}";
		Map searchParameters = new HashMap();
		try {
			searchParameters = objectMapper.readValue(map, new TypeReference<Map>(){} );
		} catch (JsonParseException e) {
			log.error("JsonParseException{}:", e.getMessage());
		} catch (JsonMappingException e) {
			log.error("JsonMappingException{}:", e.getMessage());
		} catch (IOException e) {
			log.error("IOException{}:", e.getMessage());
		}

		Map mapDept = userservice.getPage(searchParameters);

		System.out.println(mapDept.get("total"));

		System.out.println(mapDept.get("depts"));
   }
   
}
