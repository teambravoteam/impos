package com.teambravo.impos.purchase.service;

import com.teambravo.impos.purchase.dao.PurchaseDao;
import com.teambravo.impos.purchase.domain.Cart;

public class PurchaseService {
	
	//db랑 연결할 dao 객체 지정
	private PurchaseDao purchaseDao;
	//상품 product를 담을 cart 객체 지정
	private Cart cart;
	
	
	//구매 서비스 시작, dao 연결, cart 객체 호출
	public void startPurchase() {
		// 보통 jsp 내에서 구매하기 버튼 클릭 -> startPurchase 매소드 호출
		// 호출시 dao 연결, cart 생성
		purchaseDao = new PurchaseDao();
		cart = new Cart();
	}	
	
	//장바구니에 물건을 담은 후, 결제 시 호출 매소드
	public void purchaseProduct() {
		
		
	}
	
	//jsp 파일내에 물건을 취소후, 혹은 물건 구매 완료후, '잔금 반환'
	// 버튼을 클릭시 getBalance 매소드 호출
	public void getBalance() {
		
		
	}

	//jsp 파일내에서 장바구니에 구입을 취소할 경우
	// 해당 파일내에 '구매 취소 하기' 버튼을 누를시 canclePurchase() 매소드 호출
 	public void canclePurchase() {
		
			
	}
	
	// jsp 파일내에서 해당 물건을 클릭 -> 장바구니에 넣기 버튼을 클릭시 -> 
 	// addProductFromCart() 매소드를 호출
	public void addProductFromCart() {
		
		
	}	
	// jsp 파일내에서 장바구니 안에 있는 Product 옆, 'x' 혹은 '물품삭제' 버튼을
	// 클릭 시, 해당 removeProductFromCart() 매소드 호출 
	public void removeProductFromCart() {
		
		
	}

}
