package com.iu.s1.product;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.iu.s1.util.DBConnection;

@Repository
public class ProductDAO {
	@Autowired
	private SqlSession sqlSession;
	private final String NAMESPACE = "com.iu.s1.product.ProductDAO.";
	
//	@Autowired
	//private DataSource dataSource;
	
	
	
	public int setProducDelete(Long prodctNum)throws Exception{
	
		
		//1. db 연결 2.sql 생성 3.미린 보내기 4.? 세팅 5.최종전송밑 결과 초리 6 연결해제
	
		
		return sqlSession.delete(NAMESPACE+"setProducDelete", prodctNum);
	}
	
	
	public ProductDTO getProductDetail(ProductDTO productDTO) throws Exception{
		
		
		
		return  sqlSession.selectOne(NAMESPACE+ "getProductDetail",productDTO);
	}
	
	//getMax
	public Long getProductNum() throws Exception{
		Connection con = DBConnection.getConnection();
		
		String sql = "SELECT PRODUCT_SEQ.NEXTVAL FROM DUAL";
		
		PreparedStatement st = con.prepareStatement(sql);
		
		ResultSet rs = st.executeQuery();
		
		rs.next();
		
		Long num = rs.getLong(1);
		
		DBConnection.disConnection(rs, st, con);
		
		return num;
	}
	
	
	//-------------------------------------------------------------------------------------------
	public List<ProductOptionDTO> getProductOptionList() throws Exception {
		List<ProductOptionDTO> ar = new ArrayList<ProductOptionDTO>();
		
		Connection con = DBConnection.getConnection();
		
		String sql = "SELECT * FROM PRODUCTOPTION";
		
		PreparedStatement st = con.prepareStatement(sql);
		
		ResultSet rs = st.executeQuery();
		
		while(rs.next()) {
			ProductOptionDTO productOptionDTO = new ProductOptionDTO();
			productOptionDTO.setOptionnum(rs.getLong("OPTIONNUM"));
			productOptionDTO.setProductnum(rs.getLong("PRODUCTNUM"));
			productOptionDTO.setOptionname(rs.getString("OPTIONNAME"));
			productOptionDTO.setOptionprice(rs.getLong("OPTIONPRICE"));
			productOptionDTO.setOptionamount(rs.getLong("OPTIONAMOUNT"));
			ar.add(productOptionDTO);
		}
		
		DBConnection.disConnection(rs, st, con);
		
		return ar;
		
	}

		public int setAddProductOption(ProductOptionDTO productOptionDTO) throws Exception {
			Connection con = DBConnection.getConnection();
			
			String sql = "INSERT INTO PRODUCTOPTION(OPTIONNUM, PRODUCTNUM, OPTIONNAME, OPTIONPRICE, OPTIONAMOUNT)"
					+ "VALUES(PRODUCT_SEQ.NEXTVAL, ?, ?, ?, ?)";
			
			PreparedStatement st = con.prepareStatement(sql);
			
			st.setLong(1, productOptionDTO.getProductnum());
			st.setString(2,productOptionDTO.getOptionname());
			st.setLong(3, productOptionDTO.getOptionprice());
			st.setLong(4, productOptionDTO.getOptionamount());
			
			int result = st.executeUpdate();
			
			//////
			DBConnection.disConnection(st, con);
			
			return result;

	}
	//-------------------------------------------------------------------------------------------
	
//	public List<ProductDTO> getProductList() throws Exception{
		ArrayList<ProductDTO> ar = new ArrayList<ProductDTO>();
		
		
		
//	}
	
	public int setAddProduct(ProductDTO productDTO) throws Exception{
		
		
		return sqlSession.insert(NAMESPACE+"setAddProduct" , productDTO);
	}
	
}