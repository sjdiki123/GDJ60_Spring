package com.iu.s1.board.notice;

import java.util.List;

import com.iu.s1.bankbook.BankBookCommentDAO;
import com.iu.s1.board.BbsDAO;
import com.iu.s1.board.BbsDTO;
import com.iu.s1.board.BoardDTO;
import com.iu.s1.board.BoardService;
import com.iu.s1.util.Pager;

public class NoticeService  implements BoardService{

	private NoticeDAO noticeDAO;
	
	@Override
	public List<BbsDTO> getBoardList(Pager pager) throws Exception {
 pager.makRow();
		
		return null;
	}

	@Override
	public int setBoardAdd(BbsDTO bbsDTO) throws Exception {
		// TODO Auto-generated method stub
		return noticeDAO.setboardAdd(bbsDTO);
	}

	@Override
	public int serBoardUpdate(BbsDTO bbsDTO) throws Exception {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int setBoaardDelete(BbsDTO bbsDTO) throws Exception {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public BoardDTO getBoardDetail(BoardDTO boardDTO) throws Exception {
		// TODO Auto-generated method stub
		return noticeDAO.getBoardDetail(boardDTO);
	}

	
}
