package com.iu.s1.board.notice;

import static org.junit.Assert.*;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.iu.s1.MyTestCase;
import com.iu.s1.util.Pager;

public class Noticetest  extends MyTestCase{

	
	@Autowired
	private NoticeDAO noticeDAO;
	
    @Test
	public void setboardAddTest() throws Exception{
		
		
    NoticeDTO noticeDTO = new NoticeDTO();
    noticeDTO.setTitle(null);
    noticeDTO.setWriter(null);
    noticeDTO.setContents(null);
		
		
		
	}
	
	

}
