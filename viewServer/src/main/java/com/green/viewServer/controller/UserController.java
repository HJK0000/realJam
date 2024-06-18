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
		return "user/mypage";
	}
	
	
	@RequestMapping("/resumeForm")
	public String usermain() {
		return "user/resumeForm";
	}
	
	@RequestMapping("/regForm")
	public String aFrom() {
		return "user/regForm";
	}
	
	@RequestMapping("/schoolModiForm")
	public String schoolModiForm() {
		return "user/schoolModiForm";
	}
	
	@RequestMapping("/resumeList")
	public String resumeList(@RequestParam("username")String username) {
		return "user/resumeList";
	}
	
	@RequestMapping("/modifyPage")
	public String modifyPage(@RequestParam("rno")String rno, Model model) {
		model.addAttribute("rno", rno);
		
		return "user/modifyPage";
	}
	
	@RequestMapping("/positionUserList")
	public String posiotionUserList() {
		return "user/positionUserList";
	}
}
