package org.zerock.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.zerock.domain.BoardVO;
import org.zerock.domain.PageParam;

public interface BoardMapper {
	
	@Select("select * from tbl_board where bno > 0 order by bno desc limit #{skip}, #{display}")
	public List<BoardVO> getList(PageParam param);
	
	@Insert(" insert into tbl_board (title, content, writer) "
			+ "values (#{title}, #{content}, #{writer})")
	public int insert(BoardVO board);
	
	@Select("select * from tbl_board where bno = #{bno}")
	public BoardVO read(PageParam param);
	
	@Update("update tbl_board set title=#{title}, content=#{content}, updatedate=now() "
			+ "where bno=#{bno}")
	public int update(BoardVO board);
	
	@Delete("delete from tbl_board where bno=#{bno}")
	public int delete(PageParam param);
	
	@Select("select count(*) from tbl_board")
	public int count();
}
