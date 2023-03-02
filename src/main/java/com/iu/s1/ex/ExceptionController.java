package com.iu.s1.ex;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

@ControllerAdvice
public class ExceptionController {
//에외를 전문 =처리하는 contr0ller
	//프로젝트 내에서 발생하는 ex은전부 여기서 철; 
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
