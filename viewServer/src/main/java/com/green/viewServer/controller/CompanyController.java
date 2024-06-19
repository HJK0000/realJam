package com.green.viewServer.controller;


import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.green.viewServer.dto.AgeCalculator;
import com.green.viewServer.entity.Company;
import com.green.viewServer.repository.CompanyRepository;

import jakarta.servlet.http.HttpSession;

@Controller
@RequestMapping("/com")
public class CompanyController {

	@Autowired
	private CompanyRepository companyRepository;
	
	
	private AgeCalculator ageCalculator;
	
	public CompanyController(AgeCalculator ageCalculator) {
		this.ageCalculator = ageCalculator;
	}
	
	
	@RequestMapping("/")
	public String index() {
		
		// 인덱스 페이지가 로그인 페이지 대체
		
		return "index";
	}
	
	
	@RequestMapping("/myPage")
	public String myPage() {
		
		return "company/comMypage";
	}
	

	
	
	@PostMapping("/comUpdate")
	public String comUpdate(@RequestBody Map<String, Object> params, Model model) {
		System.out.println("comUpdate 매서드.................");
        model.addAttribute("username", params.get("username"));
        model.addAttribute("cname", params.get("cname"));
        model.addAttribute("ceo", params.get("ceo"));
        model.addAttribute("caddr", params.get("caddr"));
        model.addAttribute("cnum", params.get("cnum"));
        model.addAttribute("employees", params.get("employees"));
        model.addAttribute("logo", params.get("logo"));
        model.addAttribute("major", params.get("major"));
        model.addAttribute("sector", params.get("sector"));
        model.addAttribute("size", params.get("size"));
        model.addAttribute("yrSales", params.get("yrSales"));
		
        return "company/comUpdate";
		
		
	}

	
	@RequestMapping("/backToMyPage")
	public String backToMyPage(@RequestParam("username") String username, @RequestParam("cname") String cname, @RequestParam("ceo") String ceo, @RequestParam("caddr") String caddr,
			@RequestParam("cnum") String cnum, @RequestParam("employees") int employees, @RequestParam("logo") String logo,
			@RequestParam("major") String major, @RequestParam("sector") String sector, @RequestParam("size") String size,
			@RequestParam("yrSales") String yrSales, Model model, HttpSession session) {
		
		
		System.out.println(username);
		
		Optional<Company> result = companyRepository.findById(username);

		Company company = result.get();
		
		model.addAttribute("cname", company.getCname());
		model.addAttribute("ceo", company.getCeo());
		model.addAttribute("caddr", company.getCaddr());
		model.addAttribute("cnum", company.getCnum());
		model.addAttribute("employees", company.getEmployees());
		model.addAttribute("logo", company.getLogo());
		model.addAttribute("major", company.getMajor());
		model.addAttribute("sector", company.getSector());
		model.addAttribute("size", company.getSize());
		model.addAttribute("yrSales", company.getYrSales());
		
		return "company/comMypage";
	}
	
	
	@RequestMapping("/toCompanyUpdate")
	public String toCompnayUpdate() {
		
		System.out.println("toCompanyUpdate................");
		
		return "company/comUpdate";
		
		
	}
	


	@RequestMapping("/recruitmentList")
	public String recruitmentList() {
		
		return "company/comRecruitment";
		
	}
	
	@RequestMapping("/jobDetail")
	public String jobDetail(@RequestParam(name = "id") Long jobId, Model model) {

		model.addAttribute("jno", jobId);
		
		return "company/comJobDetail";
	}
	
	@RequestMapping("/positionList")
	public String positionList() {
		
		
		return "company/comPosition";
		
	}
	
	@RequestMapping("/resumeList")
	public String resumeList() {
		
		
		return "company/comResumeList";
		
	}
	
		
	



	
}
