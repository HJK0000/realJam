package com.green.restServer.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.green.restServer.entity.School;



public interface SchoolRepository extends JpaRepository<School, Long>{

}
