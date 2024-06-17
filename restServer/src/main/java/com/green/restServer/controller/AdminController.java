package com.green.restServer.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AdminController {

	@PostMapping("/help")
	public String regHelp() {
		
		return "";
	}
	
	
	@GetMapping("/helpDetail")
	public String getHelpDetail() {
		
		return "";
	}
	
	@GetMapping("/help")
	public String getHelpList() {
		
		return "";
	}
	
	
}
