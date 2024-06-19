package com.green.restServer.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.green.restServer.dto.ApplyDto;
import com.green.restServer.dto.JobAdDto;
import com.green.restServer.dto.OfferListDto;
import com.green.restServer.dto.UserDto;
import com.green.restServer.entity.ApplyList;
import com.green.restServer.entity.Company;
import com.green.restServer.entity.JobAd;
import com.green.restServer.entity.OfferList;
import com.green.restServer.entity.Resume2;
import com.green.restServer.entity.School;
import com.green.restServer.entity.User;
import com.green.restServer.repository.ApplyListRepository;
import com.green.restServer.repository.CompanyRepository;
import com.green.restServer.repository.JobAdRepository;
import com.green.restServer.repository.OfferListRepository;
import com.green.restServer.repository.Resume2Repository;
import com.green.restServer.repository.SchoolRepository;
import com.green.restServer.repository.UserRepository;

import jakarta.servlet.http.HttpServletRequest;



@RestController
@RequestMapping("/user")
public class UserRestController {
	
	//@Autowired
	//ResumeRepository resumeRepo;
	
	@Autowired
	UserRepository userRepo;
	
	@Autowired
	SchoolRepository schoolRepo;
	
	@GetMapping("/mypage/{username}")
	public User getMyPage(@PathVariable("username")String username) {
		Optional<User> result= userRepo.findById(username);
		
		User u = result.get();
		
		return u;
	}
	
	@PostMapping("/grad/{username}")
	public void postSchool(@PathVariable("username") String username, @RequestBody List<School> schools) {
		User user = userRepo.findByUserName(username);
		
		if(user == null) {
			System.out.println("user정보 없음: " + user);
			return;
		}
		System.out.println("user정보: " + user);
		System.out.println("school정보: " + schools);
		
		for(School school : schools) {
			school.setUser(user);
			System.out.println("저장되는 school정보: " + school);
			schoolRepo.save(school);
		}
	}
	
	@GetMapping("/grad/{username}")
	public List<School> getSchool(@PathVariable("username") String username){
		List<School> schoolList = schoolRepo.findByUsername(username);
		
		return schoolList;
	}
	
	@Autowired
	Resume2Repository resume2Repo; 
	
	//이력서 등록 
	@PostMapping("/resume")
	public int postResume(@RequestBody Resume2 resume, HttpServletRequest request) {
		String username = "aaaa"; //하드코딩
		
		Optional<User> result = userRepo.findById(username);
		User u = result.get();
		
		System.out.println("------------" + resume.getCompanyName());
		
		resume.setUser(u);
		
		Resume2 rs = resume2Repo.save(resume);
		
		System.out.println(rs);
		
		if(rs != null) {
			int response = 1;
			return response;
		}else {
			int response = 0;
			return response;
		}
		
	}
	
	@GetMapping("/resumeList/{user_username}")
	public List<Resume2> getResumes(@PathVariable("user_username") String username) {
		List<Resume2> list = resume2Repo.findAllByUsername(username);
		
		return list;
	}
	
	@GetMapping("/resume/{user_username}/{rno}")
	public Resume2 getDetailResume(@PathVariable("user_username") String username,
			@PathVariable("rno") String rno) {
		System.out.println(username);
		System.out.println(rno);
		
		Resume2 resume = resume2Repo.findOneByUsernameAndRno(username, rno);
		System.out.println(resume);
		return resume;
	}
	
	@PutMapping("/resume")
	public void modifyResume(@RequestBody Resume2 resume) {
		System.out.println(resume);
		String username = "aaaa";
		User user = userRepo.findByUserName(username);
		
		resume.setUser(user);
		
		System.out.println(resume);
		Resume2 modiResume = resume2Repo.save(resume);
		
		System.out.println(modiResume);
	}
	
	@DeleteMapping("/resume/{rno}")
	public void deleteResume(@PathVariable("rno") Long rno) {
		System.out.println(rno);
		
		Optional<Resume2> result = resume2Repo.findById(rno);
		Resume2 resume2 = result.get();
		
		resume2Repo.delete(resume2);
	}
	
