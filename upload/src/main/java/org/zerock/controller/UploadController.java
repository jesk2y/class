package org.zerock.controller;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.zerock.domain.UploadDTO;

import lombok.extern.log4j.Log4j;
import net.coobird.thumbnailator.Thumbnailator;

@Log4j
@Controller

public class UploadController {

	@GetMapping(value= "/download/{fileName}", produces = {MediaType.APPLICATION_OCTET_STREAM_VALUE})
															//application/octet-stream 가 스프링에서는 상수로 빠져있음
	@ResponseBody // 순수한 데이터 보내줌
	public ResponseEntity<byte[]> download(@PathVariable("fileName") String fileName) {

		ResponseEntity<byte[]> result = null;

		String fName = fileName.substring(0, fileName.lastIndexOf("_"));

		String ext = fileName.substring(fileName.lastIndexOf("_") + 1);

		String total = fName + "." + ext;
		log.info(total);
		int under = total.indexOf("_");
		
		String totalOrigin = total.substring(under + 1); // uuid 자름
		try {

			File target = new File("C:\\upload\\" + total);
			
			String downName = new String(totalOrigin.getBytes("UTF-8"),"ISO-8859-1");
			
			
			HttpHeaders header = new HttpHeaders();
			header.add("Content-Disposition", "attachment; filename="+downName);

			byte[] arr = FileCopyUtils.copyToByteArray(target);
			result = new ResponseEntity<>(arr, header, HttpStatus.OK);
			// mime 타입 만들어줌

		} catch (Exception e) {
			e.printStackTrace();
		}

		return result;
	}

	@GetMapping("/view/{fileName}")
	@ResponseBody //없어도 되나 쓰는게 좋음
	public ResponseEntity<byte[]> viewFile(@PathVariable("fileName") String fileName) {
		//원래는 그냥 Byte 타입으로 리턴해줘서 순수한 데이터를 전달가능하나, 세밀한 제어를 위해 ResponseEntity를 사용한다
		//일반 Byte타입으로 리턴하면 외계문자가 나온다 , 이유 : Headers의 Content-Type이 text/html으로 되어있기 때문
		log.info("FileName: " + fileName);

		String fName = fileName.substring(0, fileName.lastIndexOf("_"));

		String ext = fileName.substring(fileName.lastIndexOf("_") + 1);

		String total = fName + "." + ext;


		ResponseEntity<byte[]> result = null;
		//HTTP Status 와 사용자 지정 데이터를 넣을수 있게 만들어진 객체

		try {

			File target = new File("C:\\upload\\" + total);

			HttpHeaders header = new HttpHeaders();
			header.add("Content-type", Files.probeContentType(target.toPath()));
			// 브라우저에 밀어넣는 데이터타입 알려줌
			byte[] arr = FileCopyUtils.copyToByteArray(target);
			result = new ResponseEntity<>(arr, header, HttpStatus.OK);
			// mime 타입 만들어줌
			//ResponseEntity 안쓰고도 헤더값 넘길수 있으나 계속 바귀는 헤더값 조절을 못하게 된다.
		} catch (IOException e) {
			e.printStackTrace();
		}

		return result;
	}

	@PostMapping(value = "/upload", produces = "application/json; charset=UTF-8")
	//produces 안붙이면 result타입이 일반 xml이 되버림
	@ResponseBody
	public List<UploadDTO> upload(MultipartFile[] files) {

		List<UploadDTO> result = new ArrayList<>();

		for (MultipartFile file : files) {
			log.info(file.getOriginalFilename());
			log.info(file.getContentType());
			log.info(file.getSize());

			UUID uuid = UUID.randomUUID();

			String saveFileName = uuid.toString() + "_" + file.getOriginalFilename();
			String thumbFileName = "s_" + saveFileName;

			File saveFile = new File("C:\\upload\\" + saveFileName);
			FileOutputStream thumbFile = null;

			try {
				thumbFile = new FileOutputStream("C:\\upload\\" + thumbFileName);

				Thumbnailator.createThumbnail(file.getInputStream(), thumbFile, 100, 100);

				thumbFile.close();

				file.transferTo(saveFile);	// 썸네일 클로즈까지 하고 넣어줘야함

				result.add(new UploadDTO(file.getOriginalFilename(),
						thumbFileName.substring(0, thumbFileName.lastIndexOf(".")),
						thumbFileName.substring(thumbFileName.lastIndexOf(".") + 1)));
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		log.info(result);
		return result;
	}
}
