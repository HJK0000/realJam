package com.green.restServer.service;

import org.springframework.stereotype.Service;

import com.green.restServer.dto.UserDto;

@Service
public class JoinService {

	public void joinProcess(UserDto userDto) {
		
		String username = userDto.getUsername();
		String password = userDto.getPassword();
	}
	
}
