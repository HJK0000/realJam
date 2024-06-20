package com.green.viewServer.controller;

import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

@Controller
@RequestMapping("/company")
public class RecuitComController {

	@RequestMapping("/regi_jobadForm")
	public String regiForm(Model model) throws IOException {
		
		ObjectMapper objectMapper = new ObjectMapper();

		// korea-administrative-district.json 데이터 읽어오기
		
		List<Map<String, Object>> regionData = objectMapper.readValue(
				new ClassPathResource("static/json/korea-administrative-district.json").getFile(),
				new TypeReference<List<Map<String, Object>>>() {
				});
		Map<String, List<String>> regions = regionData.stream().collect(Collectors.toMap(map -> map.keySet().iterator().next(), // key값(서울, 부산 등)
				map -> (List<String>) map.values().iterator().next() // value 값 (구, 군 등 리스트)
		));
		
		model.addAttribute("regions", regions);
				
		return "/company/comRecruitment";
		
	}
	
	
	
	
}
