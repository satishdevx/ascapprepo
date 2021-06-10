package com.emirates.asc.parent.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import com.emirates.asc.parent.services.UserService;
import java.util.List;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.emirates.asc.parent.entities.Role;
import com.emirates.asc.parent.entities.UserEntity;

@RestController
@RequestMapping(path = "/api/main")
public class UserController {
	private static final org.slf4j.Logger LOG = org.slf4j.LoggerFactory.getLogger(UserController.class);

	@Autowired
	UserService userService;

	@PostMapping("/role/create")
	public ResponseEntity<Object> createRole(@RequestBody Role role) {
		LOG.info(":::: UserController ::: createRole ::::");
		return userService.addRole(role);
	}

	@DeleteMapping("/role/delete/{id}")
	public ResponseEntity<Object> deleteRole(@PathVariable Long id) {
		LOG.info(":::: UserController ::: deleteRole ::::");
		return userService.deleteRole(id);
	}

	@GetMapping(path = "/user/details/{id}")//, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public UserEntity getUser(@PathVariable Long id) {
		LOG.info(":::: UserController ::: getUser ::::");
		return userService.getUser(id);
	}

	@GetMapping("/user/all")
	public List<UserEntity> getUsers() {
		LOG.info(":::: UserController ::: getUsers ::::");
		return userService.getUsers();
	}

	@GetMapping("/role/details/{id}")
	public Role getRole(@PathVariable Long id) {
		LOG.info(":::: UserController ::: getRole ::::");
		return userService.getRole(id);
	}

	@GetMapping("/role/all")
	public List<Role> getRoles() {
		LOG.info(":::: UserController ::: getRoles ::::");
		return userService.getRoles();
	}

}
