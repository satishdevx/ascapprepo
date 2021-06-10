package com.emirates.asc.parent.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.emirates.asc.parent.entities.UserEntity;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<UserEntity, Long> {

	Optional<UserEntity> findByEmail(String email);

	Optional<UserEntity> findByEmailAndPassword(String email, String password);

	Optional<UserEntity> findByUsername(String username);
}