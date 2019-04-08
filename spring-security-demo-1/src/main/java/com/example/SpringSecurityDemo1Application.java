package com.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;

import com.example.filter.AdminFilter;
import com.example.filter.EncodeFilter;
import com.example.filter.LoginFilter;
import com.example.filter.LoginOutFilter;

@SpringBootApplication
public class SpringSecurityDemo1Application {
      @Bean
      public FilterRegistrationBean setFilter() {
    	  FilterRegistrationBean filterBean=new FilterRegistrationBean();
    	  filterBean.setFilter(new LoginFilter());
    	  filterBean.addUrlPatterns("/*");
    	  filterBean.setOrder(7);
    	  return filterBean;
      }
      @Bean
      public FilterRegistrationBean setFilter2() {
    	  FilterRegistrationBean filterBean=new FilterRegistrationBean();
    	  filterBean.setFilter(new AdminFilter());
    	  filterBean.addUrlPatterns("/admin");
    	  filterBean.setOrder(8);
    	  return filterBean;
      }
      @Bean
      public FilterRegistrationBean setFilter3() {
    	  FilterRegistrationBean filterBean=new FilterRegistrationBean();
    	  filterBean.setFilter(new LoginOutFilter());
    	  filterBean.addUrlPatterns("/loginout");
    	  filterBean.setOrder(6);
    	  return filterBean;
      }
      @Bean
      public FilterRegistrationBean setFilter4() {
    	  FilterRegistrationBean filterBean=new FilterRegistrationBean();
    	  filterBean.setFilter(new EncodeFilter());
    	  filterBean.addUrlPatterns("/*");
    	  filterBean.setOrder(5);
    	  return filterBean;
      }
	public static void main(String[] args) {
		SpringApplication.run(SpringSecurityDemo1Application.class, args);
	}

}
