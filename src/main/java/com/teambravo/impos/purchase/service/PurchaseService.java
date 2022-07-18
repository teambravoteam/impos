package com.teambravo.impos.purchase.service;

import java.util.ArrayList;
import java.util.List;

import com.teambravo.impos.material.service.MaterialService;
import com.teambravo.impos.product.domain.Product;
import com.teambravo.impos.purchase.dao.PurchaseDao;
import com.teambravo.impos.purchase.domain.Cart;
import com.teambravo.impos.purchase.domain.MenuList;
import com.teambravo.impos.stock.dao.StockDao;
import com.teambravo.impos.stock.service.StockService;

public class PurchaseService {
	private PurchaseDao purchaseDao = new PurchaseDao();
//	private Cart cart;
	private static double money;
	private static double salesMoney;
	private MaterialService materialService = new MaterialService();
	private StockService stockService = new StockService();
	
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
		
		System.out.println(cart.getCartList());

		
		  
		if(money >= salesMoney) {
			System.out.println("돈이 들어옴");
			money = money - salesMoney;
			System.out.println(money + "계산한돈");
			purchaseDao.purchaseProductInsertSales(cart);
			
			for(int i = 0; i<cart.getCartList().size(); i++) {		
				MenuList menuList = cart.getCartList().get(i);
				if(menuList.getProduct().getProCategory().equals("coffee")) {
					for(int j = 0; j<menuList.getCount(); j++) {
						materialService.saleSubtractVolume(menuList.getProduct().getProName());
					}
				}
				
				if(menuList.getProduct().getProCategory().equals("cake")) {
					for(int j = 0; j<menuList.getCount(); j++) {
						stockService.minusStock(menuList.getProduct().getProCategory(), menuList.getProduct().getProCode(), 1 );
					}
				}
				
				if(menuList.getProduct().getProCategory().equals("cookie")) {
					for(int j = 0; j<menuList.getCount(); j++) {
						stockService.minusStock(menuList.getProduct().getProCategory(), menuList.getProduct().getProCode(), 1 );
					}
				}
			}
			
			
//			for(MenuList menuList : cart.getCartList()) {
//				if(menuList.getProduct().getProCategory() == "coffee") {
//					//purchaseDao.purchaseProductDeleteCoffeeMaterial(menuList);
//					for(int i=0; i<menuList.getCount(); i++) {
//						materialService.saleSubtractVolume(menuList.getProduct().getProName());
//					}
//				}  
//				if(menuList.getProduct().getProCategory() == "cake") {
//					//purchaseDao.purchaseProductDeleteCakeStock(menuList);
//					for(int i=0; i<menuList.getCount(); i++) {
//						stockService.minusStock(menuList.getProduct().getProCategory(), menuList.getProduct().getProCode(), 1 );
//					}
//				}
//				if(menuList.getProduct().getProCategory() == "cookie") {
//					//purchaseDao.purchaseProductDeleteCookieStock(menuList);
//					for(int i=0; i<menuList.getCount(); i++) {
//						stockService.minusStock(menuList.getProduct().getProCategory(), menuList.getProduct().getProCode(), 1 );
//					}
//				}
//			}
		} else {
			System.out.println("돈 없");
		}		
	}
	
	
	public boolean calMoney(Cart cart) {
		for(MenuList menuList : cart.getCartList()) {
			System.out.println(menuList.getCount() + " ++ " + menuList.getProduct().getProName());
			double listMoney = menuList.getProduct().getProPrice() * menuList.getCount();
			salesMoney += listMoney;
		}	
		if( this.money - salesMoney > 0) {
			return true;
		}else {
			return false;
		}
	}
	
	public void insertMoney(double a) {
		money += a;		
	}

	public void setMoney(double i) {
		money = i;		
	}
	public void setSalesMoney(double i) {
		salesMoney = i;		
	}
	
	
}
