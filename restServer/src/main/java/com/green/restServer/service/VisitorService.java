package com.green.restServer.service;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.green.restServer.entity.Visitor;
import com.green.restServer.repository.VisitorRepository;

@Service
public class VisitorService {

	@Autowired
	VisitorRepository visitorRepository;
	
	// 방문자 기록 메서드
	public void recordVisit() {
		
        Visitor visitorCount = new Visitor(LocalDateTime.now());
        visitorRepository.save(visitorCount);
    }
	
	// 방문자 조회 메서드
	public List<Visitor> getVisitorsForPeriod(String period) {
        LocalDateTime endDate = LocalDateTime.now();
        LocalDateTime startDate;

        switch (period) {
            case "3months":
                startDate = endDate.minusMonths(3);
                break;
            case "1year":
                startDate = endDate.minusYears(1);
                break;
            case "all":
            default:
                startDate = LocalDateTime.of(2000, 1, 1, 0, 0); // 기본적으로 과거로 설정
                break;
        }

        return visitorRepository.findByVisitDateTimeBetween(startDate, endDate);
    }
}
