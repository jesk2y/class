package org.zerock.domain;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;

@Data
public class ReplyPageDTO {
	
	private List<ReplyVO> list;
	private ReplyPageParam param;
	
}
