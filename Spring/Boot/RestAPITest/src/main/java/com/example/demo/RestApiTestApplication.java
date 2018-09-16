package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.example.filter.CustomWebSecurityConfigurerAdapter;
import com.example.filter.MainFilter;

@SpringBootApplication
@Configuration
public class RestApiTestApplication {

	public static void main(String[] args) {
	SpringApplication.run(RestApiTestApplication.class, args);
	}
	
	@Bean
	public FilterRegistrationBean loggingFilter(){
	    FilterRegistrationBean registrationBean = new FilterRegistrationBean();
	         
	    registrationBean.setFilter(new MainFilter());	         
	    return registrationBean;    
	}
	
	@Bean
	public CustomWebSecurityConfigurerAdapter getCustomWebSecurityConfigurerAdapter(){
		return new CustomWebSecurityConfigurerAdapter();
	}
}
