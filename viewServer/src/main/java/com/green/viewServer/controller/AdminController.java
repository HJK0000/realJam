package com.green.viewServer.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.green.viewServer.count.Count;

@Controller
public class AdminController {

	List<Count> list = new ArrayList<>();
	
	@RequestMapping("/")
	public String root(Model model) {
		
		Count count = new Count();
		
		list.add(count);
		
		int cnt = list.size();
		
		System.out.println(list);
		System.out.println(cnt);
		
		model.addAttribute("count", cnt);
		
		return "usermain";
	}
	
	@GetMapping("/serviceCenter")
	public void center() {
		
	}
	
	@GetMapping("/admin/dashBoard")
	public void dashBoard(Model model) {
		
		int cnt = list.size();
		
		model.addAttribute("cnt", cnt);
	}
	
	@GetMapping("/admin/helpForm")
	public void helpForm(Model model) {
		int cnt = list.size();
		
		model.addAttribute("cnt", cnt);
	}
	
	@GetMapping("/admin/helpUpdate")
	public void helpUpdate(Model model) {
		int cnt = list.size();
		
		model.addAttribute("cnt", cnt);
	}
	
	@GetMapping("/admin/helpList")
	public void helpList(Model model) {
		int cnt = list.size();
		
		model.addAttribute("cnt", cnt);
	}
	
	@GetMapping("/admin/helpDetail")
	public void helpDetail(@RequestParam ("hnum") String hnum, Model model) {
		int cnt = list.size();
		
		model.addAttribute("cnt", cnt);
		model.addAttribute("hnum", hnum);
		
	}
	
	
}
