package com.iu.s1member;

import java.sql.Connection;
import java.sql.PreparedStatement;

import com.iu.s1.util.DBConnection;

public class MemberDAO {

	
	
	
	
	
	
	
//setaddMenber	
	
	public int setaddMember(MemberDTO memberDTO ) throws Exception{
		Connection con = DBConnection.getConnection();
		
		String sql = "INSERT INTO MEMBER(ID,PW,ADDRESS,NAME,PHONE,EMAIL)"
				+ " VALUES(?,?,?,?,?,?)";
		
		PreparedStatement st = con.prepareStatement(sql);
		
		st.setString(1, memberDTO.getId());
		st.setString(2, memberDTO.getPw());
		st.setString(3, memberDTO.getAddress());
		st.setString(4, memberDTO.getMembername());
		st.setString(5, memberDTO.getMemberphone());
		st.setString(6, memberDTO.getEmail());
		
		
		int result = st.executeUpdate();

		
		
		DBConnection.disConnection(null, st, con);
		return result;
	}
	
private static void mian(String[] args) {

	
	MemberDAO memberDAO = new MemberDAO();
	MemberDTO memberDTO = new MemberDTO();
	memberDTO.setId("id");
	memberDTO.setPw("pw");
	memberDTO.setMembername("name");
	memberDTO.setMemberphone("phone");
	memberDTO.setAddress("address");
	memberDTO.setEmail("eamil");
	try {
		int result = memberDAO.setaddMember(memberDTO);
		System.out.println(result == 1);
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	

}
	
	
}
