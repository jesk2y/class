package org.zerock.mapper;

import java.util.List;

import org.zerock.domain.ReplyVO;

public interface ReplyMapper {

	public List<ReplyVO> getRList(int bno);
	
	public int insert(ReplyVO vo);
	
	public ReplyVO read(int rno);
	
	public int delete(int rno);
	
	public int update(ReplyVO vo);
	
}
