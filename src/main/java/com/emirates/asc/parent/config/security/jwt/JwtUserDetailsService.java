package com.emirates.asc.parent.config.security.jwt;

import java.util.ArrayList;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.emirates.asc.parent.entities.Role;
import com.emirates.asc.parent.entities.UserEntity;
import com.emirates.asc.parent.repositories.UserRepository;

@Service
public class JwtUserDetailsService implements UserDetailsService {
	private static final org.slf4j.Logger LOG = org.slf4j.LoggerFactory.getLogger(JwtUserDetailsService.class);

//	@Autowired
//	private UserDao userDao;
	
	@Autowired
	private UserRepository userRepository;

	@Autowired
	private PasswordEncoder bcryptEncoder;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		LOG.info(":::: JwtUserDetailsService ::: configureGlobal ::::");
		Optional<UserEntity> user = userRepository.findByUsername(username);//email
		if (!user.isPresent()) {
			throw new UsernameNotFoundException("User not found with username: " + username);
		}
		return new org.springframework.security.core.userdetails.User(user.get().getUsername(), 
				bcryptEncoder.encode(user.get().getPassword()),	new ArrayList<>());
	}

	public UserEntity save(UserDTO user) {
		LOG.info(":::: JwtUserDetailsService ::: save ::::");
		UserEntity newUser = new UserEntity();
		newUser.setFirstName(user.getUsername());
//		newUser.setPassword(bcryptEncoder.encode(user.getPassword()));
		newUser.setPassword(user.getPassword());
		return userRepository.save(newUser);
	}
}