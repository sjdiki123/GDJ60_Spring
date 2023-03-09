package com.iu.s1.board.qna;

import java.io.File;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.iu.s1.board.BbsDTO;
import com.iu.s1.board.BoardDTO;
import com.iu.s1.board.BoardFileDTO;
import com.iu.s1.board.BoardService;
import com.iu.s1.util.Pager;

@Controller
@RequestMapping("/qna/**")
public class QnaController {

	
	@Autowired
	private QnaService qnaService;

	
	@ModelAttribute("boardName")
	public String getBoradName() {
		return "qna";
	}
	

@RequestMapping(value = "list", method = RequestMethod.GET)
public ModelAndView getBoardList(Pager pager)throws Exception{
	ModelAndView mv = new ModelAndView();
	List<BbsDTO> ar = qnaService.getBoardList(pager);
	
	mv.addObject("list",ar);
	mv.setViewName("board/list");
	
	
	return mv;
}

@GetMapping("add")
public ModelAndView setBoardAdd() throws Exception{
	ModelAndView mv = new ModelAndView();
	mv.setViewName("board/add");
	return mv;
}

@PostMapping("add")
public ModelAndView setBoardAdd(QnaDTO qnaDTO ,MultipartFile[] files, HttpSession session) throws Exception{
	ModelAndView mv = new ModelAndView();
int result=	qnaService.setBoardAdd(qnaDTO,files,session);
	
	String message  =" 등록 실패";
	if(result>0) {
		
		message = "글이 등록 되었습니다";
	}
	
	mv.addObject("result" ,result);
	mv.addObject("url","./list");
	mv.setViewName("common/result");
	
	
	return mv;
	
	
}
@ GetMapping("detail")
public ModelAndView getBoardDetail( QnaDTO qnaDTO)throws Exception{
	ModelAndView mv = new ModelAndView();
BoardDTO boardDTO= qnaService.getBoardDetail(qnaDTO);
	  
mv.addObject("dto",boardDTO);
mv.setViewName("board/detail");



	return mv;
	
	
}

@GetMapping("reply")
public ModelAndView setReplyAdd(BoardDTO boardDTO) throws Exception{
	ModelAndView mv = new ModelAndView();

	mv.setViewName("board/reply");
	return mv;
	
}
@PostMapping("reply")
public ModelAndView setReplyAdd(QnaDTO qnaDTO) throws Exception{
	ModelAndView mv = new ModelAndView();
	int result=	qnaService.setBoardAdd(qnaDTO, null, null);

	String message  =" 등록 실패";
	if(result>0) {
		
		message = "글이 등록 되었습니다";
	}
	
	
	mv.setViewName("board/reply");
	return mv;
	
}
@PostMapping("delete")
public ModelAndView setBoradDelete(BbsDTO bbsDTO ,HttpSession session)throws Exception{
	ModelAndView mv = new ModelAndView();
	mv.setViewName("common/result");
	
	int result = qnaService.setBoaardDelete(bbsDTO,session);
	String message ="삭제 시ㅏㄹ패";
	
	if(result>0) {
		message ="성공";
		
	}
	mv.addObject("result", message);
	mv.addObject("url", "./list");
	
	return mv;
}
@GetMapping("fileDown")
public ModelAndView getFileDown(BoardFileDTO boardFileDTO) throws Exception{
ModelAndView mv = new ModelAndView();
   boardFileDTO =qnaService.getBoardFileDeteil(boardFileDTO);

 mv.addObject("boardFile",boardFileDTO);
 mv.setViewName("fileDownView");
   
return mv;
	
}
@GetMapping("update")
public ModelAndView setBoardUpdate(BoardDTO boardDTO)throws Exception{
	ModelAndView mv = new ModelAndView();
	   boardDTO  =  qnaService.getBoardDetail(boardDTO);
	mv.addObject("dto",boardDTO);
	mv.setViewName("board/update");
	
	return mv;
}

@GetMapping("update")
public ModelAndView setBoardUpdate(BoardDTO boardDTO,MultipartFile []addFiles,HttpSession session , Long [] filLongs)throws Exception{
	ModelAndView mv = new ModelAndView();
 int result =  qnaService.serBoardUpdate(boardDTO, addFiles, session, filLongs);
	
 mv.setViewName(getBoradName());
 mv.addObject(mv);
 
	
	return mv;
}
//------------------------------------------------------------

@PostMapping("delete")
public ModelAndView setBoardFileDelete(Long fLong ) throws Exception{
	ModelAndView mv = new ModelAndView();
	int result = qnaService.setBoardFileDelete(fLong);
	
	return mv;
}





@ExceptionHandler(NullPointerException.class)
public  ModelAndView fixException() {
	ModelAndView mv = new ModelAndView();
	mv.setViewName("common/error_500");
	
	return mv;
}

@ExceptionHandler(Exception.class)
public  ModelAndView fix2Exception() {
	ModelAndView mv = new ModelAndView();
	mv.setViewName("common/error_500");
	
	return mv;
}

}
