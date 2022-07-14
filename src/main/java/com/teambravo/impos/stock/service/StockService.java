package com.teambravo.impos.stock.service;

import java.util.ArrayList;
import java.util.List;

import com.teambravo.impos.stock.dao.StockDao;
import com.teambravo.impos.stock.domain.Stock;

public class StockService {
	
	private StockDao stockDao;
	
	// 상품등록 시 재고목록에도 추가
	public void addStockTable(Stock stock) {
		String category = stock.getScategory();
		// 카테고리가 커피가 아니라면 재고목록에 추가
		if (!category.equals("coffee")) {
			stockDao = new StockDao();
			stockDao.addStockTable(stock);
		}
	}
	
	// 재고 수정
	public void editStock(String category, String code, int stock) {
		stockDao = new StockDao();
		stockDao.editStock(category, code, stock);
	}
	
	// 결제 완료 시 재고 차감
	public void minusStock(String category, String code, int count) {
		stockDao = new StockDao();
		int findStock = findStockByCode(category, code).getStock();//현재 재고수량
		
		findStock -= count; // 현재재고 - 결제수량
		 
		stockDao.editStock(category, code, findStock);
	}
	
	// 카테고리별 재고항목 조회
	public List<Stock> findAllStock(String stockCategory) {
		stockDao = new StockDao();
		return stockDao.findAllStock(stockCategory);
	}
	
	// 재고항목 전체 조회
	public List<Stock> allStockList() {
		// 각 카테고리별 리스트 뽑아서 하나의 리스트에 합침
		List<Stock> cakeList = findAllStock("cake");
		List<Stock> cookieList = findAllStock("cookie");
		
		List<Stock> allStockList = new ArrayList<Stock>();
		allStockList.addAll(cakeList);
		allStockList.addAll(cookieList);
		
		return allStockList;
	}
	
	
	// 상품 코드로 재고 조회
	public Stock findStockByCode(String category, String code) {
		stockDao = new StockDao();
		return stockDao.findStockByCode(category, code);
	}
	
	// 상품 이름으로 재고 조회
	public Stock findStockByName(String category, String name) {
		stockDao = new StockDao();
		return stockDao.findStockByName(category, name);
	}
}
