package com.green.restServer.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.green.restServer.entity.Visitor;
import com.green.restServer.service.VisitorService;

@RestController
public class MainController {

	@Autowired
	VisitorService visitorService;
	
	// 방문자 기록 API
	@PostMapping("/record")
	public void recordVisit() {
		visitorService.recordVisit();
	}
	
	// 특정 기간 동안의 방문자 조회 API
    @GetMapping("/")
    public List<Visitor> getVisitors(@RequestParam(name = "period", defaultValue = "all") String period) {
        return visitorService.getVisitorsForPeriod(period);
    }
    
    
	
}
