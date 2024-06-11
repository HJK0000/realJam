package com.green.restServer.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
@Table(name = "resume")
public class Resume extends BaseEntity{
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "rno", nullable = false)
    private Long rno;

	@ManyToOne
	@JoinColumn(name = "user_username", referencedColumnName = "username", nullable = false)
	private User user;

    @Column(name = "rtitle")
    private String rtitle;

    @Column(name = "def")
    private String def;

    @Column(name = "disclo")
    private String disclo;

    @Column(name = "portfolioUrl")
    private String portfolioUrl;
    
    @Column(name= "selfinfo", length = 1000)
    private String selfinfo;
}
