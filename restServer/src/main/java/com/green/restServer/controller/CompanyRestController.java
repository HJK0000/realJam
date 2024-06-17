package com.green.restServer.controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.green.restServer.dto.CompanyDto;
import com.green.restServer.dto.CompanyResponseDto;
import com.green.restServer.dto.JobAdDto;
import com.green.restServer.entity.Company;
import com.green.restServer.entity.JobAd;
import com.green.restServer.repository.CompanyRepository;
import com.green.restServer.repository.JobAdRepository;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@RestController
//@CrossOrigin("*")
@RequestMapping("/com")
public class CompanyRestController {

	@Autowired
	private CompanyRepository companyRepository;

	@Autowired
	private JobAdRepository jobAdRepository;

	public CompanyRestController() {
	}

	public CompanyRestController(CompanyRepository companyRepository, JobAdRepository jobAdRepository) {

		this.companyRepository = companyRepository;
		this.jobAdRepository = jobAdRepository;
	}

	@GetMapping("/getCompanyInfo")
	public ResponseEntity<?> getCompanyInfo(@RequestHeader("username") String username, HttpServletResponse response)
			throws IOException {

		System.out.println("Received Username: " + username);
		Company company = companyRepository.findById(username).orElseThrow(NullPointerException::new);

		System.out.println("getCompanyInfo...........");
		System.out.println("조회한 company" + company);
		return ResponseEntity.status(HttpStatus.OK).body(company);
	}

	@PutMapping("/comUpdate")
	public ResponseEntity<?> comUpdate(@RequestBody CompanyDto companyDto, HttpServletRequest request,
			HttpServletResponse response) throws IOException {

		String username = request.getHeader("username");

		System.out.println("헤더의 username : " + username);

		System.out.println("comUpdate...........");

		Company company = new Company();

		company.setUsername(companyDto.getUsername());
		company.setPassword(companyDto.getPassword());
		company.setCname(companyDto.getCname());
		company.setLogo(companyDto.getLogo());
		company.setCeo(companyDto.getCeo());
		company.setCnum(companyDto.getCnum());
		company.setCaddr(companyDto.getCaddr());
		company.setEmployees(companyDto.getEmployees());
		company.setUrl(companyDto.getUrl());
		company.setSize(companyDto.getSize());
		company.setMajor(companyDto.getMajor());
		company.setYrSales(companyDto.getYrSales());
		company.setSector(companyDto.getSector());

		companyRepository.save(company);

		CompanyResponseDto comResponse = new CompanyResponseDto(true, "기업정보가 수정되었습니다.", company);

		return ResponseEntity.status(HttpStatus.OK).body(comResponse);
	}

	@GetMapping("/getRecruitTitle")
	public ResponseEntity<?> getRecruitTitle(@RequestHeader("Username") String username, HttpServletResponse response)
			throws IOException {

		System.out.println(username);

		List<JobAd> result = jobAdRepository.findByCompanyUsername(username);

		System.out.println("jobAdList..........." + result);
		
		if (result.isEmpty()) {

			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("해당 기업에서 작성한 채용공고를 찾을 수 없습니다.");

		}
		List<JobAdDto> jobAdDtos = result.stream().map(jobAd -> new JobAdDto(jobAd)).collect(Collectors.toList());

		System.out.println("jobAdDto..............." + jobAdDtos);

		return ResponseEntity.ok(jobAdDtos);
	}
	
	@DeleteMapping("/deleteRecruitment/{jobAdId}")
	public ResponseEntity<?> deleteRecruitment(@PathVariable("jobAdId") Long jno,  @RequestHeader("Username") String username, HttpServletResponse response) throws IOException {
		
		
		jobAdRepository.deleteById(jno);
		
		
		return ResponseEntity.ok().body("{\"message\" : \"성공적으로 삭제되었습니다\"}");
	}
	
	
	
	
	
	@PostMapping("/jobAdRegist")
	public ResponseEntity<?> jobAdRegist(@RequestBody JobAdDto jobAdDto, @RequestHeader("Username") String username,
			HttpServletResponse response) throws IOException {

		System.out.println("jobAdDto >>>" + jobAdDto);
		System.out.println("date >>> "  + jobAdDto.getWkdWkhCnt());
		JobAd jobAd = new JobAd();
		System.out.println("username >>> " + username);
		Optional<Company> result = companyRepository.findById(username);

		if (result.isPresent()) {

			Company company = result.get();

			jobAd.setCompany(company);
			jobAd.setSector1(jobAdDto.getSector1());
			jobAd.setWantedTitle(jobAdDto.getWantedTitle());
			jobAd.setPosition1(jobAdDto.getPosition1());
			jobAd.setJobCont(jobAdDto.getJobCont());
			jobAd.setYofExperiences(jobAdDto.getYofExperiences());
			jobAd.setReceiptCloseDt(jobAdDto.getReceiptCloseDt());
			jobAd.setEmpTpNm(jobAdDto.getEmpTpNm());
			jobAd.setCollectPsncnt(jobAdDto.getCollectPsncnt());
			jobAd.setSale(jobAdDto.getSale());
			jobAd.setEducondition(jobAdDto.getEducondition());
			jobAd.setMltsvcExcHope(jobAdDto.getMltsvcExcHope());
			jobAd.setNeedskill(jobAdDto.getNeedskill());
			jobAd.setRcptMthd(jobAdDto.getRcptMthd());
			jobAd.setRegion(jobAdDto.getRegion());
			jobAd.setWkdWkhCnt(jobAdDto.getWkdWkhCnt());
			jobAd.setRetirepay(jobAdDto.getRetirepay());
			jobAd.setEtcWelfare(jobAdDto.getEtcWelfare());
			jobAd.setAttachFileUrl(jobAdDto.getAttachFileUrl());
			jobAd.setAttachFileUrl2(jobAdDto.getAttachFileUrl2());
			jobAd.setSrchKeywordNm(jobAdDto.getSrchKeywordNm());
			jobAd.setSalTpCd(jobAdDto.getSalTpCd());
			jobAd.setEmpName(jobAdDto.getEmpName());
			jobAd.setEmpEmail(jobAdDto.getEmpEmail());
			jobAd.setEmpTel(jobAdDto.getEmpTel());
			jobAd.setPreference(jobAdDto.getPreference());

			jobAdRepository.save(jobAd);
			
			CompanyResponseDto comResponse = new CompanyResponseDto(true, "채용공고가 성공적으로 등록되었습니다.", company);
			
			return ResponseEntity.status(HttpStatus.OK).body(comResponse);

		} else {

			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("회사를 찾을 수 없습니다.");

		}
	}
	
