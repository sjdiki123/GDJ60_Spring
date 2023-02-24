package com.iu.s1.board.notice;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.iu.s1.board.BbsDTO;
import com.iu.s1.board.BbsService;
import com.iu.s1.board.BoardDTO;
import com.iu.s1.util.Pager;

@Controller
@RequestMapping("/notice/*")
public class NoticeController  {

	
	private NoticeService noticecService;
	@ModelAttribute("boardName")
	public String getBoatdname() {
		return"notice";
	}
	
@Autowired	
private BbsService  noticeService;
@RequestMapping(value = "list",method=RequestMethod.GET)
public ModelAndView getBoardList( @ModelAttribute Pager pager)throws Exception{
	ModelAndView mv =new ModelAndView();
	List<BbsDTO> ar = noticeService.getBoardList(pager);
	
	mv.addObject("list", ar);
	mv.setViewName("board/list");
	return mv;
}


  @GetMapping("add")
public ModelAndView setBoardAdd()throws Exception{
	ModelAndView mv = new ModelAndView();
	mv.setViewName("board/add");
	return mv;
	  
	  
}
@PostMapping("add")
  public ModelAndView setBoardAdd(NoticeDTO noticeDTO)throws Exception{
	ModelAndView mv = new ModelAndView();
	int result=	noticecService.setBoardAdd(noticeDTO);
	
	String message  =" 등록 실패";
	if(result>0) {
		
		message = "글이 등록 되었습니다";
	}
	
	mv.addObject("result" ,result);
	mv.addObject("url","./list");
	mv.setViewName("common/result");
	return mv;
	
	
  }

@GetMapping("detail")
public ModelAndView getBoardDetail(NoticeDTO noticeDTO)throws Exception{
	ModelAndView mv = new ModelAndView();
BoardDTO boardDTO=	noticecService.getBoardDetail(noticeDTO);
	
	mv.addObject("add",boardDTO);
	mv.setViewName("board/detail");
	return mv;
	
}




}

 