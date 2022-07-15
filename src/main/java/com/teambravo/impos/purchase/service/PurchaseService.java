package com.teambravo.impos.purchase.service;

import java.util.ArrayList;
import java.util.List;

import com.teambravo.impos.product.domain.Product;
import com.teambravo.impos.purchase.dao.PurchaseDao;
import com.teambravo.impos.purchase.domain.Cart;
import com.teambravo.impos.purchase.domain.MenuList;

public class PurchaseService {
	private PurchaseDao purchaseDao = new PurchaseDao();
	private Cart cart;
	private double money;
	private double salesMoney;
	
	public double getBalance() {
		return money;		
	}
//	public void insertMoney(double amount) {
//		amount = 100000000;
//		money += amount;
//	}
		
	public List<Product> getCoffeeList(){
		return null;
		//productDao.findCoffeeList();
	}
	public List<Product> getCakeList(){
		return null;
	}
	public List<Product> getCookieList(){
		return null;
	}

	public void PurchaseItem(Cart cart) {
		System.out.println("안에들어옴");
		System.out.println(money);
		for(MenuList menuList : cart.getCartList()) {
			double listMoney = menuList.getProduct().getProPrice() * menuList.getCount();
			salesMoney += listMoney;
		}	
		
		if(money >= salesMoney) {
			System.out.println("돈이 들어옴");
			money = money - salesMoney;
			System.out.println(money + "계산한돈");
			purchaseDao.purchaseProductInsertSales(cart);
			for(MenuList menuList : cart.getCartList()) {
				if(menuList.getProduct().getProCategory() == "coffee") {
					purchaseDao.purchaseProductDeleteCoffeeMaterial(menuList);
				}
				if(menuList.getProduct().getProCategory() == "cake") {
					purchaseDao.purchaseProductDeleteCakeStock(menuList);
				}
				if(menuList.getProduct().getProCategory() == "cookie") {
					purchaseDao.purchaseProductDeleteCookieStock(menuList);
				}
			}
		} else {
			System.out.println("돈 없");
		}
		
	}
	public void insertMoney(double a) {
		money += a;		
	}
	
}
