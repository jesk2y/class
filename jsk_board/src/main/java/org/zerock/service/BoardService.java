package org.zerock.service;

import java.util.List;

import org.zerock.domain.BoardAttachVO;
import org.zerock.domain.BoardVO;
import org.zerock.domain.PageParam;


public interface BoardService {
	
	public List<BoardVO> getList(PageParam param);
	
	public int total(PageParam param);
	
	public BoardVO read(PageParam param);
	
	public int insert(BoardVO vo);
	
	public int update(BoardVO vo);
	
	public int delete(PageParam param);
	
	public int insertFile(BoardAttachVO vo);
	
	public List<BoardAttachVO> getFileList(int bno);
	
}
