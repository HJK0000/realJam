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
import com.green.restServer.dto.OfferListDto;
import com.green.restServer.entity.ApplyList;
import com.green.restServer.entity.Company;
import com.green.restServer.entity.JobAd;
import com.green.restServer.entity.OfferList;
import com.green.restServer.entity.Resume2;
import com.green.restServer.entity.User;
import com.green.restServer.repository.ApplyListRepository;
import com.green.restServer.repository.CompanyRepository;
import com.green.restServer.repository.JobAdRepository;
import com.green.restServer.repository.OfferListRepository;
import com.green.restServer.repository.Resume2Repository;
import com.green.restServer.repository.UserRepository;

import jakarta.persistence.EntityNotFoundException;
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

	@Autowired
	private Resume2Repository resume2Repository;
	
	@Autowired
	private OfferListRepository offerListRepository;
	
	@Autowired
	private ApplyListRepository applyListRepository;
	
	public CompanyRestController() {
	}

	public CompanyRestController(CompanyRepository companyRepository, JobAdRepository jobAdRepository, Resume2Repository resume2Repository, OfferListRepository offerListRepository, ApplyListRepository applyListRepository) {

		this.companyRepository = companyRepository;
		this.jobAdRepository = jobAdRepository;
		this.resume2Repository = resume2Repository;
		this.offerListRepository = offerListRepository;
		this.applyListRepository = applyListRepository;
	}

	@GetMapping("/getCompanyInfo/{username}")
	public ResponseEntity<?> getCompanyInfo(@PathVariable("username")String username, HttpServletResponse response)
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
			
			if(jobAdDto.getMltsvcExcHope() == null) {
				jobAd.setMltsvcExcHope("off");
			}
			
			jobAd.setNeedskill(jobAdDto.getNeedskill());
			jobAd.setRcptMthd(jobAdDto.getRcptMthd());
			jobAd.setRegion(jobAdDto.getRegion());
			jobAd.setWkdWkhCnt(jobAdDto.getWkdWkhCnt());
			jobAd.setRetirepay(jobAdDto.getRetirepay());
			
			if(jobAdDto.getRetirepay() == null) {
				jobAd.setRetirepay("off");
			}
			
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
		
		Company company = new Company();
		
		
		
		JobAd result = jobAdRepository.findById(jno).orElseThrow(NullPointerException::new);

		
		return ResponseEntity.ok(result);
		
	}
	
	@PutMapping("/jobAdUpdate")
	public ResponseEntity<?> jobAdUpdate(@RequestBody JobAdDto jobAdDto, HttpServletRequest request, HttpServletResponse response) throws IOException {
		
		String username = request.getHeader("username");

		System.out.println("jobAdUpdate...........");

		System.out.println("헤더의 username : " + username);

		Optional<Company> result = companyRepository.findById(username);	

		Company company = result.get();
		
		JobAd jobAd = new JobAd();
		
		jobAd.setCompany(company);
		jobAd.setJno(jobAdDto.getJno());
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
	
	@GetMapping("/getRecruitDetail/{jno}")
	public ResponseEntity<?> getRecruitDetail(@PathVariable("jno") Long jno, HttpServletRequest request, HttpServletResponse response) throws IOException{

		System.out.println("GetRecruitDetail................");
	
		Optional<JobAd> result = jobAdRepository.findById(jno);
	
		if(result.isEmpty()) {
			
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("해당 채용공고를 찾을 수 없습니다.");
			
			
		}
		
		JobAd jobAd = result.get();		
		
		return ResponseEntity.ok(jobAd);
	}
	
	@GetMapping("/getPositionList")
	public ResponseEntity<?> getPositionList(@RequestHeader("Username") String username, HttpServletResponse response)throws IOException {
		
		
		System.out.println("getPositionList...............");
		
		
		System.out.println("Received Username: " + username);
		Company company = companyRepository.findById(username).orElseThrow(NullPointerException::new);
		
		String sectors = company.getSector(); // 업종
		
		System.out.println("회사의 업종 " + sectors);
		
		String def = "예";
		
		List<Resume2> result = resume2Repository.findAllBySectorsAndDef(sectors, def);
		
		for(Resume2 resume2 : result) {
			
			System.out.println("업종 매치해서 가져온 이력서들" + resume2);
			System.out.println("이력서의 주인들" + resume2.getUser().getUname());
		}
		
		return ResponseEntity.status(HttpStatus.OK).body(result);

		
	}
	
	@PostMapping("/jobOffer")
	public ResponseEntity<?> jobOffer(@RequestHeader("Username") String username, @RequestBody OfferListDto offerListDto, HttpServletResponse response) throws IOException {
		
		System.out.println("jobOffer....................");
		//Dto -> entity
		
		System.out.println("헤더로 받아온 companyUsername : " + username);
		System.out.println("바디로 받아온 offerList의 내용: " + offerListDto);
		
		
		Optional<Company> comObject = companyRepository.findById(username);
		
		String cname = comObject.get().getCname();
		
		Company company = new Company();
		company.setUsername(username);
		
		User user = new User();
		user.setUsername(offerListDto.getUser());
		
		OfferList offerList = new OfferList();
		
		// 기본값 둘다 0으로 하기 (검토중)
		
		offerList.setCompany(company);
		offerList.setUser(user);
		offerList.setStatus("0");
		offerList.setAccept("0");
		offerList.setTitle(offerListDto.getTitle());
		offerList.setContent(offerListDto.getContent());
		offerList.setCopName(cname);
		
		offerListRepository.save(offerList);
		
		return ResponseEntity.status(HttpStatus.OK).body("포지션 제안이 완료되었습니다!");
		
	}

	@GetMapping("/getResumeList")
	public ResponseEntity<?> getResumeList(@RequestHeader("Username") String company_username, HttpServletResponse response) throws IOException {
		
		System.out.println("GetResumeList......................");
			
		List<ApplyList> result = applyListRepository.findByCompanyUsername(company_username);
		
		for(ApplyList list : result) {
			
			System.out.println("배열에서 뽑아낸 객체 : " + list);
		}
		
		return ResponseEntity.status(HttpStatus.OK).body(result);
		
	}
	
	@PutMapping("/applyList/{ano}")
	public ResponseEntity<?> goToPutApplyList(@PathVariable("ano") Long ano, @RequestHeader("Username") String username, HttpServletResponse response) throws IOException {
		
		System.out.println("goToPutApplyList..............");
		
		System.out.println("url로 가져온 ano" + ano);
		System.out.println("헤더의 username" + username);
		
		applyListRepository.updateApplyListStatusToAccepted(ano);
		
		
		return ResponseEntity.status(HttpStatus.OK).body("최종합격 처리가 완료되었습니다.");
	}
	
	@DeleteMapping("/applyList/{ano}/{username}")
	public ResponseEntity<?> goToDeleteApplyList(@PathVariable("ano") Long ano, @PathVariable("username") String username , @RequestHeader("Username") String comUsername, HttpServletResponse response) throws IOException{
		
		
		System.out.println("goToDeleteApplyList..............");
		System.out.println("ano :" + ano);
		System.out.println("username" + username);
		
		applyListRepository.deleteById(ano);
		
		return ResponseEntity.status(HttpStatus.OK).body("최종 불합격 처리가 완료되었습니다.");
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