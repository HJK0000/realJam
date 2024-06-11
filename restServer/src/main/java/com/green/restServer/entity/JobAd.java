package com.green.restServer.entity;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

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
import lombok.extern.slf4j.Slf4j;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
@Slf4j
@Table(name = "jobad")
public class JobAd extends BaseEntity{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "jno")
	private Long jno;

	@ManyToOne
	@JoinColumn(name = "company_username", referencedColumnName = "username", nullable = false)
	private Company company;

	@Column(name = "sector1", nullable = false, length = 30)
	private String sector1;
	
	@Column(name = "wantedTitle", nullable = false, length = 100)
	private String wantedTitle;

	@Column(name = "position1", nullable = false, length = 30)
	private String position1;
	
	//직무내용
	@Column(name = "jobCont", nullable = false, columnDefinition = "TEXT")
	private String jobCont;
	
	//경력제한
	@Column(name = "yofExperiences", length = 10)
	private String yofExperiences;
	
	//접수마감일
	@Column(name = "receiptCloseDt", nullable = false)
	private LocalDate receiptCloseDt;
	
	//고용형태
	@Column(name = "empTpNm", nullable = false, length = 30)
	private String empTpNm;
	
	//모집인원
	@Column(name = "collectPsncnt", nullable = false)
	private int collectPsncnt;

	//임금
	@Column(name = "sale", nullable = false, length = 1000)
	private String sale;
	
	//학력조건
	@Column(name = "Educondition", nullable = false, length = 10)
	private String Educondition;
	
	//병역특례채용희망
	@Column(name = "mltsvcExcHope",length = 10)
	private String mltsvcExcHope;
	
	//필요스킬
	@Column(name = "needskill", columnDefinition = "TEXT")
	private String needskill;

	//접수방법
	@Column(name = "rcptMthd", length = 10)
	private String rcptMthd;

	//근무지역
	@Column(name = "region", nullable = false, length = 10)
	private String region;
	
	//근무시간
	@Column(name = "WkdWkhCnt", nullable = false, length = 50)
	private String WkdWkhCnt;
	
	//퇴직금
	@Column(name = "retirepay", length = 30)
	private String retirepay;
	
	//기타복리후생
	@Column(name = "etcWelfare", nullable = false, columnDefinition = "TEXT")
	private String etcWelfare;

	//회사소개첨부파일
	@Column(name = "attachFileUrl", columnDefinition = "TEXT")
	private String attachFileUrl;
	
	//제출서류양식첨부
	@Column(name = "attachFileUrl2",columnDefinition = "TEXT")
	private String attachFileUrl2;
	
	//키워드
	@Column(name = "srchKeywordNm", columnDefinition = "TEXT")
	private String srchKeywordNm;
	
	//임금형태(월급,연봉)
	@Column(name = "salTpCd", nullable = false, length = 20, columnDefinition = "VARCHAR(20)")
	private String salTpCd;
	
	//담당자 이름
	@Column(name = "empName", nullable = false, length = 30)
	private String empName;

	//담당자 이메일
	@Column(name = "empEmail", nullable = false, length = 40)
	private String empEmail;

	// '' 연락처
	@Column(name = "empTel", nullable = false, length = 20)
	private String empTel;
	
	
	public List<String> getJobContList() {
	    try {
	        return new ObjectMapper().readValue(jobCont, new TypeReference<List<String>>() {});
	    } catch (JsonProcessingException e) {
	        log.error("Error parsing jobCont JSON: {}", e.getMessage());
	        return Collections.emptyList(); // or throw an exception
	    }
	}

	public List<String> getNeedskillList() {
	    try {
	        return new ObjectMapper().readValue(needskill, new TypeReference<List<String>>() {});
	    } catch (JsonProcessingException e) {
	        log.error("Error parsing needskill JSON: {}", e.getMessage());
	        return Collections.emptyList(); // or throw an exception
	    }
	}

	public List<String> getSrchKeywordNmList() {
	    try {
	        return new ObjectMapper().readValue(srchKeywordNm, new TypeReference<List<String>>() {});
	    } catch (JsonProcessingException e) {
	        log.error("Error parsing srchKeywordNm JSON: {}", e.getMessage());
	        return Collections.emptyList(); // or throw an exception
	    }
	}
	
	public List<Integer> getWkdWkhCntList2() {
	    try {
	        Map<String, String> wkdWkhCntMap = new ObjectMapper().readValue(WkdWkhCnt, new TypeReference<Map<String, String>>() {});
	        List<Integer> wkdWkhCntList = new ArrayList<>();
	        String[] startTimeParts = wkdWkhCntMap.get("근무시작시간").split(":");
	        String[] endTimeParts = wkdWkhCntMap.get("근무종료시간").split(":");

	        // 0 제거 로직 추가
	        wkdWkhCntList.add(Integer.parseInt(startTimeParts[0].replaceFirst("^0+(?!$)", ""))); // 시 (0 제거)
	        wkdWkhCntList.add(Integer.parseInt(startTimeParts[1].replaceFirst("^0+(?!$)", ""))); // 분 (0 제거)
	        wkdWkhCntList.add(Integer.parseInt(endTimeParts[0].replaceFirst("^0+(?!$)", "")));   // 시 (0 제거)
	        wkdWkhCntList.add(Integer.parseInt(endTimeParts[1].replaceFirst("^0+(?!$)", "")));   // 분 (0 제거)

	        return wkdWkhCntList;
	    } catch (JsonProcessingException e) {
	        log.error("Error parsing WkdWkhCnt JSON: {}", e.getMessage());
	        return Collections.emptyList();
	    }
	}
	
	public List<String> getWkdWkhCntList() {
	    try {
	        Map<String, String> wkdWkhCntMap = new ObjectMapper().readValue(WkdWkhCnt, new TypeReference<Map<String, String>>() {});
	        List<String> wkdWkhCntList = new ArrayList<>();
	        wkdWkhCntList.add(wkdWkhCntMap.get("근무시작시간").replace(":", "시 ") + "분 ~ ");
	        wkdWkhCntList.add(wkdWkhCntMap.get("근무종료시간").replace(":", "시 ") + "분");
	        return wkdWkhCntList;
	    } catch (JsonProcessingException e) {
	        log.error("Error parsing WkdWkhCnt JSON: {}", e.getMessage());
	        return Collections.emptyList();
	    }
	}
}
