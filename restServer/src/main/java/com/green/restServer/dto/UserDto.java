package com.green.restServer.dto;

import java.time.LocalDate;

import lombok.Data;

@Data
public class UserDto {

	private String username;
   
    private String uname;
    
    private String password;
       
    private LocalDate birthDate;
    
    private String gender;
   
    private String email;
    
    private String tel;
    
    private String uaddr;

    private Long role;
    
}
