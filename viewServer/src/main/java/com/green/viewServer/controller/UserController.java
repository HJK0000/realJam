package com.green.viewServer.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/user")
public class UserController {
	
	@RequestMapping("/mypage")
	public String mypage() {
		//model.addAttribute("username", username);
		return "user/mypage";
	}
	
	@RequestMapping("/usermain")
	public String usermain() {
		return "usermain";
	}
	
	@RequestMapping("/resumeForm")
	public String resumeForm() {
		return "user/resumeForm";
	}
	
	@RequestMapping("/regForm")
	public String aFrom() {
		return "user/regForm";
	}
	
	
	@RequestMapping("/resumeList")
	public String resumeList(@RequestParam("username")String username) {
		return "user/resumeList";
	}
	
	@RequestMapping("/resumeDetail")
	public String resumeDetail(@RequestParam("rno")String rno,Model model) {
		model.addAttribute("rno", rno);
		return "user/resumeDetail";
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
	
	@RequestMapping("/offerDetailPage")
	public String offerDetailPage(@RequestParam("ono")String ono,Model model) {
		model.addAttribute("ono", ono);
		return "user/offerDetailPage";
	}
	
	@RequestMapping("/jobadList")
	public String jobadList() {
		return "user/jobAdPage";
	}
	
	@RequestMapping("/jobadDetail")
	public String jobadDetail(@RequestParam("jno")String jno, Model model) {
		model.addAttribute("jno", jno);
		
		return "user/jobadDetail";
	}
}
