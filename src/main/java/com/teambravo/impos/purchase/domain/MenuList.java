package com.teambravo.impos.purchase.domain;

import com.teambravo.impos.product.domain.Product;
import com.teambravo.impos.stock.domain.Stock;
import com.teambravo.impos.stock.service.StockService;

public class MenuList {
	
	private Product product;
	private int count;
			
	public MenuList(Product product, int count1) {
		this.product = product;
		count = count1;
	}

	public Product getProduct() {
		return product;
	}

	public int getCount() {
		return count;
	}	

}
