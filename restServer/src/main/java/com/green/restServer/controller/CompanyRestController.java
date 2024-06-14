package com.green.restServer.controller;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.green.restServer.dto.CompanyDto;
import com.green.restServer.dto.CompanyResponseDto;
import com.green.restServer.entity.Company;
import com.green.restServer.repository.CompanyRepository;

import jakarta.servlet.http.HttpServletRequest;
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
	public ResponseEntity<?> getCompanyInfo(@RequestHeader("Username") String username, Model model, HttpServletResponse response)throws IOException {

        System.out.println(username);
        Company company = companyRepository.findById(username).orElseThrow(NullPointerException::new);

        System.out.println("getCompanyInfo..........."); 
        System.out.println("조회한 company" + company);
        return ResponseEntity.status(HttpStatus.OK).body(company);
    }
	
	@PostMapping("/comUpdate")
	public ResponseEntity<?> comUpdate(@RequestBody CompanyDto companyDto, HttpServletResponse response) throws IOException {

        System.out.println("comUpdate..........."); 
        
		Company company = new Company();
		
		company.setUsername(companyDto.getUsername());
		company.setPassword(companyDto.getPassword());
		company.setCname(companyDto.getCname());
		company.setLogo(companyDto.getLogo());
		company.setCeo(companyDto.getCeo());
		company.setCnum(companyDto.getCnum());
		company.setCaddr(companyDto.getCaddr());
		company.setEmployees(companyDto.getEmployees());
		company.setUrl(companyDto.getUrl());
		company.setSize(companyDto.getSize());
		company.setMajor(companyDto.getMajor());
		company.setYrSales(companyDto.getYrSales());
		company.setSector(companyDto.getSector());
		
		companyRepository.save(company);

		CompanyResponseDto comResponse = new CompanyResponseDto(true, "기업정보가 수정되었습니다.", company);
		
        return ResponseEntity.status(HttpStatus.OK).body(comResponse);
    }

}
