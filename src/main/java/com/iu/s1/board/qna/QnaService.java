package com.iu.s1.board.qna;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.iu.s1.board.BbsDTO;
import com.iu.s1.board.BoardDTO;
import com.iu.s1.board.BoardFileDTO;
import com.iu.s1.board.BoardService;
import com.iu.s1.util.FileManager;
import com.iu.s1.util.Pager;

@Service
public class QnaService  implements BoardService{
 
	@Autowired
	private QnaDAO qnaDAO;
	@Autowired
	private FileManager fileManager;
	
	@Override
	public List<BbsDTO> getBoardList(Pager pager) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int setBoardAdd(BbsDTO bbsDTO ,MultipartFile[ ]multipartFiles,HttpSession session) throws Exception {
		int result = qnaDAO.setboardAdd(bbsDTO);
		
		//file을 hdd에 저장
		String realPath=session.getServletContext().getRealPath("resources/upload/qna/");
		System.out.println(realPath);
		
		for(MultipartFile multipartFile: multipartFiles) {
			
			if(multipartFile.isEmpty()) {
				continue;
			}
			
			String fileName = fileManager.fileSave(multipartFile, realPath);
					
			//DB INSERT 
			BoardFileDTO boardFileDTO = new BoardFileDTO();
			boardFileDTO.setNum(bbsDTO.getNum());
			boardFileDTO.setFileName(fileName);
			boardFileDTO.setOrlName(multipartFile.getOriginalFilename());
			
			result=qnaDAO.setBoardFileAdd(boardFileDTO);
			
		}
		
		return result;
	}


	@Override
	public int serBoardUpdate(BbsDTO bbsDTO) throws Exception {
		// TODO Auto-generated method stub
		return 0;
	}
	
	public int setBoardDelete(BbsDTO bbsDTO ,HttpSession session) throws Exception {
	 int result =qnaDAO.setBoardDelete(bbsDTO);
	 List<BoardFileDTO> ar = qnaDAO.getBoardFileList(bbsDTO);
	
	 if(result>0) {
	
		 String realPath =session.getServletContext().getRealPath("resources/upload/qna/");
	 
	      for(BoardFileDTO boardFileDTO:ar) {
	    	  fileManager.fileDelete(realPath, boardFileDTO.getFileName());
	      }
	 }
	 
	 
	 
	 return result;
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

	@Override
	public int setBoardAdd(BbsDTO bbsDTO) throws Exception {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int setBoaardDelete(BbsDTO bbsDTO, HttpSession session) throws Exception {
		// TODO Auto-generated method stub
		return 0;
	}
	
	@Override
	public BoardFileDTO getBoardFileDeteil(BoardFileDTO boardFileDTO) throws Exception {
		// TODO Auto-generated method stub
		return qnaDAO.getBoardFileDeteil(boardFileDTO);
	}
}
