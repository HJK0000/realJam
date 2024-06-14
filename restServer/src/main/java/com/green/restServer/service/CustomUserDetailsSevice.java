//package com.green.restServer.service;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.core.userdetails.UsernameNotFoundException;
//import org.springframework.stereotype.Service;
//
//import com.green.restServer.dto.CustomUserDetails;
//import com.green.restServer.entity.User;
//import com.green.restServer.repository.UserRepository;
//
//@Service
//public class CustomUserDetailsSevice implements UserDetailsService{
//
//	@Autowired
//	UserRepository userRepository;
//	
//	@Override
//	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
//		
//		User userData = userRepository.findByUsername(username);
//		
//		if(userData != null) {
//			
//			return new CustomUserDetails(userData);
//		}
//		
//		return null;
//	}
//
//	
//}
