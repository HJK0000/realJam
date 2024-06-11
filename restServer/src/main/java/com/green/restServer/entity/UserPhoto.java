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
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name = "userphoto")
public class UserPhoto extends BaseEntity{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long pno;
	
	@ManyToOne
	@JoinColumn(name = "user_username", referencedColumnName = "username")
	private User user;
	
	@Column(name = "new_name")
	private String newname;
	
	@Column(name = "origin_name")
	private String originname;
	
	@Column(name = "thumb_nail")
	private String thumbNail;
}
