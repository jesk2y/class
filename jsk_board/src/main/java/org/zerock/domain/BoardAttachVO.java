package org.zerock.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor	// 파라미터 없는 기본 생성자를 만듪어준다
@AllArgsConstructor	// 자동으로 생성자 만들어주는 대신에 파라미터 없는 기본 생성자는 사라진다
public class BoardAttachVO {
	
	private String uuid;
	private String uploadpath;
	private String filename;
	private String etx;
	private int bno;
}
