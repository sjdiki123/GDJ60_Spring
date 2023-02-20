package com.iu.s1.bankbook;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class BankbookDAO {

	
	@Autowired
	private SqlSession sqlSession;
	private final String NAMESPACE = "com.iu.s1.bankbook.BankbookDAO.";
	
	
	public List<BankbookDTO> getBankBookList() throws Exception {
		return sqlSession.selectList(NAMESPACE+"getBankBook");
	}
	
	
	public  BankbookDTO getBankBookDetail( BankbookDTO bankbookDTO) throws Exception {
		 return sqlSession.selectOne(NAMESPACE+"getBankBookDetail");
	}
	
	public  int setBankBookAdd(BankbookDTO bankbookDTO) throws Exception{
		return sqlSession.insert(NAMESPACE +"setBankBookAdd",bankbookDTO);
	}
	public int setBankBookUpdate(BankbookDTO bankbookDTO)throws Exception{
		return sqlSession.update(NAMESPACE +"setBankBookUpdate", bankbookDTO);
	}
	
		public int setBankBookDetail(BankbookDTO bankbookDTO)throws Exception{
			return sqlSession.delete(NAMESPACE +" setBankBookDetail", bankbookDTO);
		
	}
		
		
}
