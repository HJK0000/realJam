package com.green.restServer.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.green.restServer.entity.Company;
import com.green.restServer.entity.User;
import com.green.restServer.repository.CompanyRepository;
import com.green.restServer.repository.UserRepository;

import jakarta.servlet.http.HttpServletResponse;

@RestController
public class LoginController {

	@Autowired
	UserRepository userRepository;
	
	@Autowired
	CompanyRepository companyRepository; 
	
	@PostMapping("/userLogin")
	public LoginResponse userlogin(User user, HttpServletResponse response) {
		
		Optional<User> result = userRepository.findById(user.getUsername());
		
		if(result.isPresent()) {
			
			User m = result.get();
			
			String username = m.getUsername();
			String role = m.getRole();
            
            response.addHeader("username", username);
            response.addHeader("role", role);
            
            response.addHeader("Access-Control-Expose-Headers", "username, role");
            
            // Check if role matches
            if (role.equals("ROLE_ADMIN")) {
                return new LoginResponse("ADMIN", role);
            } else if(role.equals("ROLE_MEMBER")){
                // Username exists but role does not match
                return new LoginResponse("MEMBER", role);
            } else {
            	return new LoginResponse("fail", role);
            }
            
		}else {
			
			return new LoginResponse("fail", "No Member");
		}
	}
	
	private static class LoginResponse {
		private String message;
		private String role;
		
		public LoginResponse(String message, String role) {
			this.message = message;
			this.role = role;
		}
		
		public String getMessage() {
			return message;
		}
		
		public String getRole() {
			return role;
		}
	}
	
	@PostMapping("/comLogin")
	public LoginResponse comLogin(Company company, HttpServletResponse response) {
		
		Optional<Company> result = companyRepository.findById(company.getUsername());
		
		if(result.isPresent()) {
			
			Company c = result.get();
			
			String username = c.getUsername();
			String role = c.getCRole();
            
            response.addHeader("username", username);
            response.addHeader("role", role);
            
            response.addHeader("Access-Control-Expose-Headers", "username, role");
            
            // Check if role matches
            if (role.equals("ROLE_ADMIN")) {
                return new LoginResponse("ADMIN", role);
            } else if(role.equals("ROLE_MEMBER")){
                // Username exists but role does not match
                return new LoginResponse("MEMBER", role);
            } else {
            	return new LoginResponse("fail", role);
            }
            
		}else {
			
			return new LoginResponse("fail", "No Member");
		}
	}
	
}
