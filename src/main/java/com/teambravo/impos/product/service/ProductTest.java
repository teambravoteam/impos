package com.teambravo.impos.product.service;

import java.util.List;

import com.teambravo.impos.product.dao.ProductDao;
import com.teambravo.impos.product.domain.Product;

public class ProductTest {

	public static void main(String[] args) {
		ProductDao dao = new ProductDao();
		Product pr = new Product();
		pr.setProCategory("1");
		pr.setProCode("1234");
		pr.setProName("123");
		pr.setProPrice(1500);
		
		dao.addProduct(pr);
	}
}

/*
ProductTest 되는지 확인 해봐야하니까
Dao불러줄 Service만들기
Service를 통해야하는 Servlet만들기
Servlet을 통해 페이지를 띄우는 jsp파일 만들기 
*/
