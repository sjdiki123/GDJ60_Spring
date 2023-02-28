package com.iu.s1.board;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.web.multipart.MultipartFile;

import com.iu.s1.util.Pager;

public interface BbsService {

	//list
	public List<BbsDTO> getBoardList(Pager pager)throws Exception;
	
	//insert
	public int setBoardAdd(BbsDTO bbsDTO ,MultipartFile[] multipartFiles,HttpSession session) throws Exception;
	
	
	//update
	public int serBoardUpdate(BbsDTO bbsDTO) throws Exception;
	
	
	//delete
	public int setBoaardDelete(BbsDTO bbsDTO ,HttpSession session) throws Exception;

	int setBoardAdd(BbsDTO bbsDTO) throws Exception;
}