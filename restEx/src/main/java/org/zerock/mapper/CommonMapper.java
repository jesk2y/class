package org.zerock.mapper;

import java.util.List;

public interface CommonMapper<VO, PK> {
	
	public int create(VO vo);
	
	public VO read(PK pk);
	
	public int update(VO vo);
	
	public int delete(PK pk);
	
	public List<VO> list(int page);
}
