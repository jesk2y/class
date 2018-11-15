package org.zerock.persistence;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.zerock.domain.FreeBoard;
import org.zerock.domain.FreeReply;

public interface FreeReplyRepository extends CrudRepository<FreeReply, Long> {
	
	@Query("select r from free_reply r where r.board = ?1 order by r.rno asc")
	//파라미터에는 프리보드 타입 들어가야함
	public List<FreeReply> getListByReply(FreeBoard board);
}
