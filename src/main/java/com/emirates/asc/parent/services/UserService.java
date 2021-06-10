package com.emirates.asc.parent.services;

import java.util.List;
import java.util.Optional;
import org.springframework.http.ResponseEntity;
import com.emirates.asc.parent.entities.Role;
import com.emirates.asc.parent.entities.UserEntity;

public interface UserService {

	public static final Integer count = 10;

	public abstract ResponseEntity<Object> addRole(Role role);

	public abstract ResponseEntity<Object> deleteRole(Long id);

	public abstract UserEntity getUser(Long id);

	public abstract List<UserEntity> getUsers();

	public abstract Role getRole(Long id);

	public abstract List<Role> getRoles();
	
	Optional<UserEntity> findByEmail(String email);

	Optional<UserEntity> findByEmailAndPassword(String email, String password);

//	public abstract Object userAuth(UserDetails user) throws UserNotFoundException;
}
