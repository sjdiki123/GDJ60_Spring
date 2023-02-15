package com.iu.s1.bankbook;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.iu.s1.util.Pager;

@Service
public class BankbookService {

	@Autowired
	private BankbookDAO bankbookDAO ;
	
	
	public List<BankbookDTO> getBankBookList(Pager pager) throws Exception {
		long perPage=5;
		long page = 2;
		long s =(page-1) *perPage+1;
		long l=page *perPage;
		pager.setStartRow(s);
		pager.setLastRow(l);
		
		return bankbookDAO.getBankBookList(pager);
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
