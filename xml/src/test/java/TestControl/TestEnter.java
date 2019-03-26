package TestControl;

import org.junit.Test;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

import springDemoBean.Bean01;
import springDemoBean.ExampleBean;

public class TestEnter {

	
	  private AbstractApplicationContext context;
	   public TestEnter() {
	      context=new FileSystemXmlApplicationContext("classpath:/MATE-INF/spring-context.xml");
		   context.registerShutdownHook();
	   }
	   @Test
	   public void beanTest() {
		   //获取实例
		   Bean01 bean=context.getBean("bean01",Bean01.class);
		   //使用实例
		   bean.say();
	   }
	   @Test
	   public void beanTest02() {
		   ExampleBean bean02=context.getBean("exampleBean",ExampleBean.class);
		  bean02.say();
	   }
}
