package org.zerock.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.zerock.domain.ReplyVO;
import org.zerock.mapper.ReplyMapper;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class ReplyServiceImpl implements ReplyService {
	
	private ReplyMapper mapper;

	@Override
	public List<ReplyVO> getList(int bno) {
		return mapper.getRList(bno);
	}

	@Override
	public ReplyVO read(int rno) {
		return mapper.read(rno);
	}

	@Override
	public int modify(ReplyVO vo) {
		return mapper.update(vo);
	}

	@Override
	public int delete(int rno) {
		return mapper.delete(rno);
	}

	@Override
	public int insert(ReplyVO vo) {
		return mapper.insert(vo);
	}
	
}
