package com.green.restServer.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.green.restServer.entity.School;



public interface SchoolRepository extends JpaRepository<School, Long>{
	
	@Query(value="select * from school where user_username= :user_username",nativeQuery=true)
	public List<School> findByUsername(@Param("user_username") String username);
}
