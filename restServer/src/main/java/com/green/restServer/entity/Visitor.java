package com.green.restServer.entity;

import java.time.LocalDateTime;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Entity
@Data
public class Visitor {

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long vid;

    private LocalDateTime visitDateTime;

    public Visitor(LocalDateTime visitDateTime) {
        this.visitDateTime = visitDateTime;
    }
}
