package org.zerock.domain;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class BoardAttachVO {
	
	private String uuid, uploadPath, fileName, etx;
	private int bno;
}
