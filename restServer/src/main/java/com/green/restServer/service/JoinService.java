package com.green.restServer.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.green.restServer.dto.CompanyDto;
import com.green.restServer.dto.UserDto;
import com.green.restServer.entity.Company;
import com.green.restServer.entity.User;
import com.green.restServer.repository.CompanyRepository;
import com.green.restServer.repository.UserRepository;


@Service
public class JoinService {

	@Autowired
	UserRepository userRepository;
	
	@Autowired
	CompanyRepository companyRepository;
	
	public void joinProcess(UserDto userDto) {
		
		String username = userDto.getUsername();
		String password = userDto.getPassword();
		
		System.out.println(username);
		System.out.println(password);
		
		Boolean isExist = userRepository.existsByUsername(username);
	
		System.out.println(isExist);
		
	if(isExist) {
		
		return;
	
	}
	
	User data = new User();
	
	data.setUsername(username);
	data.setUname(userDto.getUname());
	data.setRole("ROLE_MEMBER");
	data.setPassword(password);
	data.setBirthDate(userDto.getBirthDate());
	data.setGender(userDto.getGender());
	data.setEmail(userDto.getEmail());
	data.setTel(userDto.getTel());
	data.setUaddr(userDto.getUaddr());
	
	userRepository.save(data);
	

	}
	
	public void joinProcess2(CompanyDto companyDto) {
		
		String username = companyDto.getUsername();
		String password = companyDto.getPassword();
		
		Boolean isExist = companyRepository.existsByUsername(username);
		
		if(isExist) {
			
			return;
		}
		
		Company data2 = new Company();
		
		data2.setUsername(username);
		data2.setPassword(password);
		data2.setCname(companyDto.getCname());
		data2.setCeo(companyDto.getCeo());
		data2.setCnum(companyDto.getCnum());
		data2.setCaddr(companyDto.getCaddr());
		data2.setSector(companyDto.getSector());
		data2.setEmployees(companyDto.getEmployees());
		data2.setUrl(companyDto.getUrl());
		data2.setSize(companyDto.getSize());
		data2.setMajor(companyDto.getMajor());
		data2.setYrSales(companyDto.getYrSales());
		data2.setCRole("ROLE_COMPANY");
		
		companyRepository.save(data2);
		
	}
	
}
