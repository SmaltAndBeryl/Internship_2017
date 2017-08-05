package com.skill.India.common;


import org.springframework.boot.autoconfigure.security.SecurityProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;

import org.springframework.security.config.annotation.web.builders.HttpSecurity;

import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

import org.springframework.security.web.csrf.CookieCsrfTokenRepository;



	@Configuration
	@Order(SecurityProperties.ACCESS_OVERRIDE_ORDER)
	public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
		@Override
		protected void configure(HttpSecurity http) throws Exception {
			// @formatter:off
			http
					.httpBasic().and()
					.authorizeRequests()
					.antMatchers("/index3.html", "/home.html", "/login2.html", "/", "/master.html", "/page1.html","/page2.html","/page3.html", "/page4.html", "/page5.html", "/TrainingPartner.html", "/AssessmentBody.html", "/profileCreationTp.html").permitAll()
					.anyRequest().authenticated()
					.and()
					.csrf()
					.csrfTokenRepository(CookieCsrfTokenRepository.withHttpOnlyFalse());
			// @formatter:on
		}
	}

