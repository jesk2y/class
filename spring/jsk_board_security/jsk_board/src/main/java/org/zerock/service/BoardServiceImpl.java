package org.zerock.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
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

	@Transactional
	@Override
	public int insert(BoardVO vo) {
		int count = boardMapper.insert(vo);
	
		if(vo.getAttachList() == null) {
			return count;
		}
		
		vo.getAttachList().forEach(attach ->{
			attach.setBno(vo.getBno());
			attachMapper.insert(attach);
		});
		
		return count;
	}
	
	@Transactional
	@Override
	public int update(BoardVO vo) {
		int count = boardMapper.update(vo);
		
		attachMapper.delete(vo.getBno());
		
		if(count != 1 || vo.getAttachList() == null) {
			return count;
		}
		
		vo.getAttachList().forEach(attach ->{
			attach.setBno(vo.getBno());
			attachMapper.insert(attach);
		});
		
		return count;
	}

	@Override
	@Transactional
	public int delete(PageParam param) {
		
		System.out.println(param.getBno());
		attachMapper.delete(param.getBno());
		return boardMapper.delete(param);
	}

	//파일처리
	
	@Override
	public List<BoardAttachVO> getFileList(int bno) {
		return attachMapper.findByBno(bno);
	}

	@Override
	public int fileDelete(int bno) {
		return attachMapper.delete(bno);
	}

}
