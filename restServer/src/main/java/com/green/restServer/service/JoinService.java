package com.green.restServer.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.green.restServer.dto.UserDto;
import com.green.restServer.repository.UserRepository;

@Service
public class JoinService {

	@Autowired
	UserRepository userRepository;
	
	public void joinProcess(UserDto userDto) {
		
		String username = userDto.getUsername();
		String password = userDto.getPassword();
	
		//Boolean isExist = userRepository.existsByUsername(username);
	}
	
}
