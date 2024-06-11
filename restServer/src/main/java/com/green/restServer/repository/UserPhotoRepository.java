package com.green.restServer.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.green.restServer.entity.UserPhoto;



public interface UserPhotoRepository extends JpaRepository<UserPhoto, Long>{

}
