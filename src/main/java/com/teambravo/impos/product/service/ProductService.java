package com.teambravo.impos.product.service;

import java.util.ArrayList;
import java.util.List;

import com.teambravo.impos.product.dao.ProductDao;
import com.teambravo.impos.product.domain.Product;

public class ProductService {
	private ProductDao productDao = new ProductDao();

	// 상품등록
	/*public void addProduct(Product product) {
		productDao.addProduct(product);
		
	}*/
	
	public void addProductTable(String proName, double proPrice, String proCategory) {
		String proCode = null;
		
		while(true) {
			proCode = generateCode();
			if (checkOverlapCode(proCode) == false) {
				continue;
			} else {
				break;
			}
		}
		
		Product product = new Product();
		product.setProName(proName);
		product.setProPrice(proPrice);
		product.setProCategory(proCategory);
		product.setProCode(proCode);
		
		productDao.addProduct(product);
	}

	// 상품삭제
	public void deleteProduct(Product product) {
		productDao.deleteProduct(product);
	}

	// 카테고리별 상품 조회
	public List<Product> findProduct(String category) {
		return productDao.findProduct(category);
	}

	// 전체 상품 조회
	public List<Product> findAllProduct() {
		List<Product> allProductList = new ArrayList<Product>();
		List<Product> coffeeList = findProduct("coffee");
		List<Product> cookieList = findProduct("cookie");
		List<Product> cakeList = findProduct("cake");

		allProductList.addAll(coffeeList);
		allProductList.addAll(cookieList);
		allProductList.addAll(cakeList);

		return allProductList;
	}

	// 이름과 카테고리로 조회
	public Product findProductByNameAndCategory(String name, String category) {
		return productDao.findProductByNameAndCategory(name, category);
	}

	// 코드로 상품 조회
	public Product findProductByCode(String category, String code) {
		return productDao.findProductByCode(category, code);
	}

	
	// 바코드생성메서드
	public String generateCode() {
		String codeNum = "";

		for (int i = 0; i < 3; i++) {
			codeNum += (int) (Math.random() * 10);
		}
		codeNum += "-";
		for (int i = 0; i < 2; i++) {
			codeNum += (int) (Math.random() * 10);
		}
		codeNum += "-";
		for (int i = 0; i < 4; i++) {
			codeNum += (int) (Math.random() * 10);
		}

		return codeNum;
	}
	

	// 바코드 중복확인
	public boolean checkOverlapCode(String codeNum) {

		boolean result = true;
		
		Product coffeeResult = findProductByCode("coffee", codeNum);
		Product cakeResult = findProductByCode("cake", codeNum);
		Product cookieResult = findProductByCode("cookie", codeNum);
		
		if (coffeeResult != null) {
			result = false;
		}
		if (cakeResult != null) {
			result = false;
		}
		if (cookieResult != null) {
			result = false;
		}
		
		return result;
	}
}
