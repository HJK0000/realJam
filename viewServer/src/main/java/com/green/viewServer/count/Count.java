package com.green.viewServer.count;

import java.time.LocalDateTime;

import lombok.Data;

@Data
public class Count {

	private LocalDateTime datetime = LocalDateTime.now();
	
}
