//package com.emirates.asc.parent.config.security2;
//
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.beans.factory.annotation.Value;
//import org.springframework.context.annotation.Bean;
//import org.springframework.http.HttpMethod;
//import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
//import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
//import org.springframework.security.config.http.SessionCreationPolicy;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
//import org.springframework.security.crypto.password.PasswordEncoder;
//
//@EnableWebSecurity(debug = true)
//public class BasicAuthSecurityConfig extends WebSecurityConfigurerAdapter {
//	private static final Logger LOG = LoggerFactory.getLogger(BasicAuthSecurityConfig.class);
//
//    @Autowired
//    private UserDetailsService userDetailsService;
//    
//    @Value("${server.servlet.context-path}")
//    private String appName;
// 
//    @Autowired
//    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
//    	LOG.info(":::: BasicAuthSecurityConfig ::: configureGlobal ::::");
//        auth.userDetailsService(userDetailsService).passwordEncoder(passwordEncoder());
//    }
// 
//    @Override
//    protected void configure(HttpSecurity http) throws Exception {
//    	LOG.info(":::: BasicAuthSecurityConfig ::: configure ::::");
////		http.authorizeRequests().anyRequest().authenticated().and().httpBasic();//.authenticationEntryPoint(entryPoint);
//        // Disable CSRF
//        http.csrf().disable()
//                // Only admin can perform HTTP delete operation
//                .authorizeRequests().antMatchers(HttpMethod.DELETE).hasRole("ADMIN")
//                // any authenticated user can perform all other operations
//                .antMatchers("/appName/api/**").hasAnyRole("ADMIN", "USER").and().httpBasic()
//                // Permit all other request without authentication
//                .and().authorizeRequests().anyRequest().permitAll()
//                // We don't need sessions to be created.
//                .and().sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);
//    }
// 
//    @Override
//    public UserDetailsService userDetailsService() {
//    	LOG.info(":::: BasicAuthSecurityConfig ::: userDetailsService ::::");
//        return userDetailsService;
//    }
// 
//    @Bean
//    public PasswordEncoder passwordEncoder() {
//    	LOG.info(":::: BasicAuthSecurityConfig ::: passwordEncoder ::::");
//        return new BCryptPasswordEncoder(4);
//    }
//}