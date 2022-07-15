package com.teambravo.impos.stock.domain;

public class Stock {
	// code, name, price, category, stock, (stockTime)
	// protected Product product;
	// 상품등록할때 동시에 재고테이블에도 등록되어야한다.
	
	
	private String scode;
	private String scategory;
	private int stock;
	
	public String getScode() {
		return scode;
	}
	public String getScategory() {
		return scategory;
	}
	public void setScategory(String scategory) {
		this.scategory = scategory;
	}
	public void setScode(String scode) {
		this.scode = scode;
	}
	
	public int getStock() {
		return stock;
	}
	public void setStock(int stock) {
		this.stock = stock;
	}
	
	@Override
	public String toString() {
		return "scode=" + scode + ", scategory=" + scategory + ", stock=" + stock;
	}
}
