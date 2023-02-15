package com.iu.s1member;

import org.springframework.beans.factory.annotation.Autowired;

public class Memberservice {



	@Autowired
	private MemberDAO memberDAO;
	
	
	public int setMemberAdd(MemberDTO memberDTO)throws Exception{
		int result = memberDAO.setaddMember(memberDTO);
		result = memberDAO.setaddMember(memberDTO);
		return result;
	}
	
	//public MemberDTO getMemberLogin(MemberDTO memberDTO)throws Exception{
	//
	
	
	
	
	
	public int setMemberUpdate(MemberDTO memberDTO)throws Exception{
		return memberDAO.setaddMember(memberDTO);
	}

}








