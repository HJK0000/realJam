package com.green.restServer.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.green.restServer.entity.Resume2;

public interface Resume2Repository extends JpaRepository<Resume2, Long>{
	
	@Query(value="select * from resume2 where user_username= :user_username", nativeQuery=true)
	public List<Resume2> findAllByUsername(@Param("user_username")String username);
	
	@Query(value="select * from resume2 where user_username= :user_username AND rno= :rno",nativeQuery=true)
	public Resume2 findOneByUsernameAndRno(@Param("user_username")String username, @Param("rno") String rno);
	
	//구직자 희망업종 구하는 쿼리문
	@Query(value="select sectors from resume2 where user_username= :user_username AND def= :def",nativeQuery=true)
	public String findSectorByUsernameAndDef(@Param("user_username")String username, @Param("def")String def);
}
