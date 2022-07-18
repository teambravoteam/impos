package com.teambravo.impos.stock.service;

import java.util.ArrayList;
import java.util.List;

import com.teambravo.impos.stock.dao.StockDao;
import com.teambravo.impos.stock.domain.SelectStock;
import com.teambravo.impos.stock.domain.Stock;

public class StockService {
	
	private StockDao stockDao;
	
	
	public void addStockTable(String category, String code) {
		if (!category.equals("coffee")) {
			stockDao = new StockDao();
			stockDao.addStockTable(category, code);
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
	public List<SelectStock> findAllStock(String stockCategory) {
		stockDao = new StockDao();
		return stockDao.findAllStock(stockCategory);
	}
	
	// 재고항목 전체 조회
	public List<SelectStock> allStockList() {
		// 각 카테고리별 리스트 뽑아서 하나의 리스트에 합침
		List<SelectStock> cakeList = findAllStock("cake");
		List<SelectStock> cookieList = findAllStock("cookie");
		
		List<SelectStock> allStockList = new ArrayList<SelectStock>();
		allStockList.addAll(cakeList);
		allStockList.addAll(cookieList);
		
		return allStockList;
	}
	
	
	// 상품 코드로 재고 조회
	public SelectStock findStockByCode(String category, String code) {
		stockDao = new StockDao();
		return stockDao.findStockByCode(category, code);
	}
	
	// 상품 이름으로 재고 조회
	public SelectStock findStockByName(String category, String name) {
		stockDao = new StockDao();
		return stockDao.findStockByName(category, name);
	}
	
	// 상품삭제 시 재고테이블에서도 삭제하기
	public void deleteStockTable(String category, String code) {
		stockDao.deleteStockTable(category, code);
	}
}
