package com.green.restServer.controller;

import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.green.restServer.entity.User;
import com.green.restServer.repository.UserRepository;

@RestController
@CrossOrigin("*")
@RequestMapping("/board")
public class BoardController {

	@Autowired
	private UserRepository userRepository;

	@PostMapping("/memBoardReg")
	public ResponseEntity<?> memBoardReg(@RequestBody Map<String, String> request) {

		String title = request.get("title");
		String content = request.get("content");
		String writer = request.get("writer");
		String username = request.get("username");
		
		System.out.println("board............................");
		System.out.println(username);
		
		User userResult = userRepository.findByUsername(username);

		if (userResult == null) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("일치하는 사용자 정보가 없어서 게시글 저장 불가합니다.");
		}

		// 사용자의 role에 따라 처리
		if (userResult.getRole() == 1) {
			// role이 1인 경우
			return ResponseEntity.ok("보드에 저장 가능");
		} else if (userResult.getRole() == 2) {
			// role이 2인 경우
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("보드에 저장 불가능한 사용자입니다.");
		} else {
			// 그 외의 경우
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("유효하지 않은 사용자 정보입니다.");
		}
	}
}
