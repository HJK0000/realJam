package com.green.restServer.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.green.restServer.dto.UserDto;
import com.green.restServer.entity.User;
import com.green.restServer.repository.UserRepository;


@Service
public class JoinService {

	@Autowired
	UserRepository userRepository;
	
	public void joinProcess(UserDto userDto) {
		
		String username = userDto.getUsername();
		String password = userDto.getPassword();

		
		System.out.println(username);
		System.out.println(password);
		
		
		Boolean isExist = userRepository.existsByUsername(username);
	
		System.out.println(isExist);
		
	if(isExist) {
		
		return;
	
	}
	
	User data = new User();
	
	data.setUsername(username);
	data.setRole("ROLE_MEMBER");
//	data.set
//	
//	
//	userRepository.save(data);
	

	}
	
}
