package org.zerock.service;

import java.util.List;

import org.zerock.domain.ReplyPageParam;
import org.zerock.domain.ReplyVO;

public interface ReplyService {
	
	public List<ReplyVO> getList(ReplyPageParam param);
	
	public int getCount(int bno);
	
	public ReplyVO read(int rno);
	
	public int modify(ReplyVO vo);
	
	public int delete(int rno, int bno);
	
	public int insert(ReplyVO vo);
 
}
