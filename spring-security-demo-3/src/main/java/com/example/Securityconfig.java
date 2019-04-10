package com.example;

import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.security.web.authentication.logout.LogoutSuccessHandler;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
@EnableWebSecurity(debug=true)
public class Securityconfig extends WebSecurityConfigurerAdapter{
	@Autowired
	private DataSource dataSource;

	@Autowired
	public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
		auth
			.jdbcAuthentication()
				.dataSource(dataSource)
				.withDefaultSchema()
				.withUser("1").password("1").roles("USER").and()
				.withUser("2").password("2").roles("USER", "ADMIN");
	}
	
	
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		// TODO Auto-generated method stub
		super.configure(auth);
		/*auth.inMemoryAuthentication().withUser("1").password("1").roles("USER")
		     .and().withUser("2").password("2").roles("ADMIN");*/
	}

	@Override
	public void configure(WebSecurity web) throws Exception {
		// TODO Auto-generated method stub
		super.configure(web);
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		// TODO Auto-generated method stub
		http
		.authorizeRequests()
		    .antMatchers("/h2-console/**","/resources/**", "/signup", "/about").permitAll()              
		    .antMatchers("/admin/**").hasRole("ADMIN")   
		    .antMatchers("/db/**").access("hasRole('ADMIN') and hasRole('DBA')") 
			.anyRequest().authenticated()
			.and()
		.csrf().ignoringAntMatchers("/h2-console/**")
		.and()
		.headers().frameOptions().sameOrigin()
		.and()
		.logout()
			.logoutUrl("/my/logout")
			.logoutSuccessHandler(new LogoutSuccessHandler() {
				@Override
				public void onLogoutSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication)
						throws IOException, ServletException {
					// TODO Auto-generated method stub
					response.sendRedirect("/about");
				}
			} )
			//在Properties文件里给cookie重命名
			.deleteCookies("JSCOOKIE")
			.and()
		.formLogin()
		   .loginPage("/lg") 
		  /* .loginProcessingUrl("/login")
		    .successHandler(new AuthenticationSuccessHandler() {
				@Override
				public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response,
						Authentication authentication) throws IOException, ServletException {
					// TODO Auto-generated method stub
					response.sendRedirect("/success");
				}
			})*/
		   .usernameParameter("name")
		   .passwordParameter("pwd")
		      .permitAll() 
		      .and()
		.httpBasic();
	}
	/*@Bean
	public logoutSuccessHandler logoutsuccess {
		return new LogoutSuccessHandler() {
			@Override
			public void onLogoutSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication)
					throws IOException, ServletException {
				// TODO Auto-generated method stub
				response.sendRedirect("/about");
			}
		}
	}*/
	
	/*@Bean
	public UserDetailsService userDetailsService() {
		InMemoryUserDetailsManager manager = new InMemoryUserDetailsManager();
		manager.createUser(User.withUsername("11").password("11").roles("USER").build());
		manager.createUser(User.withUsername("22").password("22").roles("ADMIN").build());
		manager.createUser(User.withUsername("33").password("33").roles("DBA").build());
		manager.createUser(User.withUsername("44").password("44").roles("DBA","ADMIN").build());
		
		return manager;
	}*/

}
