package com.ishwor.newp.spring.boot.service.doc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import com.ishwor.newp.spring.boot.domain.Doc;

@Component
public class DocStorageService {
	

	public void saveFile(MultipartFile file) {
		String docName = file.getOriginalFilename();
		
		try {
			Doc doc = new Doc(docName,file.getContentType(), file.getBytes());
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	
}
