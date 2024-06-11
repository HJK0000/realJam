package com.green.restServer.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.green.restServer.entity.License;



public interface LicenseRepository extends JpaRepository<License, Long>{

}
