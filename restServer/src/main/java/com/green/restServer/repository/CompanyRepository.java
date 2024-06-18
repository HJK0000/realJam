package com.green.restServer.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.green.restServer.entity.Company;


public interface CompanyRepository extends JpaRepository<Company, String>{

	public Company findByUsernameAndPassword(String username, String password);

	Boolean existsByUsername(String username);
	
	@Query(value="select * from company where sector= :sector",nativeQuery= true)
	public List<Company> findBySectors(@Param("sector")String sector);
}

