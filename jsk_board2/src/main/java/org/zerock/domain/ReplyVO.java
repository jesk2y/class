package org.zerock.domain;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.Data;
@Data
public class ReplyVO {
	private int rno;
	private int bno;
	private String reply;
	private String replyer;
	private int ord;
	private int dep;
	private char del;
	
	@JsonFormat(shape=JsonFormat.Shape.STRING, pattern="yyy-MM-dd")
	private Date replydate, updatedate;
}
