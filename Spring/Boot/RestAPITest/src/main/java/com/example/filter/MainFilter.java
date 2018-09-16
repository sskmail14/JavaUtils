package com.example.filter;

import java.io.IOException;
import java.security.cert.X509Certificate;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
@Component
@Order(1)
public class MainFilter implements Filter {

	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain)
			throws IOException, ServletException {
			HttpServletRequest req = (HttpServletRequest) request;
			printX509Certificate(req);
            // Goes to default servlet
			chain.doFilter(request, response); 

	}
	
	private void printX509Certificate(HttpServletRequest req) {
		// TODO Auto-generated method stub
		X509Certificate[] certs = (X509Certificate[]) req.getAttribute("javax.servlet.request.X509Certificate");
	    if (null != certs && certs.length > 0) {
	    	System.out.println("***********************Cert Start***********************");
	    	System.out.println(certs[0].toString());
	    	System.out.println("***********************Cert End***********************");
	    }else{
	    	System.out.println("!!!!!!!!!!!!!!!!No Certs!!!!!!!!!!!!!!!!!!!!!!!!!");
	    }
	    
	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {
		// TODO Auto-generated method stub
		
	}


}
