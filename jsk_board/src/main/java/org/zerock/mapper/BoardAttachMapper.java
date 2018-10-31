package org.zerock.mapper;

import java.util.List;

import org.zerock.domain.BoardAttachVO;

public interface BoardAttachMapper {
	
	public int insert(BoardAttachVO vo);
	
	public int delete(String uuid);
	
	public List<BoardAttachVO> findByBno(int bno);

}
