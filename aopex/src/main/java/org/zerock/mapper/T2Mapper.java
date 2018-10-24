package org.zerock.mapper;

import org.apache.ibatis.annotations.Insert;

public interface T2Mapper {
	
	@Insert("insert into tbl_t2 (col) values (#{str})")
	public void insert(String str);
}
