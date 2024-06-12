package com.green.viewServer.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/com")
public class CompanyController {

	@RequestMapping("/")
	public String index() {
		
		// 인덱스 페이지가 로그인 페이지 대체
		
		return "index";
	}
	
	
	@RequestMapping("/myPage")
	public String myPage(@RequestParam("cname") String cname, @RequestParam("ceo") String ceo, @RequestParam("caddr") String caddr,
			@RequestParam("cnum") String cnum, @RequestParam("employees") int employees, @RequestParam("logo") String logo,
			@RequestParam("major") String major, @RequestParam("sector") String sector, @RequestParam("size") String size,
			@RequestParam("yrSales") String yrSales, Model model) {

		model.addAttribute("cname", cname);
		model.addAttribute("ceo", ceo);
		model.addAttribute("caddr", caddr);
		model.addAttribute("cnum", cnum);
		model.addAttribute("employees", employees);
		model.addAttribute("logo", logo);
		model.addAttribute("major", major);
		model.addAttribute("sector", sector);
		model.addAttribute("size", size);
		model.addAttribute("yrSales", yrSales);

		return "company/cMyPage";
	}
}
