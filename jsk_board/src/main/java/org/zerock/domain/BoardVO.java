package org.zerock.domain;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.annotations.Entity;
import org.hibernate.validator.constraints.NotEmpty;

import lombok.Data;


@Data
public class BoardVO {
	
	@Size(min = 2, max = 30, message="������ 2�� �̻� 30�� �̸��̾�� �մϴ�")
	private String title;
	
	@Size(min = 2, max = 10000, message="������ 2�� �̻��̾�� �մϴ�")
	private String content;
	
	private String writer;
	private int bno, reply;
	private Date regdate, updatedate;
	
	private List<BoardAttachVO> attachList;
	
}
