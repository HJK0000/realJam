package com.green.viewServer.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.green.viewServer.entity.User;
import com.green.viewServer.repository.UserRepository;

import jakarta.servlet.http.HttpSession;

@Controller
@RequestMapping("/login")
public class LoginController {

	@Autowired
	private UserRepository userRepository;
	
	@RequestMapping("/loginForm")
	public String loginForm() {
		
		
		
		return "loginForm";
	}
	
	@PostMapping("/login.do")
	public String login(@RequestParam("username") String username, @RequestParam("password") String password,
			HttpSession session) {

		User user = userRepository.findByUsernameAndPassword(username, password);

		session.setAttribute("username", user.getUsername());
		
		System.out.println(user.getUsername());
		
		return "redirect:/login/memBoard";
	}
	
	@RequestMapping("/memBoard")
	public String memBoard() {
		
		
		
		return "memBoard";
	}
	

}
