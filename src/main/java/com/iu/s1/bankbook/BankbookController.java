package com.iu.s1.bankbook;

import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.iu.s1.util.Pager;

@Controller
@RequestMapping("/bankBook/*")
public class BankbookController {

	
	@Autowired
	private BankbookService bankbookService;
		// list
	@RequestMapping(value = "list",method = RequestMethod.GET)
	public ModelAndView getBankBookList (Pager pager) throws Exception{
		ModelAndView mv = new ModelAndView();
		System.out.println("server 전 " +pager.getTotalCount());
	 List<BankbookDTO> ar =	bankbookService.getBankBookList(pager);
		
		System.out.println("server gn" +pager.getTotalCount());
 
	 mv.setViewName("bankBook/list");
	 mv.addObject("list", ar);
		mv.addObject("pager",pager);
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
	public ModelAndView setBankBookAdd(BankbookDTO bankbookDTO ,MultipartFile pic ,HttpSession httpSession) throws Exception {
		ModelAndView mv = new ModelAndView();
		System.out.println( );
		
	//int result=	bankbookService.setBankBookAdd(bankbookDTO);
		
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