	@Autowired
	CompanyRepository companyRepo;
	
	@GetMapping("/position/{username}")
	public List<Company> positionPage(@PathVariable("username") String username) {
		
		String hopeSector = resume2Repo.findSectorByUsernameAndDef(username, "예");
		
		System.out.println("희망업종:" + hopeSector);
		
		List<Company> list = companyRepo.findBySectors(hopeSector);
		System.out.println(list);
		
		return list;
	}
	
	@Autowired
	OfferListRepository offerListRepo;
	
	@GetMapping("/offerlist/{username}")
	public List<OfferList> UserPositionPage(@PathVariable("username") String username){
		
		List<OfferList> list= offerListRepo.findAllByUsername(username);
		
		return list;
	}
	
	
	@GetMapping("/offerlist/{ono}/{username}")
	public OfferList offerDetailPage(@PathVariable("ono")Long ono, @PathVariable("username") String username) {
		Optional<OfferList> result = offerListRepo.findById(ono);
		
		OfferList offerlist = result.get();
		System.out.println(offerlist);
		
		return offerlist;
	}
	
	@PutMapping("/offerlist")
	public void offerAccept(@RequestBody OfferListDto offerlistDto) {
		String user = offerlistDto.getUser();
		System.out.println("user정보: " + user);
		String companyid = offerlistDto.getCompany();
		System.out.println(companyid);
		
		System.out.println(offerlistDto.getCopName());
		
		User u = new User();
		u.setUsername(user);
		
		Company company = new Company();
		company.setUsername(companyid);
		
		OfferList offerlist = new OfferList();
		
		offerlist.setOno(offerlistDto.getOno());
		offerlist.setUser(u);
		offerlist.setCompany(company);
		offerlist.setTitle(offerlistDto.getTitle());
		offerlist.setContent(offerlistDto.getContent());
		offerlist.setStatus(offerlistDto.getStatus());
		offerlist.setAccept(offerlistDto.getAccept());
		offerlist.setCopName(offerlistDto.getCopName());
		
		offerListRepo.save(offerlist);
		
	}
	
	@Autowired
	JobAdRepository jobadRepo;
	
	@GetMapping("/jobad")
	public List<JobAd> jobadList() {
		List<JobAd> list= jobadRepo.findAll();
		
		return list;
	}
	
	@Autowired
	ApplyListRepository applyListRepo;
	
	@PostMapping("/job-apply")
	public ResponseEntity<String> jobApply(@RequestBody ApplyDto applyDto) {
		System.out.println("받은 데이터~~~~~~~~~~~~ " + applyDto);
		System.out.println("받은 rno~~~~~~ : " + applyDto.getRno());
		System.out.println("받은 jno~~~~~~~: " + applyDto.getJno());
		System.out.println("받은 username~~~~~~: " + applyDto.getUser_username());
	
		//System.out.println("구한 회사데이터~~~~~:" + );
		
		ApplyList applyList = new ApplyList();
		Resume2 resume = resume2Repo.findById(applyDto.getRno()).orElseThrow();
		JobAd jobAd = jobadRepo.findById(applyDto.getJno()).orElseThrow();
		User user = userRepo.findByUsername(applyDto.getUser_username());
		System.out.println("구한 유저데이터~~~~~:" + user);
		
		Company company = jobAd.getCompany();
		
		System.out.println("구한 회사데이터~~~~~:" + company);
		
		applyList.setResume(resume);
		applyList.setJobAd(jobAd);
		applyList.setUser(user);
		applyList.setCompany(company);
		applyList.setStatus(0);
		applyList.setSave(applyDto.getSave());
		
		applyListRepo.save(applyList);
		
		return ResponseEntity.ok("지원이 완료되었습니다.");
	}
	
	@GetMapping("/job-apply/{username}")
	public List<ApplyList> getMyApply(@PathVariable("username")String username){
		
		List<ApplyList> list= applyListRepo.findByUserUsername(username);
		
		return list;
	}
	
}
