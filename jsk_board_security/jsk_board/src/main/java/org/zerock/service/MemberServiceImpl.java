package org.zerock.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.zerock.domain.MemberVO;
import org.zerock.mapper.MemberMapper;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class MemberServiceImpl implements MemberService {

	private MemberMapper mapper;
	
	@Override
	public List<MemberVO> getUserList() {
		return mapper.getUserList();
	}

	@Override
	public int signUp(MemberVO vo) {
		return mapper.signUp(vo);
	}

	
}
