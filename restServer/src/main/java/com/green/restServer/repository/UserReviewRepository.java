package com.green.restServer.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.green.restServer.entity.UserReview;


public interface UserReviewRepository extends JpaRepository<UserReview, Long>{

}
