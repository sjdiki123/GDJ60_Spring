package com.iu.s1.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.OutputStream;
import java.net.URLEncoder;
import java.util.Iterator;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Component;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyEmitter;
import org.springframework.web.servlet.view.AbstractView;

import com.iu.s1.board.BoardFileDTO;

@Component("fileDownView")
public class FileDowmView extends AbstractView {

	 @Override
	protected void renderMergedOutputModel(Map<String, Object> model, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
 
	 System.out.println("filedownview");
		 	BoardFileDTO boardFileDTO = (BoardFileDTO)model.get("boardFile");
		
			/*
			 * Iterator<String> it = model.keySet().iterator();
			 * 
			 * while(it.hasNext()) { String key =it.next(); System.out.println("key" +key);
			 * }
			 */
	// key ; boardName, boardFile

		 	//경로 준비
		 	String path = (String)model.get("boardName");
		 	path = "resources/upload/"+path+"/";
		 
	 path =	request.getSession().getServletContext().getRealPath(path);
		 
	 File file = new File(path,boardFileDTO.getFileName());
	 
	 //응답시 한글 인코딩 처리 
	 response.setCharacterEncoding("UTF-8");
		 
		 //파일의 크기 
	     response.setContentLength( (int) file.length());
	     
	     // 다운시 파일이름을 지정하고 인코딩
	     String downName= boardFileDTO.getOrlName();
	     downName = URLEncoder.encode(downName, "UTF-8");
	     
	     
	     //Header 정보 설정 
	     response.setHeader("Content-Disposition", "attachment;fileName=\""+downName+"\"");
	     response.setHeader("Content-Transfer-Encoding", "binary");
	     
	     
	     
	     //전송 
	     FileInputStream fi = new FileInputStream(file);
	     OutputStream os = response.getOutputStream();
	     
	     FileCopyUtils.copy(fi, os);
	     
	     
	     // 자원 해제

	     os.close();
	     fi.close();
	     
	     
		 
	 }
}
