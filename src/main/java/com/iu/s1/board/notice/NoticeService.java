package com.iu.s1.board.notice;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.iu.s1.bankbook.BankBookCommentDAO;
import com.iu.s1.board.BbsDAO;
import com.iu.s1.board.BbsDTO;
import com.iu.s1.board.BoardDTO;
import com.iu.s1.board.BoardService;
import com.iu.s1.util.Pager;

@Service
public class NoticeService  implements BoardService{

	private NoticeDAO noticeDAO;
	
	@Override
	public List<BbsDTO> getBoardList(Pager pager) throws Exception {
 pager.makRow();
 
 pager.makeNum(noticeDAO.getTotalCount(pager));
 return noticeDAO.getBoardList(pager);
 }

	@Override
	public int setBoardAdd(BbsDTO bbsDTO) throws Exception {
		// TODO Auto-generated method stub
		return noticeDAO.setboardAdd(bbsDTO);
	}

	public int setBoardDelete(BbsDTO bbsDTO , MultipartFile[] multipartFiles,  HttpSession session) throws Exception {
	
		return 0;
	}

	@Override
	public BoardDTO getBoardDetail(BoardDTO boardDTO) throws Exception {
		// TODO Auto-generated method stub
		return noticeDAO.getBoardDetail(boardDTO);
	}

	@Override
	public int setBoardAdd(BbsDTO bbsDTO, MultipartFile[] multipartFiles, HttpSession session) throws Exception {
		// TODO Auto-generated method stub
		return 0;
	}

	
}
