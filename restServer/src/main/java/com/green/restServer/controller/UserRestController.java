package com.green.restServer.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.green.restServer.entity.Resume;
import com.green.restServer.repository.ResumeRepository;



@RestController
@CrossOrigin("*")
public class UserRestController {
	
	@Autowired
	ResumeRepository resumeRepo;
	
	@PostMapping("/resume")
	public int postResume(Resume resume) {
		Resume rs = resumeRepo.save(resume);
		
		if(rs != null) {
			int result = 1;
			return result;
		}else {
			int result = 0;
			return result;
		}
		
	}
}
