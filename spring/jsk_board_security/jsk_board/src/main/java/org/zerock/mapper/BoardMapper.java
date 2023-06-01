package org.zerock.mapper;

import java.util.List;

import org.zerock.domain.BoardVO;
import org.zerock.domain.PageParam;

public interface BoardMapper {
	
	public List<BoardVO> getList(PageParam param);
	
	public int total(PageParam param);
	
	public BoardVO read(PageParam param);
	
	public int insert(BoardVO vo);
	
	public int update(BoardVO vo);
	
	public int delete(PageParam param);

	public int updateReply(int bno);

}