	@GetMapping("/getRecruitForUpdate/{jobAdId}")
	public ResponseEntity<?> getRecruitForUpdate(@PathVariable("jobAdId") Long jno, @RequestHeader("Username") String username) throws IOException {
		
		JobAd result = jobAdRepository.findById(jno).orElseThrow(NullPointerException::new);

		
		return ResponseEntity.ok(result);
		
	}
	
	@PutMapping("/jobAdUpdate")
	public ResponseEntity<?> jobAdUpdate(@RequestBody JobAdDto jobAdDto, HttpServletRequest request, HttpServletResponse response) throws IOException {
		
		String username = request.getHeader("username");

		System.out.println("jobAdUpdate...........");

		System.out.println("헤더의 username : " + username);
		
		JobAd jobAd = new JobAd();
		
		jobAd.setWantedTitle(jobAdDto.getWantedTitle());
		jobAd.setSector1(jobAdDto.getSector1());
		jobAd.setPosition1(jobAdDto.getPosition1());
		jobAd.setCollectPsncnt(jobAdDto.getCollectPsncnt());
		jobAd.setJobCont(jobAdDto.getJobCont());
		jobAd.setEmpTpNm(jobAdDto.getEmpTpNm());
		jobAd.setRegion(jobAdDto.getRegion());
		jobAd.setEducondition(jobAdDto.getEducondition());
		jobAd.setYofExperiences(jobAdDto.getYofExperiences());
		//jobAd.setNeedskill(jobAdDto.getNeedskill());
		jobAd.setRcptMthd(jobAdDto.getRcptMthd());
		jobAd.setWkdWkhCnt(jobAdDto.getWkdWkhCnt());
		jobAd.setSalTpCd(jobAdDto.getSalTpCd());
		jobAd.setSale(jobAdDto.getSale());
		jobAd.setRetirepay(jobAdDto.getRetirepay());
		jobAd.setEtcWelfare(jobAdDto.getEtcWelfare());
		jobAd.setMltsvcExcHope(jobAdDto.getMltsvcExcHope());
		jobAd.setEmpName(jobAdDto.getEmpName());
		jobAd.setEmpTel(jobAdDto.getEmpTel());
		jobAd.setEmpEmail(jobAdDto.getEmpEmail());
		jobAd.setReceiptCloseDt(jobAdDto.getReceiptCloseDt());

		jobAdRepository.save(jobAd);
		
		
		Map<String, String> responseBody = new HashMap<>();
		responseBody.put("message", "채용공고가 수정되었습니다.");
		    
		return ResponseEntity.status(HttpStatus.OK).body(responseBody);
		
	}
	
//	jobAdDto.setCompanyUsername(jobAd.getCompany().getUsername());
//	jobAdDto.setSector1(jobAd.getSector1());
//	jobAdDto.setWantedTitle(jobAd.getWantedTitle());
//	jobAdDto.setPosition1(jobAd.getPosition1());
//	jobAdDto.setJobCont(jobAd.getJobCont());
//	jobAdDto.setYofExperiences(jobAd.getYofExperiences());
//	jobAdDto.setReceiptCloseDt(jobAd.getReceiptCloseDt());
//	jobAdDto.setEmpTpNm(jobAd.getEmpTpNm());
//	jobAdDto.setCollectPsncnt(jobAd.getCollectPsncnt());
//	jobAdDto.setSale(jobAd.getSale());
//	jobAdDto.setEducondition(jobAd.getEducondition());
//	jobAdDto.setMltsvcExcHope(jobAd.getMltsvcExcHope());
//	jobAdDto.setNeedskill(jobAd.getNeedskill());
//	jobAdDto.setRcptMthd(jobAd.getRcptMthd());
//	jobAdDto.setRegion(jobAd.getRegion());
//	jobAdDto.setWkdWkhCnt(jobAd.getWkdWkhCnt());
//	jobAdDto.setRetirepay(jobAd.getRetirepay());
//	jobAdDto.setEtcWelfare(jobAd.getEtcWelfare());

}