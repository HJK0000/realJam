package com.green.restServer.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.green.restServer.entity.User;
import com.green.restServer.repository.UserRepository;

@RestController
@CrossOrigin("*")
public class LoginController {

	@Autowired
	UserRepository userRepository;
	
	@PostMapping("/user")
	public String joinUser(User user) {
		
		userRepository.save(user);
		
		return "ok";
	}
}
