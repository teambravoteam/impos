package com.teambravo.impos.stock.domain;

public class SelectStock {
	// select결과를 담을 용으로 만든 클래스
	// sid, category, procode, proName, proprice, stock

	private int sid;
	private String category;
	private String code;
	private String name;
	private double price;
	private int stock;

	public int getSid() {
		return sid;
	}

	public void setSid(int sid) {
		this.sid = sid;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public int getStock() {
		return stock;
	}

	public void setStock(int stock) {
		this.stock = stock;
	}

	@Override
	public String toString() {
		return sid + "," + category + "," + code + "," + name + "," + price + "," + stock;
	}
}
