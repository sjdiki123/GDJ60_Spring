package com.iu.s1.bankbook;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BankbookService {

	@Autowired
	private BankbookDAO bankbookDAO ;
	
	
	public List<BankbookDTO> getBankBookList() throws Exception {
		return bankbookDAO.getBankBookList();
	}
	
	
	public  BankbookDTO getBankBookDetail( BankbookDTO bankbookDTO) throws Exception {
		 return bankbookDAO.getBankBookDetail(bankbookDTO);
	}
	
	public  int setBankBookAdd(BankbookDTO bankbookDTO) throws Exception{
		return bankbookDAO.setBankBookAdd(bankbookDTO);
	}
	public int setBankBookUpdate(BankbookDTO bankbookDTO)throws Exception{
		return bankbookDAO.setBankBookUpdate(bankbookDTO);
	}
	
		public int setBankBookDetail(BankbookDTO bankbookDTO)throws Exception{
			return bankbookDAO.setBankBookDetail(bankbookDTO);
		
	}
		
	
	
}
