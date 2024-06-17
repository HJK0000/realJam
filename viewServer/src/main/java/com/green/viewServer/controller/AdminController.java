package com.green.viewServer.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class AdminController {

	@GetMapping("/serviceCenter")
	public void center() {
		
	}
	
	@GetMapping("/dashBoard")
	public void dashBoard() {
		
	}
	
	@GetMapping("/admin/helpForm")
	public void helpForm() {
		
	}
	
	@GetMapping("/admin/helpUpdate")
	public void helpUpdate() {
		
	}
	
	@GetMapping("/admin/helpList")
	public void helpList() {
		
	}
	
	@GetMapping("/admin/helpDetail")
	public void helpDetail(@RequestParam ("hnum") String hnum, Model model) {
		
		model.addAttribute("hnum", hnum);
		
	}
	
}
