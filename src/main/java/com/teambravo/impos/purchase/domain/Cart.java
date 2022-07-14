package com.teambravo.impos.purchase.domain;

import java.util.ArrayList;
import java.util.List;

import com.teambravo.impos.product.domain.Product;

public class Cart {
	private List<List> cartList = new ArrayList<List>();	
	
	public List<List> getCartList() {
		return cartList;
	}
	
	public void createItemList() {
		//List<Product> itemList = productService.findMenuList();
		
	}
	
	
	public void addItem(Product p) {
		
	}
	
	public void removeItem(Product p) {
		
	}
	
	public void purchaseItem() {
		
	}
	
}
