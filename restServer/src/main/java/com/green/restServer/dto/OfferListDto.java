package com.green.restServer.dto;

import org.checkerframework.checker.lock.qual.NewObject;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class OfferListDto {
	private Long ono;
	private String user;
	private String company;
	private String title;
	private String content;
	private String copName;
	private String accept;
	private String status;
}
