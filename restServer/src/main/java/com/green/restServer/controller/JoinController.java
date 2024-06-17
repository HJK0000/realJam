package com.green.restServer.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.green.restServer.dto.CompanyDto;
import com.green.restServer.dto.UserDto;
import com.green.restServer.service.JoinService;

@RestController
public class JoinController {

	@Autowired
	JoinService joinservice;
	
	@PostMapping("/user")
	public String joinUser(UserDto userDto) {
		
		System.out.println("인증");
		
		System.out.println(userDto);
		
		joinservice.joinProcess(userDto);
		
		
		return "ok";
	}
	
	@PostMapping("/com")
	public String joinCom(CompanyDto companyDto) {
		
		System.out.println(companyDto);
		
		joinservice.joinProcess2(companyDto);
		
		return "ok";
	}
}
