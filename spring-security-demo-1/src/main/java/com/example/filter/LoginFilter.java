package com.example.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.example.bean.User;
import com.example.controller.LoginInterceport;

public class LoginFilter implements Filter {
	private static Logger log=LoggerFactory.getLogger(LoginFilter.class);
	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		// TODO Auto-generated method stub
		log.info("LoginFilter初始化中");
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		HttpServletRequest req=(HttpServletRequest)request;
		HttpServletResponse res=(HttpServletResponse)response;
		// TODO Auto-generated method stub
		log.info("LoginFilter开始进行过滤处理");
		User user=(User)req.getSession().getAttribute("user");
		if(user==null&&req.getRequestURI().contains("join")) {
			log.info("LoginFilter成功拦截并转发");
			res.sendRedirect("/login");
		}else {
			chain.doFilter(request, response);
		}
	}

	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		log.info("LoginFilter销毁中");
	}

}
