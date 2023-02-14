package com.iu.s1member;

import java.util.List;

public class MemberDTO {

	private String id;
	private String pw;
	private String address;
	private String membername;
	public List<RoleDTO> getRoleDTOs() {
		return roleDTOs;
	}
	public void setRoleDTOs(List<RoleDTO> roleDTOs) {
		this.roleDTOs = roleDTOs;
	}
	private String email;
	private String memberphone;
	private List<RoleDTO> roleDTOs;

	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getPw() {
		return pw;
	}
	public void setPw(String pw) {
		this.pw = pw;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getName() {
		return membername;
	}
	public void setName(String name) {
		this.membername = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPhone() {
		return memberphone;
	}
	public void setPhone(String phone) {
		this.memberphone = phone;
	}
	

	
	
	
	
}
