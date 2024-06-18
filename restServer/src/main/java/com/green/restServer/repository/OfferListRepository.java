package com.green.restServer.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.green.restServer.entity.OfferList;



public interface OfferListRepository extends JpaRepository<OfferList, Long>{
	
	@Query(value="select * from offer_list where user_username= :user_username",nativeQuery=true)
	public List<OfferList> findAllByUsername(@Param("user_username")String username);
}
