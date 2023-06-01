package org.zerock.mapper;

import java.util.List;

import org.zerock.domain.MemberVO;

public interface MemberMapper {
	
	public List<MemberVO> getUserList();
	
	public int signUp(MemberVO vo);
}
