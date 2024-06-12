package com.green.restServer.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.green.restServer.dto.UserDto;
import com.green.restServer.entity.Resume;
import com.green.restServer.entity.User;
import com.green.restServer.repository.ResumeRepository;
import com.green.restServer.repository.UserRepository;



@RestController
@CrossOrigin("*")
public class UserRestController {
	
	@Autowired
	ResumeRepository resumeRepo;
	
	@Autowired
	UserRepository userRepo;
	
	@GetMapping("/mypage/{username}")
	public User getMyPage(@RequestParam("username")String username) {
		Optional<User> result= userRepo.findById(username);
		
		User u = result.get();
		
		return u;
	}
	
	
	
	
	
	//이력서 등록 
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
	
	@GetMapping("/resumeList")
	public List<Resume> getResumes(UserDto userDto) {
		List<Resume> list = resumeRepo.findAllByUsername(userDto.getUsername());
		
		return list;
	}
}
