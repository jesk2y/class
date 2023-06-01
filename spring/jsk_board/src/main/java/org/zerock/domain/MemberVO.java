package org.zerock.domain;

import javax.validation.constraints.Size;

import lombok.Data;

@Data
public class MemberVO {
	
	@Size(min = 5, max = 15, message="���̵�� 5�� �̻� 15�� �̸��̾�� �մϴ�")
	private String id;
	
	@Size(min = 6, max = 15, message="��й�ȣ�� 6�� �̻� 15�� �̸��̾�� �մϴ�")
	private String pw;
}
