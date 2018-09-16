package com.example.filter;

import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

public class CustomWebSecurityConfigurerAdapter extends WebSecurityConfigurerAdapter {
	@Override
    protected void configure(HttpSecurity http) throws Exception {
		System.out.println("Initialized CustomWebSecurityConfigurerAdapter...");
		
        http.csrf().disable();
    }
}
