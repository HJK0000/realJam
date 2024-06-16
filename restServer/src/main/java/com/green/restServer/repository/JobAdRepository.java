package com.green.restServer.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.green.restServer.entity.JobAd;


public interface JobAdRepository extends JpaRepository<JobAd, Long>{
	
	List<JobAd> findByCompanyUsername(String companyUsername);

}
