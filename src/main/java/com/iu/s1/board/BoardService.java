package com.iu.s1.board;

import javax.servlet.http.HttpSession;

import org.springframework.web.multipart.MultipartFile;

public interface BoardService extends BbsService {
		
		public BoardDTO getBoardDetail(BoardDTO boardDTO)throws Exception;

		int setBoaardDelete(BbsDTO bbsDTO, HttpSession session) throws Exception;

		public BoardFileDTO getBoardFileDeteil(BoardFileDTO boardFileDTO) throws Exception;
		
		
	}