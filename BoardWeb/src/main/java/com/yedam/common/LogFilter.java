package com.yedam.common;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

public class LogFilter implements Filter {
	List<String> list = new ArrayList<>();
	
	public LogFilter() {
		System.out.println("필터객체 생성");
	    list.add("192.168.0.15");
	    list.add("192.168.0.16");
	    
	}

	@Override
	public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain)
			throws IOException, ServletException {
		System.out.println("서블릿 실행전");
		
		String host = req.getRemoteAddr();
		String port = "" + req.getRemotePort();
		
		HttpServletRequest request = (HttpServletRequest) req;
		String uri = request.getRequestURI();
		String context = request.getContextPath();
		String page = uri.substring(context.length());
		System.out.println("IP:" + host + ", Page" + page);	
//		if (host.equals("192.168.0.26")) {		// 자기자신만 접속가능
//			System.out.println("접속Host:" + host + "Port:" + port);
//			return;
//		}	
		if (host.equals("192.168.0.26")) {		// 자기자신만 접속가능
			System.out.println("접속Host:" + host + "Port:" + port);
			return;
		}
		chain.doFilter(req, resp); //서블릿 실행
		
		System.out.println("서블릿 실행후");
	}

	
	
}
