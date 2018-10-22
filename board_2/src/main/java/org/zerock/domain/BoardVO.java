package org.zerock.domain;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

import lombok.Data;

@Data
public class BoardVO {
	private Integer bno;
	private String title, content, writer;
	private Date regdate, updatedate;
	
	
}


