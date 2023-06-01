package org.zerock.mapper;

import org.apache.ibatis.annotations.Insert;

	public interface T1Mapper {
	@Insert("insert into tbl_t1 (col) values (#{str})")
	public void insert(String str);
}
