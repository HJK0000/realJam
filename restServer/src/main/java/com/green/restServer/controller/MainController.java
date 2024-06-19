package com.green.restServer.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import com.green.restServer.service.VisitorService;

@RestController
public class MainController {

	@Autowired
	VisitorService visitorService;
	

	
}
