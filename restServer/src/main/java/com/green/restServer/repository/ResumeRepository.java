package com.green.restServer.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.green.restServer.entity.Resume;



public interface ResumeRepository extends JpaRepository<Resume, Long>{

}
