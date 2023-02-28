package com.iu.s1.board.notice;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.iu.s1.board.BbsDAO;

import com.iu.s1.board.BbsDTO;
import com.iu.s1.board.BoardDTO;
import com.iu.s1.board.BoardFileDTO;
import com.iu.s1.board.BoardService;
import com.iu.s1.util.FileManager;
import com.iu.s1.util.Pager;

@Service
public class  NoticeService  implements BoardService{

	private NoticeDAO noticeDAO;
	
	@Autowired
	private FileManager fileManager;
	@Override
	public List<BbsDTO> getBoardList(Pager pager) throws Exception {
 
 
 return noticeDAO.getBoardList(pager);
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
int result = noticeDAO.setboardAdd(bbsDTO);
		
		//file HDD에 저장
		String realPath=session.getServletContext().getRealPath("resources/upload/notice/");
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
			
			result=noticeDAO.setBoardFileAdd(boardFileDTO);
			
		}
		
		return result;
	}

	
	

	@Override
	public int serBoardUpdate(BbsDTO bbsDTO) throws Exception {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int setBoaardDelete(BbsDTO bbsDTO, HttpSession session) throws Exception {
		List<BoardFileDTO> ar = noticeDAO.getBoardFileList(bbsDTO);
		int result = noticeDAO.setBoardDelete(bbsDTO);
		 
		if(result>0) {
			 
			String realPath = session.getServletContext().getRealPath("resources/upload/notice/");
			 
			for(BoardFileDTO boardFileDTO:ar) {
				boolean check= fileManager.fileDelete(realPath, boardFileDTO.getFileName());
			}
			 
			 
		 }
		 
		return result;
	}


	@Override
	public int setBoardAdd(BbsDTO bbsDTO) throws Exception {
		// TODO Auto-generated method stub
		return 0;
	}
		
	@Override
	public BoardFileDTO getBoardFileDeteil(BoardFileDTO boardFileDTO) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}
	
}

