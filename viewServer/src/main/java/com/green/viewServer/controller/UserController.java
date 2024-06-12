package com.green.viewServer.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/user")
public class UserController {
	
	@RequestMapping("/mypage")
	public String mypage(@RequestParam("username")String username,Model model) {
		model.addAttribute("username", username);
		return "/user/mypage";
	}
	
	
	@RequestMapping("/resumeForm")
	public String usermain() {
		return "user/resumeForm";
	}
}
