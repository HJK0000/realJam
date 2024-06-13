package com.green.restServer.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.green.restServer.entity.User;



public interface UserRepository extends JpaRepository<User, String>{

	@Query(value="select * from user where username= :username", nativeQuery=true)
	public User findByUserName(@Param("username") String username);
}
