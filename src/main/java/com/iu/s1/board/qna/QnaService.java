package com.iu.s1.board.qna;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.iu.s1.board.BbsDAO;
import com.iu.s1.board.BbsDTO;
import com.iu.s1.board.BoardDTO;
import com.iu.s1.board.BoardService;
import com.iu.s1.util.Pager;

@Service
public class QnaService  implements BoardService{
 
	@Autowired
	private QnaDAO qnaDAO;
	
	@Override
	public List<BbsDTO> getBoardList(Pager pager) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int setBoardAdd(BbsDTO bbsDTO) throws Exception {
		// TODO Auto-generated method stub
		return qnaDAO.setboardAdd(bbsDTO);
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
		return  qnaDAO.getBoardDetail(boardDTO);
	}

	//reply
	public int setReplyAdd(QnaDTO qnaDTO)throws Exception{
		//qna DtO
		//num  부모의 글번호
		//writer.title.contents: 답글로 입력한 ㄱ값
		//ref null
		//step null
		//depth null
		//1.부모의 정보를 조회
		 QnaDTO parent= (QnaDTO)qnaDAO.getBoardDetail(qnaDTO);
		
		 // ref 부모의 ref
		qnaDTO.setRef(parent.getRef());
		
	
		qnaDTO.setStep(parent.getStep()+1);
		
		
		qnaDTO.setDepth(parent.getDepth()+1);
		
		
		//2.step update
		
	int result=	qnaDAO.setStepUpdate(parent);
		
	// 답글 insert
	
	  result = qnaDAO.serReplyAdd(parent);
		
		return result;
	}
	
}
