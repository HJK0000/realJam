package com.green.restServer.dto;

import java.time.LocalDate;

import com.green.restServer.entity.JobAd;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class JobAdDto {

	
	private Long jno;
	private String companyUsername;
	private String sector1;
	private String wantedTitle;
	private String position1;
	private String jobCont;
	private String yofExperiences;
	private LocalDate receiptCloseDt;
	private String empTpNm;
	private int collectPsncnt;
	private String sale;
	private String Educondition;
	private String mltsvcExcHope;
	private String needskill;
	private String rcptMthd;
	private String region;
	private String WkdWkhCnt;
	private String retirepay;
	private String etcWelfare;
	private String attachFileUrl;
	private String attachFileUrl2;
	private String srchKeywordNm;
	private String salTpCd;
	private String empName;
	private String empEmail;
	private String empTel;
	private String preference;
	
	public JobAdDto(JobAd jobAd) {
		
		this.jno = jobAd.getJno();
		this.companyUsername = jobAd.getCompany().getUsername();
		this.sector1= jobAd.getSector1();
		this.wantedTitle = jobAd.getWantedTitle();
		this.position1 = jobAd.getPosition1();
		this.jobCont = jobAd.getJobCont();
		this.yofExperiences = jobAd.getYofExperiences();
		this.receiptCloseDt = jobAd.getReceiptCloseDt();
		this.empTpNm = jobAd.getEmpTpNm();
		this.collectPsncnt = jobAd.getCollectPsncnt();
		this.sale = jobAd.getSale();
		this.Educondition = jobAd.getEducondition();
		this.mltsvcExcHope = jobAd.getMltsvcExcHope();
		this.needskill = jobAd.getNeedskill();
		this.rcptMthd = jobAd.getRcptMthd();
		this.region = jobAd.getRegion();
		this.WkdWkhCnt = jobAd.getWkdWkhCnt();
		this.retirepay = jobAd.getRetirepay();
		this.etcWelfare = jobAd.getEtcWelfare();
		this.attachFileUrl = jobAd.getAttachFileUrl();
		this.attachFileUrl2 = jobAd.getAttachFileUrl2();
		this.srchKeywordNm = jobAd.getSrchKeywordNm();
		this.salTpCd = jobAd.getSalTpCd();
		this.empName = jobAd.getEmpName();
		this.empEmail = jobAd.getEmpEmail();
		this.empTel = jobAd.getEmpTel();
		this.preference = jobAd.getPreference();
		
	}
	
}
