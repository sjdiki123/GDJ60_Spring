package com.iu.s1.bankbook;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.iu.s1.MyTestCase;

public class BankbookDAOtest extends MyTestCase {

	@Autowired
	 private BankbookDAO bankbookDAO;
	
	
	public void getBankBookListTest()throws Exception{
		List<BankbookDTO> ar = bankbookDAO.getBankBookList();
		
	}
	
	
	
}
