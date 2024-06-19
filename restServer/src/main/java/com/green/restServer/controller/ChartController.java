package com.green.restServer.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.green.restServer.entity.Visitor;
import com.green.restServer.repository.VisitorRepository;
import com.green.restServer.service.VisitorService;

@RestController
@RequestMapping("/visitor")
public class ChartController {

	@Autowired
	VisitorRepository visitorRepository;
	
	@Autowired
	VisitorService visitorService;
	
	@PostMapping("")
	public void regVisitor() {
		Visitor visitor = new Visitor();
		visitorRepository.save(visitor);
		
	}
	
	@GetMapping("")
	public long countAllVisitors() {
	    return visitorService.countAllVisitors();
	    
	}
	
	
}
