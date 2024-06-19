package com.green.restServer.repository;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.green.restServer.entity.Visitor;

public interface VisitorRepository extends JpaRepository<Visitor, Long>{

	List<Visitor> findByVisitDateTimeBetween(LocalDateTime start, LocalDateTime end);
}
