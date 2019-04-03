package com.example;

import javax.el.ResourceBundleELResolver;

import org.apache.tomcat.util.descriptor.LocalResolver;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.format.FormatterRegistry;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewResolverRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.i18n.CookieLocaleResolver;
import org.springframework.web.servlet.i18n.LocaleChangeInterceptor;

import com.example.controller.TimeInterceport;


@Configuration
//@EnableWebMvc  //����webmvc
//@ComponentScan(basePackages="com.example.controller")
public class MvcConfig extends WebMvcConfigurerAdapter {
   @Bean
 public   ResourceBundleMessageSource messageSource() {
	   ResourceBundleMessageSource message=new ResourceBundleMessageSource();
	   message.setBasename("message");
	   return message;
   }
   
   @Bean("localeResolver")
	public LocaleResolver cookieLocaleResolver(){
		CookieLocaleResolver localeResolver = new CookieLocaleResolver();
		localeResolver.setCookieName("cookieLocale");
		return localeResolver;
	}
   
	/*@Override
		public void addCorsMappings(CorsRegistry registry) {
			// TODO Auto-generated method stub
		registry.addMapping("/**");
		}*/
	
	public void addInterceptors(InterceptorRegistry registry) {
		registry.addInterceptor(new TimeInterceport());
		LocaleChangeInterceptor lr = new LocaleChangeInterceptor();
		lr.setParamName("lang");
		registry.addInterceptor(lr);
	}
	//转换
	@Override
	public void addFormatters(FormatterRegistry registry) {
		// TODO Auto-generated method stub
		super.addFormatters(registry);
	}
	//静态资源不拦截
	/*@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		// TODO Auto-generated method stub
		super.addResourceHandlers(registry);
	}*/
	
	
}
