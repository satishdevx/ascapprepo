//package com.emirates.asc.parent.config.security2;
//
//import java.util.ArrayList;
//import java.util.List;
//import java.util.Optional;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.core.authority.SimpleGrantedAuthority;
//import org.springframework.security.core.userdetails.User;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.core.userdetails.UsernameNotFoundException;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
//import org.springframework.stereotype.Service;
//import org.springframework.transaction.annotation.Transactional;
//import com.emirates.asc.parent.entities.Role;
//import com.emirates.asc.parent.repositories.UserRepository;
//
//@Service
//public class UserDetailsServiceImpl implements UserDetailsService {
//	private static final org.slf4j.Logger LOG = org.slf4j.LoggerFactory.getLogger(UserDetailsServiceImpl.class);
//
//    @Autowired
//    private UserRepository userRepository;
// 
//    @Override
//    @Transactional
//    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
//    	LOG.info(":::: UserDetailsServiceImpl ::: loadUserByUsername ::::");
//    	BCryptPasswordEncoder encode = new BCryptPasswordEncoder(4);
//        Optional<com.emirates.asc.parent.entities.User> user = userRepository.findByEmail(username);
//        if (user != null) {
//            return new User(user.get().getEmail(), encode.encode(user.get().getPassword()), buildSimpleGrantedAuthorities(user.get().getRole()));
//        } else {
//            throw new UsernameNotFoundException("User not found with username: " + username);
//        }
//    }
// 
//    private static List<SimpleGrantedAuthority> buildSimpleGrantedAuthorities(final Role role) {
//    	LOG.info(":::: UserDetailsServiceImpl ::: buildSimpleGrantedAuthorities ::::");
//        List<SimpleGrantedAuthority> authorities = new ArrayList<>();
//            authorities.add(new SimpleGrantedAuthority(role.getName()));
//        return authorities;
//    }
//}