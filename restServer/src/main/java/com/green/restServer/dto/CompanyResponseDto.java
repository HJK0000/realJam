package com.green.restServer.dto;

import com.green.restServer.entity.Company;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CompanyResponseDto {

	private boolean success;
	private String message;
	private Company company;

}
