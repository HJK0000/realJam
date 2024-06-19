package com.green.restServer.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.green.restServer.entity.Visitor;

public interface VisitorRepository extends JpaRepository<Visitor, Long>{

	long count();
}
