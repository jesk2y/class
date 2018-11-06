package org.zerock.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.zerock.domain.ReplyPageParam;
import org.zerock.domain.ReplyVO;
import org.zerock.mapper.BoardMapper;
import org.zerock.mapper.ReplyMapper;

import lombok.Setter;

@Service
public class ReplyServiceImpl implements ReplyService {
	
	@Setter(onMethod_=@Autowired)
	private ReplyMapper mapper;
	
	@Setter(onMethod_=@Autowired)
	private BoardMapper boardMapper;

	@Override
	public List<ReplyVO> getList(ReplyPageParam param) {
		
		return mapper.getRList(param);
	}

	@Override
	public int getCount(int bno) {
		return mapper.getRCount(bno);
	}

	@Override
	public ReplyVO read(int rno) {
		return mapper.read(rno);
	}

	@Override
	public int modify(ReplyVO vo) {
		return mapper.update(vo);
	}
	
	@Transactional
	@Override
	public int delete(int rno, int bno) {
		
		int count = mapper.delete(rno);
		
		if(count != 0) {
			boardMapper.updateReply(bno);
		}
		
		return count;
	}

	@Transactional
	@Override
	public int insert(ReplyVO vo) {
		int count = 0;
		
		if(vo.getDep() == 0) {
			count =  mapper.insert(vo);
		}else if(vo.getDep() == 1) {
			mapper.updateOrd(vo);
			count =  mapper.insertRR(vo);
		}
		
		if(count == 1) {
			boardMapper.updateReply(vo.getBno());
		}
		
		return count;
	}
	
}
