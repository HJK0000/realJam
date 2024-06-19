/*package com.green.restServer.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.green.restServer.entity.Resume;



public interface ResumeRepository extends JpaRepository<Resume, Long>{
	
	@Query(value="select * from resume where username= :username", nativeQuery=true)
	public List<Resume> findAllByUsername(@Param("username")String username);
}
*/