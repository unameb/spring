package com.example.demo;


import javax.sql.DataSource;

import org.apache.commons.dbcp2.BasicDataSource;
import org.springframework.context.annotation.Bean;

import com.example.bean.AnotherBean;
import com.example.bean.Bean01;
import com.example.bean.ExampleBean;
import com.example.bean.YetAnorherBean;

public class config {
       @Bean
       public Bean01 getBean01() {
    	   Bean01 bean01=new Bean01();
    	   return bean01;
       }
       @Bean
       public AnotherBean getAnotherBean() {
    	   AnotherBean another=new AnotherBean();
    	   another.setAnotherName("another");
    	   return another;
       }
       @Bean
       public YetAnorherBean getYetAnorherBean() {
    	   YetAnorherBean yet=new YetAnorherBean();
    	   yet.setYetName("yet");
    	   return yet;
       }
       @Bean("eb")
       public ExampleBean getExampleBean() {
    	   ExampleBean example=new ExampleBean();
    	   example.setAnotherbean(getAnotherBean());
    	   example.setYetbean(getYetAnorherBean());
    	   example.setI(12);
    	   return example;
       }
       @Bean(destroyMethod = "close")
       DataSource dataSource() {
   		BasicDataSource ds = new BasicDataSource();
   		ds.setDriverClassName("com.mysql.jdbc.Driver");
   		ds.setUsername("app");
   		ds.setPassword("app");
   		ds.setUrl("jdbc:mysql://localhost:3306/app?useUnicode=true&characterEncoding=utf-8");
   		return  ds;
   	}
}
