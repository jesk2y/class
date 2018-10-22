package org.zerock.service;

import java.util.List;

import org.zerock.domain.BoardVO;
import org.zerock.domain.PageParam;

public interface BoardService {
	public List<BoardVO> getList(PageParam parm);
	
	public int register(BoardVO board);
	
	public BoardVO read(PageParam param);
	
	public int modify(BoardVO board);
	
	public int remove(PageParam param);

	public int getTotal(PageParam param);
	
}
