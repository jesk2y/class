package org.zerock.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Entity
@Data
@EqualsAndHashCode(of="fno")
//전통적인 방법 쓸때만 사용, fno로 indexof 찾음
public class PDSFile {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long fno;
	private String fname;

}
