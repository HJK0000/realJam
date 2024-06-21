package com.green.restServer.entity;

import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.MappedSuperclass;
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@MappedSuperclass
@Data
@AllArgsConstructor
@NoArgsConstructor
public abstract class BaseEntity {
	@Column(name = "regdate", updatable = false,  nullable = false)
    private Date regdate;

    @Column(name = "moddate", nullable = false)
    private Date moddate;
    
    @PrePersist
    protected void onCreate() {
        regdate = new java.util.Date();
    }

    @PreUpdate
    protected void onUpdate() {
        moddate = new Date();
    }
}
