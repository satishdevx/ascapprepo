//package com.emirates.asc.parent.config.security;
//
//import java.io.IOException;
//import java.io.PrintWriter;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.security.core.AuthenticationException;
//import org.springframework.security.web.authentication.www.BasicAuthenticationEntryPoint;
//import org.springframework.stereotype.Component;
//
//@Component
//public class AuthenticationEntryPoint extends BasicAuthenticationEntryPoint {
//	private static final Logger LOG = LoggerFactory.getLogger(AuthenticationEntryPoint.class);
//
//    @Override
//    public void commence(
//      HttpServletRequest request, HttpServletResponse response, AuthenticationException authEx) 
//      throws IOException {
//		LOG.info(":::: AuthenticationEntryPoint ::: commence ::::");
//        response.addHeader("WWW-Authenticate", "Basic realm=" + getRealmName());
//        response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
//        PrintWriter writer = response.getWriter();
//        writer.println("HTTP Status 401 - " + authEx.getMessage());
//    }
//
//    @Override
//    public void afterPropertiesSet() {
//    	LOG.info(":::: AuthenticationEntryPoint ::: afterPropertiesSet ::::");
//        setRealmName("ascappjava");
//        super.afterPropertiesSet();
//    }
//}