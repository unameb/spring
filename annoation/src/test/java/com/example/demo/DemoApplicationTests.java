package com.example.demo;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Component;
import org.springframework.test.context.junit4.SpringRunner;

import com.example.bean.Bean01;
import com.example.bean.ExampleBean;
@RunWith(SpringRunner.class)
@SpringBootTest
public class DemoApplicationTests {
	private AnnotationConfigApplicationContext context;
	@Before
	public void contextLoads() {
		context=new AnnotationConfigApplicationContext();
		context.scan("com.example");
		context.refresh();
		//context=new AnnotationConfigApplicationContext(config.class);
		context.registerShutdownHook();
		
		int count=context.getBeanDefinitionCount();
		System.out.println("bean的个数"+count);
		String[] names = context.getBeanDefinitionNames();
		for (String name : names) {
			System.out.println(name + "--->");
			Object bean = context.getBean(name);
			System.out.println(bean.getClass());
		}

	}
	@Test
	public void test01() {
		Bean01 bean=context.getBean(Bean01.class);
		bean.hello();
		context.getBean(Bean01.class).hello();
		
	}
	@Test
	public void test02() {
		ExampleBean bean=context.getBean(ExampleBean.class);
		System.out.println(bean.toString());
	}
     /*@Autowired
     private ExampleBean examplebean;
     
     @Test
     public void test() {
   	 System.out.println(this.examplebean.toString());
    }*/
     
}
