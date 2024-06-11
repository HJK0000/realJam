package com.green.restServer.entity;

import java.time.LocalDate;
import java.time.Period;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name="user")
public class User extends BaseEntity{
	@Id
    @Column(name = "username", nullable = false, unique = true)
    private String username;
    
    @Column(name = "uname", nullable = false)
    private String uname;
    
    @Column(name = "password", nullable = false)
    private String password;
    
    @Column(name = "birthDate", nullable = false)
    private LocalDate birthDate;
    
    @Column(name = "gender", nullable = false)
    private String gender;
    
    @Column(name = "email", nullable = false)
    private String email;
    
    @Column(name = "tel", nullable = false)
    private String tel;
    
    @Column(name = "uaddr", nullable = false)
    private String uaddr;
    
    @Column(name = "role")
    private Long role;
    
    public String getGenderString() {
        return gender.equals("1") ? "여성" : "남성";
    }

    public int getAge() {
        LocalDate currentDate = LocalDate.now(); // 현재 날짜
        return Period.between(birthDate, currentDate).getYears(); // 나이 계산
    }
}
