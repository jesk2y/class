package org.zerock.controller;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.zerock.domain.BoardAttachVO;
import org.zerock.service.BoardService;

import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j;
import net.coobird.thumbnailator.Thumbnailator;

@Controller
@Log4j
@AllArgsConstructor
public class UploadController {
	
	private BoardService service;
	
	private String getFolder() {
		SimpleDateFormat sdf = new SimpleDateFormat("yyy-MM-dd");
		
		Date date = new Date();
		
		String str = sdf.format(date);
		
		return str.replace("-", File.separator);
	};
	
	
	@PostMapping(value="/imgDelete")
	@ResponseBody
	public ResponseEntity<String> deleteFile(String finalName, String src){
/*		log.info(finalName);
		log.info(src);*/
		File file = new File("C:\\upload"+src+"/"+finalName);
		File thumbFile = new File("C:\\upload"+src+"/s_"+finalName);
		
		file.delete();
		thumbFile.delete();
		
		return new ResponseEntity<>("delete",HttpStatus.OK);
	}
	
	@GetMapping(value="/view")
	public ResponseEntity<byte[]> viewFile(String fileName){
		int index = fileName.lastIndexOf("_");
		
		String ext = fileName.substring(index + 1);
		String origin = fileName.substring(0, index);
		
		fileName = origin+"."+ext;
		
		File file = new File("C:\\upload\\"+fileName);
		
		ResponseEntity<byte[]> result = null;
		
		HttpHeaders header = new HttpHeaders();

		try {
			header.add("Content-Type", Files.probeContentType(file.toPath()));
			result = new ResponseEntity<>(FileCopyUtils.copyToByteArray(file),
					header,HttpStatus.OK);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return result;
	}
	
	@PostMapping(value="/upload", produces="application/json; charset=UTF-8")
	@ResponseBody
	public List<BoardAttachVO> upload(MultipartFile[] files ){
		List<BoardAttachVO> result = new ArrayList<>();
		
		log.info(files);
		
		for(MultipartFile file : files) {
			//make-folder
			File uploadPath = new File("c:\\upload", getFolder());
			
			if(uploadPath.exists() == false) {
				uploadPath.mkdirs();
			}
			
			//end-folder
	
			UUID uuid = UUID.randomUUID();
			
			String originName = file.getOriginalFilename();
			String saveName = uuid.toString() + "_" + file.getOriginalFilename();
			String thumbName = "s_" + saveName;
			
			File saveFile = new File(uploadPath+"\\"+saveName);
			try {
				FileOutputStream thumbFile = new FileOutputStream(uploadPath+"\\"+thumbName);
				Thumbnailator.createThumbnail(file.getInputStream(), thumbFile, 100, 100);
				
				file.transferTo(saveFile);
				thumbFile.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
			
			int index = originName.lastIndexOf(".");
			
			String ext = originName.substring(index + 1);
			String origin = originName.substring(0, index);
			
			BoardAttachVO vo = new BoardAttachVO();
			result.add(new BoardAttachVO(uuid.toString(), uploadPath.toString().substring(9),
					origin, ext, 0));
			
		}
		return result;
	}
}
