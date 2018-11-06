package org.zerock.domain;

import javax.validation.constraints.Size;

import lombok.Data;

@Data
public class MemberVO {
	
	@Size(min = 5, max = 15, message="아이디는 5자 이상 15자 미만이어야 합니다")
	private String id;
	
	@Size(min = 6, max = 15, message="비밀번호는 6자 이상 15자 미만이어야 합니다")
	private String pw;
}
