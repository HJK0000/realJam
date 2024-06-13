package com.green.restServer.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.green.restServer.entity.User;

public interface UserRepository extends JpaRepository<User, String>{


	
	public User findByUsername(String username);

	Boolean existsByUsername(String username);

}
