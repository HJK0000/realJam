package com.green.viewServer.controller;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

@Controller
@RequestMapping("/company")
public class RecuitComController {

	//@RequestMapping("/regi_jobadForm")
	//public String regiForm(Model model) throws IOException {
		
		ObjectMapper objectMapper = new ObjectMapper();

		// korea-administrative-district.json 데이터 읽어오기
		
//		List<Map<String, Object>> regionData = objectMapper.readValue(
//				new ClassPathResource("static/json/korea-administrative-district.json").getFile(),
//				new TypeReference<List<Map<String, Object>>>() {
//				});
//				
				
				
				
		
		
	}
	
	
	
	
}
