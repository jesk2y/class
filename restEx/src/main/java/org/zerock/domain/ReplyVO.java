package org.zerock.domain;

import java.util.Date;

import lombok.Data;

@Data
public class ReplyVO {
	private Integer rno, bno;
	private String replyer, reply;
	private Date replyDate;
}
