package com.green.restServer.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
@Table(name = "resume")
public class Resume extends BaseEntity{
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "rno", nullable = false)
    private Long rno;
	
	//이력서에 실리는 본인정보
	@ManyToOne
	@JoinColumn(name = "user_username", referencedColumnName = "username", nullable = false)
	private User user;

	//이력서 제목
    @Column(name = "rtitle")
    private String rtitle;
    
    //대표이력서
    @Column(name = "def")
    private String def;
    
    //이력서 공개여부
    @Column(name = "disclo")
    private String disclo;
    
    //포트폴리오 파일
    @Column(name = "portfolioUrl")
    private String portfolioUrl;
    
    //자기소개
    @Column(name= "selfinfo", length = 1000)
    private String selfinfo;
    
    
}
