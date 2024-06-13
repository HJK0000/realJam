package com.green.restServer.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.green.restServer.entity.Chatroom;

public interface ChatroomRepository extends JpaRepository<Chatroom, Long>{

}
