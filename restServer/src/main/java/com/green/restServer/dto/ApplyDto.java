package com.green.restServer.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ApplyDto {
	//지원구분번호
	private Long ano;
	//이력서 구분번호
	private Long rno;
	//채용공고 구분번호
	private Long jno;
	//구직자 아이디
	private String user_username;
	//지원상태
	private String applyStatus;
	//입사지원 시점의 이력서 정보
	private String save;
}
