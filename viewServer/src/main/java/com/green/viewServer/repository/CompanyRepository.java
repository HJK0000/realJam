package com.green.viewServer.repository;

import org.springframework.data.jpa.repository.JpaRepository;


public interface CompanyRepository extends JpaRepository<com.green.viewServer.entity.Company, String>{

	public com.green.viewServer.entity.Company findByUsernameAndPassword(String username, String password);

}

