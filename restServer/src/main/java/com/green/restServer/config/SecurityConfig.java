package com.green.restServer.config;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity // security에 대한 설정을 할때 import 해준다.
public class SecurityConfig { // 설정용 클래스
	
	
	
	
	@Bean
	public BCryptPasswordEncoder bCryptPasswordEncoder() {
		return new BCryptPasswordEncoder();
	}
	
	
	@Bean // 매서드에 빈을 등록하면 -> 매서드의 반환자료가 bean으로 등록됨
	public SecurityFilterChain filterChain(HttpSecurity http) throws Exception { // 이렇게 하면 security를 적용안한거나 다름없게 됨 disable설정하고 anyRequest permitAll이니까.

		//csrf 비활성
		http.csrf(auth -> auth.disable());
		
		//basic 로그인 비활성
		http.httpBasic(auth -> auth.disable());
		
		
		http.authorizeHttpRequests(auth -> auth
				.anyRequest().permitAll()
				
				);
		
		//세션 설정 : Stateless
		
		http
		.sessionManagement((session) -> session
				.sessionCreationPolicy(SessionCreationPolicy.STATELESS));
		
		
		
		
		return http.build(); // 이렇게 해주면 security가 기본으로 제공하는 loginForm 안가고 통과가능
	}

}

