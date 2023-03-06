package com.iu.s1.bankbook;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.iu.s1.board.BbsDAO;
import com.iu.s1.board.BbsDTO;
import com.iu.s1.board.BbsService;
import com.iu.s1.util.Pager;
@Service
public class BankBookCommentService implements BbsService {
 @Autowired
	private BbsDAO bankBookCommentDAO;
 
	@Override
	public List<BbsDTO> getBoardList(Pager pager) throws Exception {
       pager.makRow();
       
pager.makeNum();		
		return bankBookCommentDAO.getBoardList(pager);
	}
@Override
	public int setBoardAdd(BbsDTO bbsDTO) throws Exception {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int serBoardUpdate(BbsDTO bbsDTO) throws Exception {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int setBoaardDelete(BbsDTO bbsDTO ,HttpSession httpSession) throws Exception {
		// TODO Auto-generated method stub
		return 0;
	}
	@Override
	public int setBoardAdd(BbsDTO bbsDTO, MultipartFile[] multipartFiles, HttpSession session) throws Exception {
		// TODO Auto-generated method stub
		return 0;
	}

	
}
