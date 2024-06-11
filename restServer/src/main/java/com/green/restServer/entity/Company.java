package com.green.restServer.entity;

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
@Table(name="company")
public class Company extends BaseEntity{
	@Id
    @Column(name = "username", nullable = false, unique = true)
    private String username;

    @Column(name = "logo")
    private String logo;

    @Column(name = "cname", nullable = false)
    private String cname;

    @Column(name = "password", nullable = false)
    private String password;

    @Column(name = "ceo", nullable = false)
    private String ceo;

    @Column(name = "cnum", nullable = false)
    private String cnum;

    @Column(name = "caddr", nullable = false)
    private String caddr;

    @Column(name = "sector", nullable = false)
    private String sector;

    @Column(name = "employees", nullable = false)
    private int employees;

    @Column(name = "url")
    private String url;

    @Column(name = "size", nullable = false)
    private String size;

    @Column(name = "major", nullable = false)
    private String major;

    @Column(name = "yrSales", nullable = false)
    private String yrSales;
    
    @Column(name = "crole")
    private String cRole;
}
