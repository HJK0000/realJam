package com.green.restServer.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.green.restServer.entity.User;
import com.green.restServer.repository.UserRepository;

import jakarta.servlet.http.HttpServletResponse;

@Service
public class LoginService {

	@Autowired
	UserRepository userRepository;
	
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
                return new LoginResponse("success", role);
            } else {
                // Username exists but role does not match
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
}
