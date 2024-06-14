package com.green.restServer.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.green.restServer.dto.UserDto;
import com.green.restServer.repository.UserRepository;
import com.green.restServer.service.JoinService;

@RestController
@CrossOrigin("*")
public class LoginController {

	@Autowired
	JoinService joinservice;
	
	@PostMapping("/user")
	public String joinUser(UserDto userDto) {
		
		joinservice.joinProcess(userDto);
		
		return "ok";
	}
}
