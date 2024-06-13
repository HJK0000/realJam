package com.green.viewServer.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.green.viewServer.entity.User;

public interface UserRepository extends JpaRepository<User, String>{
	

	public User findByUsernameAndPassword(String username, String password);

}
