package com.green.restServer.entity;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.Period;

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
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name = "resume2")
public class Resume2 {
	
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
	
    //희망 지역1
    @Column(name = "region1", nullable = false)
	private String region1;
    
    //희망 지역2
	@Column(name = "region2")
	private String region2;

	//희망지역3
	@Column(name = "region3")
	private String region3;

	//희망 업종
	@Column(name = "sectors", nullable = false)
	private String sectors;

	//희망 직무
	@Column(name = "job", nullable = false)
	private String job;
	
	public void update(Hope newHope) {
        this.region1 = newHope.getRegion1();
        this.region2 = newHope.getRegion2();
        this.region3 = newHope.getRegion3();
        this.sectors = newHope.getSectors();
        this.job = newHope.getJob();
        // 필요에 따라 다른 필드도 업데이트
	}
	
	//경력사항 
	
	//입사일
	@Column(name = "startDate")
    private LocalDate startDate;
	//퇴사일
    @Column(name = "endDate")
    private LocalDate endDate;
    //회사명
    @Column(name = "cName")
    private String cName;
    //직급
    @Column(name = "rank")
    private String rank;
    //상태(재직 중/ 퇴사)
    @Column(name = "status")
    private String status;
    //업종
    @Column(name = "type")
    private String type;
    //직무
    @Column(name = "position")
    private String position;
    //업무
    @Column(name = "work")
    private String work;
    
    public String getCareerDuration() {
        Period period = Period.between(startDate, endDate);
        int years = period.getYears();
        int months = period.getMonths();

        StringBuilder sb = new StringBuilder();
        if (years > 0) {
            sb.append(years).append("년 ");
        }
        if (months > 0) {
            sb.append(months).append("개월");
        }

        return sb.toString().trim(); // 불필요한 공백 제거
    }
    
    public void update(Career newCareer) {
        this.startDate = newCareer.getStartDate();
        this.endDate = newCareer.getEndDate();
        this.cName = newCareer.getCName();
        this.rank = newCareer.getRank();
        this.status = newCareer.getStatus();
        this.type = newCareer.getType();
        this.position = newCareer.getPosition();
        this.work = newCareer.getWork();
        // 필요에 따라 다른 필드도 업데이트
    }
    
    //학력사항 
    
    //입학일
    @Column(name = "accDate", nullable = false)
	private LocalDate accDate;
    
    // 졸업일
	@Column(name = "gradDate", nullable = false)
	private LocalDate gradDate;

	//학교명 
	@Column(name = "eduName", nullable = false)
	private String eduName;
	//전공
	@Column(name = "major")
	private String major;
	//학점
	@Column(name = "score", precision = 3, scale = 2)
	private BigDecimal score;
	//상태(재학 중 / 졸업)
	@Column(name = "sStatus", nullable = false)
	private String schoolNow;
	
	//입학일
    @Column(name = "accDate2", nullable = true)
	private LocalDate accDate2;
    
    // 졸업일
	@Column(name = "gradDate2", nullable = true)
	private LocalDate gradDate2;

	//학교명 
	@Column(name = "eduName2", nullable = true)
	private String eduName2;
	//전공
	@Column(name = "major2")
	private String major2;
	//학점
	@Column(name = "score2", precision = 3, scale = 2)
	private BigDecimal score2;
	//상태(재학 중 / 졸업)
	@Column(name = "sStatus2", nullable = true)
	private String schoolNow2;
    
	// 자격증
	
	//자격증 명1
	@Column(name = "licensename")
	private String licensename;
	
	//발급기관1
	@Column(name = "given")
	private String given;
	
	//취득일1
	@Column(name = "getDate")
	private LocalDate getDate;
	
	
	//보유능력
	//타입1
	@Column(name = "oaType")
    private String oaType;
	//내용1
    @Column(name = "content")
    private String content;
    
    
    //사회활동 
    //시작일
    @Column(name = "startDay")
    private LocalDate startDay;
    //종료일
    @Column(name = "endDay")
    private LocalDate endDay;
    //참여기관	
    @Column(name = "org")
    private String org;
    //활동내역
    @Column(name = "econtent", columnDefinition = "TEXT")
    private String econtent;
    
}
