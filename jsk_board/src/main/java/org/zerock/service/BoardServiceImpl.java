package org.zerock.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.zerock.domain.BoardAttachVO;
import org.zerock.domain.BoardVO;
import org.zerock.domain.PageParam;
import org.zerock.mapper.BoardAttachMapper;
import org.zerock.mapper.BoardMapper;

import lombok.Setter;


@Service
public class BoardServiceImpl implements BoardService {

	@Setter(onMethod_=@Autowired)
	private BoardMapper boardMapper;
	
	@Setter(onMethod_=@Autowired)
	private BoardAttachMapper attachMapper;
	
	@Override
	public List<BoardVO> getList(PageParam param) {
		
		return boardMapper.getList(param);
	}

	@Override
	public int total(PageParam param) {
		return boardMapper.total(param);
	}

	@Override
	public BoardVO read(PageParam param) {
		return boardMapper.read(param);
	}

	@Override
	public int insert(BoardVO vo) {
		return boardMapper.insert(vo);
	}

	@Override
	public int update(BoardVO vo) {
		return boardMapper.update(vo);
	}

	@Override
	public int delete(PageParam param) {
		return boardMapper.delete(param);
	}

	public int insertFile(BoardAttachVO vo) {
		return attachMapper.insert(vo);
	}

	@Override
	public List<BoardAttachVO> getFileList(int bno) {
		return attachMapper.findByBno(bno);
	}

}
