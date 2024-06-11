package com.green.restServer.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.green.restServer.entity.JobAd;


public interface JobAdRepository extends JpaRepository<JobAd, Long>{

}
