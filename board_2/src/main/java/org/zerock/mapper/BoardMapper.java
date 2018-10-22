package org.zerock.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.zerock.domain.BoardVO;
import org.zerock.domain.PageParam;

public interface BoardMapper {
	
	public List<BoardVO> getList(PageParam param);
	
	public int insert(BoardVO board);
	
	public BoardVO read(PageParam param);
	
	public int update(BoardVO board);
	
	public int delete(PageParam param);
	
	public int count(PageParam param);
	
}
