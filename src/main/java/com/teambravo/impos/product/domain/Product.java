package com.teambravo.impos.product.domain;

//상품코드 - proCode - VARCHAR
//상품명 - proName - VARCHAR
//가격 - proPrice - DOUBLE
//카테고리 - proCategory - VARCHAR
//카테고리에는 Coffee, Cookie, Cake

//기능
//-. 상품 조회
//-. 상품 등록
//-. 상품 수정/삭제

public class Product {
	protected String proCode;//상품코드
	protected String proName;//상품명
	protected double proPrice;//가격
	protected String proCategory;//카테고리
	protected String proImage;//이미지 이름
	
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

	public String getProImage() {
		return proImage;
	}

	public void setProImage(String proImage) {
		this.proImage = proImage;
	}

	@Override
	public String toString() {
		return proCategory + "," + proCode + "," + proName + "," + proPrice + "," + proImage;
	} 
	
	
}
