//package com.emirates.asc.parent.config.security;
//
//import java.util.ArrayList;
//import java.util.List;
//import java.util.Optional;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.authentication.AuthenticationProvider;
//import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
//import org.springframework.security.core.Authentication;
//import org.springframework.security.core.AuthenticationException;
//import org.springframework.security.core.GrantedAuthority;
//import org.springframework.security.core.authority.SimpleGrantedAuthority;
//import org.springframework.stereotype.Component;
//import com.emirates.asc.parent.entities.User;
//import com.emirates.asc.parent.services.UserService;
//
//@Component
//public class AscAuthenticationProvider implements AuthenticationProvider {
//	private static final Logger LOG = LoggerFactory.getLogger(AscAuthenticationProvider.class);
//
//	@Autowired
//	private UserService userService;
//
//	@Override
//	public Authentication authenticate(Authentication authentication) throws AuthenticationException {
//		LOG.info(":::: AscAuthenticationProvider ::: authenticate ::::");
//		String email = authentication.getName();
//		String password = authentication.getCredentials().toString();
//
//		Optional<User> user = userService.findByEmailAndPassword(email, password);
//
//		List<GrantedAuthority> authorities = new ArrayList<>();
//		authorities.add(new SimpleGrantedAuthority(user.get().getRole().getDescription())); // description is a string
//
//		return new UsernamePasswordAuthenticationToken(email, password, authorities);
//	}
//
//	@Override
//	public boolean supports(Class<?> authentication) {
//		LOG.info(":::: AscAuthenticationProvider ::: supports ::::");
//		return authentication.equals(UsernamePasswordAuthenticationToken.class);
//	}
//}