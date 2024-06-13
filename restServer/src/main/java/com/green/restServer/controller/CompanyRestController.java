package com.green.restServer.controller;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import com.green.restServer.entity.Company;
import com.green.restServer.repository.CompanyRepository;

import jakarta.servlet.http.HttpServletResponse;


@RestController
@CrossOrigin("*")
@RequestMapping("/com")
public class CompanyRestController {


	private CompanyRepository companyRepository;

	public CompanyRestController(CompanyRepository companyRepository) {

		this.companyRepository = companyRepository;
	}

	@GetMapping("/getCompanyInfo")
	public ResponseEntity<?> getCompanyInfo(Model model, HttpServletResponse response)throws IOException {

        String username = "com1"; // 세션에서 얻어오는 것처럼
        
        Company company = companyRepository.findById(username).orElseThrow(NullPointerException::new);

        System.out.println("getCompanyInfo..........."); 
        return ResponseEntity.status(HttpStatus.OK).body(company);
    }
	

}
