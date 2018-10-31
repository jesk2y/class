package org.zerock.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor	// �Ķ���� ���� �⺻ �����ڸ� ���վ��ش�
@AllArgsConstructor	// �ڵ����� ������ ������ִ� ��ſ� �Ķ���� ���� �⺻ �����ڴ� �������
public class BoardAttachVO {
	
	private String uuid;
	private String uploadpath;
	private String filename;
	private String etx;
	private int bno;
}
