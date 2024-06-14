package com.green.restServer.dto;

import lombok.Data;

@Data
public class CompanyDto {

	private String username;
	private String password;
	private String logo;
	private String cname;
	private String ceo;
	private String cnum;
	private String caddr;
    private String sector;
    private int employees;
    private String url;
    private String size;
    private String major;
    private String yrSales;

}
