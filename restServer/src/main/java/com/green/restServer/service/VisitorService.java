package com.green.restServer.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.green.restServer.repository.VisitorRepository;

@Service
public class VisitorService {

	@Autowired
	VisitorRepository visitorRepository;
	
	public long countAllVisitors() {
        return visitorRepository.count();
    }
}
