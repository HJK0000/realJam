package com.green.restServer.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.green.restServer.entity.ApplyList;



public interface ApplyListRepository extends JpaRepository<ApplyList, Long>{
	
	@Query(value="select * from apply_list where company_username= :company_username", nativeQuery = true)
	public List<ApplyList> findByCompanyUsername(@Param("company_username") String company_username);

}
