package com.teambravo.impos.purchase.service;

import java.util.ArrayList;
import java.util.List;

import com.teambravo.impos.product.domain.Product;
import com.teambravo.impos.purchase.dao.PurchaseDao;
import com.teambravo.impos.purchase.domain.Cart;

public class PurchaseService {
	
	//db랑 연결할 dao 객체 지정
	private PurchaseDao purchaseDao = new PurchaseDao();
	
	//상품 product를 담을 cart 리스트 지정
	private Cart cart;

	private double money;
	private double salesMoney;
	
	//장바구니에 물건을 담은 후, 결제 시 호출 매소드
	public void purchaseProduct() {
		if(salesMoney <= money) {				
				money = money - salesMoney;
				purchaseDao.purchaseProductDeleteStock(cart);
				purchaseDao.purchaseProductInsertSales(cart);
			}else {
				System.out.println("너 돈이 없엉 ><.");
			}	
		}
	
	
	//jsp 파일내에 물건을 취소후, 혹은 물건 구매 완료후, '잔금 반환'
	// 버튼을 클릭시 getBalance 매소드 호출
	public double getBalance() {
		return money;		
	}
	
	//jsp 파일내에 결제하기 버튼을 누르면 금액을 입력
	public void insertMoney(double amount) {
		money += amount;
	}
}
