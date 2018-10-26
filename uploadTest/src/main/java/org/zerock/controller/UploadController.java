package org.zerock.controller;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.zerock.domain.UploadDTO;

import lombok.extern.log4j.Log4j;

@Controller
@Log4j
public class UploadController {
		
		@ResponseBody
		@PostMapping(value="/upload")
		public List<UploadDTO> upload(MultipartFile[] files) {
			
			List<UploadDTO> result = new ArrayList<>();
			
			for(MultipartFile file : files) {
				
				UUID uuid = UUID.randomUUID();
				log.info("=================");
				String saveFileName = uuid.toString()+"_"+file.getOriginalFilename();
				log.info("=================");
				File saveFile = new File("C:\\upload\\"+saveFileName);
				log.info("=================");
				log.info(saveFileName);
				try {
					file.transferTo(saveFile);
					log.info(saveFileName);
					result.add(new UploadDTO(saveFileName));
				} catch (Exception e) {
					
					e.printStackTrace();
				}
			}
			
			return result;
		}
}
