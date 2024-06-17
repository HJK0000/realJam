package com.green.restServer.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class HelpDto {

	private Long hnum;
	private String title;
	private String content;
	
	
}
