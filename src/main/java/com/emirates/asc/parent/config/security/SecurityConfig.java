//package com.emirates.asc.parent.config.security;
//
//import java.util.Arrays;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.beans.factory.annotation.Qualifier;
//import org.springframework.context.annotation.Bean;
//import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
//import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
//import org.springframework.security.core.userdetails.User;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
//import org.springframework.security.provisioning.InMemoryUserDetailsManager;
//import org.springframework.web.cors.CorsConfiguration;
//
//@EnableWebSecurity(debug = true)
//public class SecurityConfig extends WebSecurityConfigurerAdapter {
//	private static final Logger LOG = LoggerFactory.getLogger(SecurityConfig.class);
//
//	@Autowired
//	AuthenticationEntryPoint entryPoint;
//
//	@Autowired
//	AscAuthenticationProvider authenticationProvider;
//
//	@Autowired
//	public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
//		LOG.info(":::: SecurityConfig ::: configureGlobal ::::");
//		auth.authenticationProvider(authenticationProvider);
////		auth.inMemoryAuthentication()
////		.withUser("ascapp").password("{noop}ascpp123").roles("USER").and()
////        .withUser("ascappp").password("{noop}ascpp1234").roles("ADMIN");
//	}
//
//	@Bean
//	public BCryptPasswordEncoder passwordEncoder() {
//		LOG.info(":::: SecurityConfig ::: passwordEncoder ::::");
//	    return new BCryptPasswordEncoder(4);
//	}
//	
//	@Override
//	protected void configure(HttpSecurity http) throws Exception {
//		LOG.info(":::: SecurityConfig ::: configure ::::");
//		http.authorizeRequests().anyRequest().authenticated().and().httpBasic().authenticationEntryPoint(entryPoint);
//	}
//
////    @Override
////    protected void configure(HttpSecurity http) throws Exception {
////		LOG.info(":::: SecurityConfig ::: configure ::::");
////        CorsConfiguration corsConfiguration = new CorsConfiguration();
////        corsConfiguration.setAllowedHeaders(Arrays.asList("Authorization", "Cache-Control", "Content-Type"));
////        corsConfiguration.setAllowedOrigins(Arrays.asList("*"));
////        corsConfiguration.setAllowedMethods(Arrays.asList("GET", "POST", "PUT", "DELETE", "PUT","OPTIONS","PATCH"));
////        corsConfiguration.setAllowCredentials(true);
////        corsConfiguration.setExposedHeaders(Arrays.asList("Authorization"));
////        
//////        http.authorizeRequests().anyRequest().authenticated().and().httpBasic();
////        
////        // You can customize the following part based on your project, it's only a sample
////        http.authorizeRequests().antMatchers("/api/**").permitAll().anyRequest()
////                .authenticated().and().csrf().disable().cors().configurationSource(request -> corsConfiguration);
////    }
//
//}