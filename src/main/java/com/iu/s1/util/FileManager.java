package com.iu.s1.util;

import java.io.File;
import java.util.Calendar;
import java.util.UUID;

import org.springframework.util.FileCopyUtils;
import org.springframework.web.multipart.MultipartFile;

public class FileManager {

	// file을 Hdd에 저장 
	public void fileSave(MultipartFile multipartFile, String path) throws Exception{
		//1 어디에 저장 할 것이가?
		// / resources/upload/bankBook/..

	//2 저장관리는 운영체제가 담당 
		File file = new File(path);
		
		//폴더가 존재하지 않으면 폴더 생성 
		if (!file .exists()) {
			file.mkdirs();
			
		}
		//3. 파일 저장 
		//
//	Calendar ca = Calendar.getInstance();
//	ca.getTimeInMillis();
String name=	UUID.randomUUID().toString();

//확장자 추가 
name = name+"_"+multipartFile.getOriginalFilename();

	System.out.println(name);
			//5 파일 저장 
	 file = new File(file, name);
	 
	// multipartFile.transferTo(file);
	 FileCopyUtils.copy(multipartFile.getBytes() ,file);
	 
	 
	
	}
	
}
