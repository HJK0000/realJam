//package com.green.restServer.jwt;
//
//import org.springframework.security.authentication.AuthenticationManager;
//import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
//import org.springframework.security.core.Authentication;
//import org.springframework.security.core.AuthenticationException;
//import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
//
//import jakarta.servlet.FilterChain;
//import jakarta.servlet.http.HttpServletRequest;
//import jakarta.servlet.http.HttpServletResponse;
//
//public class LoginFilter extends UsernamePasswordAuthenticationFilter{
//
//	private final AuthenticationManager authenticationManager;
//	private final JWTUtil jwtUtil;
//	
//	public LoginFilter(AuthenticationManager authenticationManager, JWTUtil jwtUtil) {
//		this.authenticationManager = authenticationManager;
//		this.jwtUtil = jwtUtil;
//	}
//	
//	
//	@Override
//	public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response) throws AuthenticationException {
//
//		//클라이언트 요청에서 username, password 추출
//		String username = obtainUsername(request);
//		String password = obtainPassword(request);
//		
//		//스프링 시큐리티에서 username과 password를 검증하기 위해서는 token에 담아야 함 - super.setAuthenticated(true); // must use super, as we override
//        UsernamePasswordAuthenticationToken authToken = new UsernamePasswordAuthenticationToken(username, password, null);
//        
//        return authenticationManager.authenticate(authToken);
//	}
//	
//	 @Override
//	 protected void successfulAuthentication(HttpServletRequest request, HttpServletResponse response, FilterChain chain, Authentication authentication) {
//		 System.out.println("success........... 굳");
//		 
//		 
//	 }
//	 
//	 @Override
//	 protected void unsuccessfulAuthentication(HttpServletRequest request, HttpServletResponse response, AuthenticationException failed) {
//		 System.out.println("fail...................");
//		 
//	 }
//	 
//	 
//	 
//	 
//}
