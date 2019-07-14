package com.check24.user.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.check24.user.model.User;

public interface UserRepository extends JpaRepository<User, String> {
	
	Optional<User> findByUsername(String username);
	
	Boolean existsByUsername(String username);
}