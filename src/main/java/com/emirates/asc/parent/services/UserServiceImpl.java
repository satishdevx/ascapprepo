package com.emirates.asc.parent.services;

import java.util.List;
import java.util.Optional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.emirates.asc.parent.entities.Role;
import com.emirates.asc.parent.entities.UserEntity;
import com.emirates.asc.parent.repositories.RoleRepository;
import com.emirates.asc.parent.repositories.UserRepository;

@Service
@Transactional
public class UserServiceImpl implements UserService {
	private static final Logger LOG = LoggerFactory.getLogger(UserServiceImpl.class);

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private RoleRepository roleRepository;
	
	@Override
	public Optional<UserEntity> findByEmail(String email) {
		LOG.info(":::: UserServiceImpl ::: findByEmail ::::");
		return userRepository.findByEmail(email);
	}
	@Override
	public Optional<UserEntity> findByEmailAndPassword(String email, String password){
		LOG.info(":::: UserServiceImpl ::: findByEmail ::::");
		return userRepository.findByEmailAndPassword(email, password);
	}

	@Override
	public ResponseEntity<Object> addRole(Role role) {
		LOG.info(":::: UserServiceImpl ::: createRole ::::");
		Role newRole = new Role();
		newRole.setName(role.getName());
		newRole.setDescription(role.getDescription());
		newRole.setUsers(role.getUsers());
		Role savedRole = roleRepository.save(newRole);
		if (roleRepository.findById(savedRole.getId()).isPresent()) {
			return ResponseEntity.accepted().body("Successfully Created Role and Users");
		} else
			return ResponseEntity.unprocessableEntity().body("Failed to Create specified Role");
	}

	@Override
	public ResponseEntity<Object> deleteRole(Long id) {
		LOG.info(":::: UserServiceImpl ::: deleteRole ::::");
		if (roleRepository.findById(id).isPresent()) {
			roleRepository.deleteById(id);
			if (roleRepository.findById(id).isPresent()) {
				return ResponseEntity.unprocessableEntity().body("Failed to delete the specified record");
			} else
				return ResponseEntity.ok().body("Successfully deleted specified record");
		} else
			return ResponseEntity.unprocessableEntity().body("No Records Found");
	}

	public UserEntity getUser(Long id) {
		LOG.info(":::: UserServiceImpl ::: getUser ::::");
		if (userRepository.findById(id).isPresent())
			return userRepository.findById(id).get();
		else
			return null;
	}

	public List<UserEntity> getUsers() {
		LOG.info(":::: UserServiceImpl ::: getUsers ::::");
		return userRepository.findAll();
	}

	public Role getRole(Long id) {
		LOG.info(":::: UserServiceImpl ::: getRole ::::");
		if (roleRepository.findById(id).isPresent())
			return roleRepository.findById(id).get();
		else
			return null;
	}

	public List<Role> getRoles() {
		LOG.info(":::: UserServiceImpl ::: getRoles ::::");
		return roleRepository.findAll();

	}

}