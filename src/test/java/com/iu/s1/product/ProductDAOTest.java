package com.iu.s1.product;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.iu.s1.MyTestCase;

public class ProductDAOTest extends MyTestCase{

	@Autowired
	private ProductDAO productDAO;
	
	public void getProductListTest() throws Exception {
		List<ProductDTO> ar = productDAO.getProductList();
		// 단정문 
		
	
	}
	
	public void getProductDetailTest() throws Exception{
		ProductDTO productDTO= new ProductDTO();
		productDTO.setProductnum(20000l)
		;
	}
	
	
	@Test
	public void setproductAddTest() throws Exception{
		ProductDTO productDTO = new ProductDTO();
		productDTO.setProductname(null);
	}
	
}
