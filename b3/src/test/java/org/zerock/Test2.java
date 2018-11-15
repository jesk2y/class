package org.zerock;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import javax.transaction.Transactional;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Commit;
import org.springframework.test.context.junit4.SpringRunner;
import org.zerock.domain.PDS;
import org.zerock.domain.PDSFile;
import org.zerock.persistence.PDSRepository;

import lombok.Setter;
import lombok.extern.java.Log;

@Commit
@RunWith(SpringRunner.class)
@SpringBootTest
@Log
public class Test2 {
	
	@Setter(onMethod_=@Autowired)
	private PDSRepository pdsRepository;
	
	@Test
	public void testInsert() {
		
		PDS vo = new PDS();
		vo.setTitle("samplePDS");
		vo.setWriter("user00");
		List<PDSFile> list = IntStream.range(0, 3).mapToObj(i -> {
			PDSFile fileObj = new PDSFile();
			fileObj.setFname("파일이름" + i);
			
			return fileObj;
		}).collect(Collectors.toList());
		
		vo.setFiles(list);
		log.info(vo+"");
		
		pdsRepository.save(vo);
	}

	@Transactional
	@Test
	public void testRead() {
		
		pdsRepository.findById(1L).ifPresent(vo -> log.info(""+vo));
	}

	@Transactional
	@Test
	public void testUpdate() {
		pdsRepository.updatePDSFile(3L, "파일수정이름한국");
	}
	
	@Transactional
	@Test
	public void testDelete() {
		pdsRepository.deletePDSFile(3L);
	}
	
	@Transactional
	@Test
	public void testOldway() {
		
		PDS pds = pdsRepository.findById(1L).get();
		
		List<PDSFile> files = pds.getFiles();
				
		PDSFile newFile = new PDSFile();
		newFile.setFno(2L);
		newFile.setFname("2번파일이름수정");
		
		int idx = files.indexOf(newFile);

		if(idx >= 0) {

			files.remove(idx);
			files.add(newFile);
		}
		
		pds.setFiles(files);
		
		pdsRepository.save(pds);
	}
	
}
