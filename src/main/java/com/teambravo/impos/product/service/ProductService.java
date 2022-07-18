package com.teambravo.impos.product.service;

import java.util.ArrayList;
import java.util.List;

import com.teambravo.impos.product.dao.ProductDao;
import com.teambravo.impos.product.domain.Product;
import com.teambravo.impos.stock.service.StockService;

public class ProductService {
	private ProductDao productDao = new ProductDao();
	
	private StockService stockService = new StockService();
	
	// 상품등록
	public void addProductTable(String proName, double proPrice, String proCategory, String fileName) {
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
		product.setProImage(fileName);
		
		productDao.addProduct(product);
		
		//상품등록 시 재고테이블에도 추가하기 (커피가 아닐경우만)
		if (!proCategory.equals("coffee")) {
			stockService.addStockTable(proCategory, proCode);
		}
	}
	
	// 상품수정
	public void updateProduct(Product product) {
		productDao.updateProduct(product);
	}
	
	// 상품삭제
	public void deleteProduct(Product product) {
		productDao.deleteProduct(product);
		
		//String cateogry = product.getProCategory();
		//String code = product.getProCode();
		//stockService.deleteStockTable(cateogry, code);
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