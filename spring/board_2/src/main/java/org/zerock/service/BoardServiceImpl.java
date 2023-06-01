package org.zerock.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.zerock.domain.BoardVO;
import org.zerock.domain.PageParam;
import org.zerock.mapper.BoardMapper;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class BoardServiceImpl implements BoardService {
	
	private BoardMapper mapper;
	
	@Override
	public List<BoardVO> getList(PageParam param) {
		return mapper.getList(param);
	}

	@Override
	public int register(BoardVO board) {
		return mapper.insert(board);
	}

	@Override
	public BoardVO read(PageParam param) {
		return mapper.read(param);
	}

	@Override
	public int modify(BoardVO board) {
		return mapper.update(board);
	}

	@Override
	public int remove(PageParam param) {
		return mapper.delete(param);
	}

	@Override
	public int getTotal(PageParam param) {
		return mapper.count(param);
	}

}
