package com.example.demo;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.context.support.ServletRequestHandledEvent;

@SpringBootApplication
@ComponentScan(basePackages="com.example.controller")
public class SpringBootDemo2Application {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootDemo2Application.class, args);
	}
   @Bean
   public static CommandLineRunner testA() {
	   CommandLineRunner runner=new CommandLineRunner() {
		@Override
		public void run(String... arg0) throws Exception {
			// TODO Auto-generated method stub
			System.out.println("testA runner start");
		}
		};
		return runner;
   }
   @Bean
   public ApplicationListener<ApplicationEvent> listen(){
	   final String hurl="/hello";
	   return (ApplicationEvent event) ->{
		   if(event instanceof ServletRequestHandledEvent) {
			   ServletRequestHandledEvent se=(ServletRequestHandledEvent)event;
			   if(se.getRequestUrl().equals(hurl)) {
				   System.out.println("visit hello");
			   }
		   }
	   };
   }
}
