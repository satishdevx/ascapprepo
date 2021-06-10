//package com.emirates.asc.parent.config.security.oauth;
//
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
//import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;
//
//@Configuration
//@EnableResourceServer
//public class OAuth2ResourceServer extends ResourceServerConfigurerAdapter {
//	private static final Logger LOG = LoggerFactory.getLogger(OAuth2ResourceServer.class);
//
//	@Override
//	public void configure(HttpSecurity http) throws Exception {
//		LOG.info(":::: OAuth2AuthorizationServer ::: configure ::::");
//		http.authorizeRequests().antMatchers("/api/**").authenticated().antMatchers("/").permitAll();
//	}
//}