package com.green.restServer.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.green.restServer.dto.HelpDto;
import com.green.restServer.entity.Help;
import com.green.restServer.repository.HelpRepository;
import com.green.restServer.service.HelpService;

@RestController
@RequestMapping("/help")
public class AdminController {

	@Autowired
	HelpService helpService;
	
	@Autowired
	HelpRepository helpRepository;
	
	@PostMapping("")
	public String regHelp(HelpDto helpDto) {
		
		helpService.regProcess(helpDto);
		
		return "ok";
	}
	
	@GetMapping("/{hnum}")
	public Optional<Help> getHelpDetail(@PathVariable("hnum") Long hnum) {
		
		return helpRepository.findById(hnum);
	}
	
	@GetMapping("")
	public List<Help> getHelpList() {
		
		List<Help> result = helpRepository.findAll();	
		
		return result;
	}
	
	@PutMapping("/{hnum}")
	public ResponseEntity<Help> updateHelp(@PathVariable("hnum") Long hnum, @RequestBody Help help) {
		
		System.out.println("실행");
		
		Help updatedHelp = helpService.updateHelp(hnum, help);
		
		System.out.println(updatedHelp);
		
        return ResponseEntity.ok(updatedHelp);
	}

	@DeleteMapping("/{hnum}")
	public ResponseEntity<String> delete(@PathVariable("hnum") Long hnum) {
		helpService.delete(hnum);
		
		return ResponseEntity.ok("삭제 완료");
	}
	
}
