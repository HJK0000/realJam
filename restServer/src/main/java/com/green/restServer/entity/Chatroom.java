package com.green.restServer.entity;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Data;

@Entity
@Data
public class Chatroom {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long cnum;
	
	@Column(name = "timestamp", nullable = false)
    private LocalDateTime timestamp; // 메시지 전송 시간
	
	@Column(name = "message", nullable = false)
    private String message; // 메시지 내용
	
	@ManyToOne
	@JoinColumn(name = "user_id", nullable = false)
	private User sender; // 메시지를 보낸 사용자
}
