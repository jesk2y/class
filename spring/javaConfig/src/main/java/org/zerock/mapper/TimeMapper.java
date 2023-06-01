package org.zerock.mapper;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;

public interface TimeMapper {
	
	@Select("select now()")
	public String getTime();
	
	@Insert("insert into table1(content) values (#{str})")
	public int insert1(String str);

	@Insert("insert into table2(content) values (#{str})")
	public int insert2(String str);
}
