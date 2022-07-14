package com.teambravo.impos.stock.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.teambravo.impos.init.domain.DataSource;
import com.teambravo.impos.init.service.NamingService;
import com.teambravo.impos.stock.domain.Stock;


public class StockDao {
	NamingService namingService = NamingService.getInstance();
	DataSource ds = (DataSource) namingService.getAttribute("dataSource");
	
	// 상품 등록시 재고테이블에 항목 추가
	public void addStockTable(Stock stock) {
		// 입력받은 카테고리에 따라 다른 테이블에 값 저장
		String sql = null;
		String stockCategory = stock.getScategory();
		
		//상품등록시 재고의 수는 default값인 0이 입력된다.
		//productService안에 있는 코드번호 생성기
		//product에서 새로운 상품을 추가할 때 stockService 객체를 생성해서 add하기
		//커피카테고리는 재고테이블을 생성하지 않고 material이랑만 관련이 있음
		if (stockCategory.equals("cake")) {
			sql = "INSERT INTO CakeStock(scode, scategory) "
					+ "VALUES(?, ?)";	 
		} else if (stockCategory.equals("cookie")) {
			sql = "INSERT INTO CookieStock(scode, scategory) "
					+ "VALUES(?, ?)";	 
		}
		
		try {
			Connection con = null;
			PreparedStatement pstmt = null;
			try {
				con = ds.getConnection();
				pstmt = con.prepareStatement(sql);
				
				pstmt.setString(1, stock.getScode());
				pstmt.setString(2, stock.getScategory());
				pstmt.setInt(3, stock.getStock());
				pstmt.executeUpdate();
				
				System.out.println("INSERT COMPLETE!");
			} finally {
				ds.close(pstmt, con);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	// 상품 삭제 시 재고테이블에서도 삭제
	public void deleteStockTable(Stock stock) {
		// 카테고리 값을 받아와서 if문으로 해당 테이블에서 값 삭제하기
		String sql = null;
		String stockCategory = stock.getScategory();
		
		if (stockCategory.equals("cake")) {
			sql = "DELETE FROM CakeStock WHERE scode = ?";	 
		} else if (stockCategory.equals("cookie")) {
			sql = "DELETE FROM CookieStock WHERE scode = ?";	 
		}
		
		try {
			Connection con = null;
			PreparedStatement pstmt = null;
			try {
				con = ds.getConnection();
				pstmt = con.prepareStatement(sql);
				
				pstmt.setString(1, stock.getScode());
				pstmt.executeUpdate();
				
				System.out.println("DELETE COMPELTE!");
				
			} finally {
				ds.close(pstmt, con);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	// 재고항목 전체 조회
	// 카테고리정보 받아서 해당 카테고리에 맞는거 리스트에 담고 이 리스트 하나에 다 담아야함
	// 함수 하나 만들어서 함수안에 리스트하나 만든다. 
	public List<Stock> findAllStock(String stockCategory) {
		List<Stock> stockList = new ArrayList<Stock>();
		String sql = null;
		
		System.out.println("Dao:" + stockCategory);
		
		// product테이블이랑 join해야함
		if (stockCategory.equals("cake")) {
			System.out.println(stockCategory.equals("cake"));
			sql = "SELECT * FROM CakeStock";	 
		} else if (stockCategory.equals("cookie")) {
			sql = "SELECT * FROM CookieStock";	 
		} else {
			System.out.println("테이블이 없습니다.");
		}
		
		try {
			Connection con = null;
			PreparedStatement pstmt = null;
			ResultSet rs = null;
			try {
				con = ds.getConnection();
				pstmt = con.prepareStatement(sql);
				rs = pstmt.executeQuery();
				
				while(rs.next()) {
					Stock s = new Stock();
					//join결과로 뽑을 컬럼명이랑 맞춰야함
					s.setScode(rs.getString("scode"));
					s.setScategory(rs.getString("scategory"));
					s.setStock(rs.getInt("stock"));
					
					//s.setScode(rs.getString("sname"));
					//s.setScode(rs.getString("sprice"));
					stockList.add(s);
				}
			} finally {
				ds.close(rs, pstmt, con);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return stockList;
	}
	
	
	// 상품 코드로 재고 조회
	public Stock findStockByCode(String category, String scode) {
		
		String sql = null;
		
		//product테이블이랑 join해야한다.
		if (category.equals("cake")) {
			sql = "SELECT * FROM CakeStock WHERE scode = ?";	 
		} else if (category.equals("cookie")) {
			sql = "SELECT * FROM CookieStock WHERE scode = ?";	 
		}
		Stock s = null;
		try {
			Connection con = null;
			PreparedStatement pstmt = null;
			ResultSet rs = null;
			try {
				con = ds.getConnection();
				pstmt = con.prepareStatement(sql);
				pstmt.setString(1, scode);
				rs = pstmt.executeQuery();
				while(rs.next()) {
					s = new Stock();
					
					//join결과로 뽑을 컬럼명이랑 맞춰야함
					s.setScode(rs.getString("scode"));
					s.setScategory(rs.getString("scategory"));
					s.setStock(rs.getInt("stock"));
					
					//s.setScode(rs.getString("sname"));
					//s.setScode(rs.getString("sprice"));
				}
			} finally {
				ds.close(rs, pstmt, con);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return s;
	}
	
	// 상품 이름로 재고 조회
		public Stock findStockByName(String category, String sname) {
			
			String sql = null;
			
			//product테이블이랑 join해야한다.
			if (category.equals("cake")) {
				sql = "SELECT * FROM CakeStock WHERE sname = ?";	 
			} else if (category.equals("cookie")) {
				sql = "SELECT * FROM CookieStock WHERE sname = ?";	 
			}
			Stock s = null;
			try {
				Connection con = null;
				PreparedStatement pstmt = null;
				ResultSet rs = null;
				try {
					con = ds.getConnection();
					pstmt = con.prepareStatement(sql);
					pstmt.setString(1, sname);
					rs = pstmt.executeQuery();
					while(rs.next()) {
						s = new Stock();
						
						//join결과로 뽑을 컬럼명이랑 맞춰야함
						s.setScode(rs.getString("scode"));
						s.setScategory(rs.getString("scategory"));
						s.setStock(rs.getInt("stock"));
						
						//s.setScode(rs.getString("sname"));
						//s.setScode(rs.getString("sprice"));
					}
				} finally {
					ds.close(rs, pstmt, con);
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
			return s;
		}
		
	// 재고 수정
	public void editStock(String category, String code, int stock) {
		String sql = null;
		if (category.equals("cake")) {
			sql = "UPDATE CakeStock SET stock = ? WHERE sCode = ?";	 
		} else if (category.equals("cookie")) {
			sql = "UPDATE CookieStock SET stock = ? WHERE sCode = ?";	 
		}
		
		try {
			Connection con = null;
			PreparedStatement pstmt = null;
			try {
				con = ds.getConnection();
				pstmt = con.prepareStatement(sql);
				
				pstmt.setInt(1, stock);
				pstmt.setString(2, code);
				pstmt.executeUpdate();
				
				System.out.println("STOCK UPDATE COMPELTE!");
				
			} finally {
				ds.close(pstmt, con);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	
	
	
}
