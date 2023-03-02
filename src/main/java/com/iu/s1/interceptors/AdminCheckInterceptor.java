package com.iu.s1.interceptors;

import java.util.concurrent.LinkedTransferQueue;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.iu.s1.member.MemberDTO;

public class AdminCheckInterceptor  extends HandlerInterceptorAdapter{

	
	//Role 이 Admin이면 통과 
	
@Override
public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
		throws Exception {

	MemberDTO memberDTO =(MemberDTO)request.getSession().getAttribute("member");
	
	if(memberDTO !=null) {
	if(memberDTO.getRoleDTO().getRoleName().equals("ADMIN"));	{
		
		return true;           
	}
		
	}
	
	// 로그인 x Admin 이 아닌 경우 
	request.setAttribute("result", "권한이 없다");
	request.setAttribute("url", "../../../../");
	
	RequestDispatcher viwe = request.getRequestDispatcher("WEB-IN/virws/commmon/reult.jsp");
   viwe.forward(request, response);
	return false;
}
	
}
