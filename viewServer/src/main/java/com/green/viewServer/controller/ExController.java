package com.green.viewServer.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ExController {
	
	@RequestMapping("/")
	public String root() {
		return "index";
	}
	
	@RequestMapping("/test")
	public String testP() {
		return "test";
	}
}
