package com.teambravo.impos.product.domain;

import java.util.List;

//- 상품코드 - proCode - VARCHAR
//- 상품명 - proName - VARCHAR
//- 가격 - proPrice - DOUBLE
//- 카테고리 - proCategory - VARCHAR

//-. 상품 조회
//-. 상품 등록

public class Product {
	protected String proCode;//상품코드
	protected String proName;//상품명
	protected double proPrice;//가격
	protected String proCategory;//카테고리
	
	public Product() {
		
	}

	public String getProCode() {
		return proCode;
	}

	public void setProCode(String proCode) {
		this.proCode = proCode;
	}

	public String getProName() {
		return proName;
	}

	public void setProName(String proName) {
		this.proName = proName;
	}

	public double getProPrice() {
		return proPrice;
	}

	public void setProPrice(double proPrice) {
		this.proPrice = proPrice;
	}

	public String getProCategory() {
		return proCategory;
	}

	public void setProCategory(String proCategory) {
		this.proCategory = proCategory;
	}
	
	//상품등록
	public void addProduct() {
		
	}
	
	//상품조회
	public List<Product> findAllProduct() {
		return null;
	}
	
}
