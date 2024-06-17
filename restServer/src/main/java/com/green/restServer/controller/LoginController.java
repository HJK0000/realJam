package com.green.restServer.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin("*")
public class LoginController {

	
	
	@PostMapping("/userlogin")
	public String login() {
		
		
		
		return "";
	}
}
