//package com.emirates.asc.parent.config.security.oauth;
//
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.core.annotation.Order;
//import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
//import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
//
//@Configuration
//@Order(1)
//@EnableWebSecurity(debug = true)
//public class SecurityConfig extends WebSecurityConfigurerAdapter {
//	private static final Logger LOG = LoggerFactory.getLogger(SecurityConfig.class);
//
//	@Override
//	protected void configure(HttpSecurity http) throws Exception {
//		LOG.info(":::: SecurityConfig ::: configure ::::");
//		http.antMatcher("/**").authorizeRequests().antMatchers("/oauth/authorize**", "/login**", "/error**").permitAll()
//				.and().authorizeRequests().anyRequest().authenticated().and().formLogin().permitAll();
//	}
//
//	@Override
//	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
//		LOG.info(":::: SecurityConfig ::: configure ::::"); 
//		auth.inMemoryAuthentication().withUser("ascapp").password(passwordEncoder().encode("ascapp123")).roles("USER");
//	}
//
//	@Bean
//	public BCryptPasswordEncoder passwordEncoder() {
//		LOG.info(":::: SecurityConfig ::: passwordEncoder ::::");
//		return new BCryptPasswordEncoder();
//	}
//}