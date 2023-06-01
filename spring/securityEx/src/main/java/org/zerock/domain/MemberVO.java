package org.zerock.domain;

import java.util.Date;
import java.util.List;

import lombok.Data;

@Data
public class MemberVO {
	
	private String userid, userpw, username;
	private boolean enabled;
	private Date regdate, updatedate;
	
	private List<AuthVO> authList;	//조인해서 한꺼번에 처리 -> 쿼리문 하나만 날려도 됨
}
