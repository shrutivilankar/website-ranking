package com.assignment.report.websites.config;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.MDC;
import org.springframework.boot.autoconfigure.AutoConfigureBefore;
import org.springframework.boot.web.servlet.support.ErrorPageFilter;
import org.springframework.stereotype.Component;

@Component
@AutoConfigureBefore(value=ErrorPageFilter.class)
public class ErrorFilter implements Filter{


	@Override
	public void init(FilterConfig filterConfig) throws ServletException {	
		
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		try {
		chain.doFilter(request, response);
		
		}catch(Throwable ex) {
			HttpServletResponse resp = (HttpServletResponse)response;
			resp.addHeader("traceId", MDC.get("X-B3-TraceId"));
			throw ex;	
		}
		
	}

	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		
	}
	

}
