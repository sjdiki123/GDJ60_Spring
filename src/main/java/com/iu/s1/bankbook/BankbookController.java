package com.iu.s1.bankbook;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/bankBook/*")
public class BankbookController {

	
	@Autowired
	private BankbookService bankbookService;
	
	
	// list
	@RequestMapping(value = "list",method = RequestMethod.GET)
	public ModelAndView getBankBookList () throws Exception{
		ModelAndView mv = new ModelAndView();
	 List<BankbookDTO> ar =	bankbookService.getBankBookList();
		
	 mv.setViewName("bankBook/list");
	 mv.addObject("list", ar);
		
		return mv;
		
	}
	//detail
	@RequestMapping(value = "detail",method = RequestMethod.GET)
	public ModelAndView getBankBookDetail(BankbookDTO bankbookDTO)throws Exception{
		ModelAndView mv = new ModelAndView();
               bankbookDTO= bankbookService.getBankBookDetail(bankbookDTO);
	mv.setViewName("bankBook/detail");
	mv.addObject("dto", mv);
		
		return mv;
		
	}
	//add
	@RequestMapping(value = "add",method = RequestMethod.POST)
	public ModelAndView setBankBookAdd(BankbookDTO bankbookDTO) throws Exception {
		ModelAndView mv = new ModelAndView();
	int result=	bankbookService.setBankBookAdd(bankbookDTO);
		
	mv.setViewName("redirect:./list");
		return mv;
	}
	
	//add form
	@RequestMapping(value = "add" , method = RequestMethod.GET)
	public ModelAndView setBankBookAdd(ModelAndView mv)throws Exception{
		
		mv.setViewName("bankBook/add");
		
		return mv;
	}
	
	//delete
	@RequestMapping(value = "delete" , method =RequestMethod.GET)
	public ModelAndView setBankBookDelete(BankbookDTO bankbookDTO) throws Exception{
		ModelAndView mv = new ModelAndView();
	int result=	bankbookService.setBankBookDetail(bankbookDTO);
	mv.setViewName("redirect:./list");
		return mv;
		
	}
	
	// 수정 폼 이동 
	@RequestMapping(value = "update",method =RequestMethod.GET)
	public ModelAndView setBankBookUpdate(BankbookDTO bankbookDTO)throws Exception{
		ModelAndView mv = new ModelAndView();
	bankbookDTO = bankbookService.getBankBookDetail(bankbookDTO);
		mv.setViewName("bankbook/update");
		mv.addObject("dto", bankbookDTO);
		return mv;
		
		
	}
	
	public ModelAndView setBankbookUpdate(BankbookDTO bankbookDTO,ModelAndView mv)throws Exception{
		
		return mv;
		
	}
	
	
	
}