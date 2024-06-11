package com.green.restServer.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.green.restServer.entity.Company;


public interface CompanyRepository extends JpaRepository<Company, String>{

}
