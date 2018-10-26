package org.zerock.domain;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor	//얘네들이 다 들어가는 생성자 생김
public class UploadDTO {
	// DB 정보 안담으므로 VO 아님
	
//	private String uploadName;
	private String originName;
	private String thumbName;
	private String ext;

}
