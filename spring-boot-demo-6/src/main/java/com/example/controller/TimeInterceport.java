package com.example.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import com.example.beans.User;

public class TimeInterceport implements HandlerInterceptor {

	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		// TODO Auto-generated method stub
		System.out.println("TimeInterceport preHandle");
		User user=(User)request.getSession().getAttribute("user");
		System.out.println(user);
		System.out.println(request.getRequestURI());
		if(user==null&&request.getRequestURI().contains("login")) {
			response.sendRedirect(request.getContextPath()+"/index");
		    System.out.println("成功拦截并转发");
		    return false;
		}
		return true;
	}

	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		// TODO Auto-generated method stub
		System.out.println("TimeInterceport postHandle");
	}

	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
		// TODO Auto-generated method stub
		System.out.println("TimeInterceport afterCompletion");
	}

}
