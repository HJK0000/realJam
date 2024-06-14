package com.green.restServer.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.green.restServer.dto.UserDto;
import com.green.restServer.entity.User;
import com.green.restServer.repository.UserRepository;

@Service
public class JoinService {

	@Autowired
	UserRepository userRepository;
	
	@Autowired
	BCryptPasswordEncoder bCryptPasswordEncoder;
	
	public void joinProcess(UserDto userDto) {
		
		String username = userDto.getUsername();
		String password = userDto.getPassword();
	

		//Boolean isExist = userRepository.existsByUsername(username);

		Boolean isExist = userRepository.existsByUsername(username);
	
	if(isExist) {
		
		return;
	
	}
	
	User data = new User();
	
	data.setUsername(username);
	data.setPassword(bCryptPasswordEncoder.encode(password));
	data.setRole("ROLE_MEMBER");
	
	userRepository.save(data);
	

	}
	
}
