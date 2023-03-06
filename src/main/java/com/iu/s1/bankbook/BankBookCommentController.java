package com.iu.s1.bankbook;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.iu.s1.board.BbsDTO;
import com.iu.s1.board.BbsService;
import com.iu.s1.member.MemberDTO;
import com.iu.s1.util.Pager;

@Controller
@RequestMapping("/bankBookComment/*")
public class BankBookCommentController {

	
	private BbsService bankBookCommentService;
	@RequestMapping(value = "list", method =  RequestMethod.GET)
	public ModelAndView getBoardList(Pager pager)throws Exception{
		ModelAndView mv = new ModelAndView();
		
	 List<BbsDTO> ar =	bankBookCommentService.getBoardList(pager);
	
	 mv.addObject("list",ar);
	 mv.setViewName("board/list");
	 
	 
		return mv;
		
	}

	@PostMapping("add")
	public ModelAndView setBoardAdd(BankBookCommentDTO bankBookCommentDTO, HttpSession session)throws Exception{
		ModelAndView mv = new ModelAndView();
		MemberDTO memberDTO = (MemberDTO)session.getAttribute("member");
		//bankBookCommentDTO.setWriter(memberDTO.getId());
		bankBookCommentDTO.setWriter("iu");
		int result = bankBookCommentService.setBoardAdd(bankBookCommentDTO, null, null);
		mv.addObject("result", result);
		mv.setViewName("common/ajaxResult");
		return mv;
	}
	@PostMapping("delete")
public ModelAndView setBoardDelete(BankBookCommentDTO bankBookCommentDTO,HttpSession httpSession)throws Exception{
	ModelAndView mv = new ModelAndView();
int  result = bankBookCommentService.setBoaardDelete(bankBookCommentDTO, httpSession);
mv.addObject(null);
mv .setViewName(null);
	return mv;
}
	@PostMapping("update")
	public ModelAndView setBoardUpdate( BankBookCommentDTO bankBookCommentDTO, HttpSession httpSession)throws Exception{
		ModelAndView mv = new ModelAndView();
		
		int  result = bankBookCommentService.setBoaardDelete(bankBookCommentDTO ,httpSession);
		mv.addObject(null);
		mv .setViewName(null);
		return mv;
	}
	
	
	
	
	
}
