package com.teambravo.impos.purchase.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.teambravo.impos.init.domain.DataSource;
import com.teambravo.impos.init.service.NamingService;
import com.teambravo.impos.material.domain.Material;
import com.teambravo.impos.material.service.MaterialService;
import com.teambravo.impos.product.domain.Product;
import com.teambravo.impos.purchase.domain.Cart;
import com.teambravo.impos.purchase.domain.MenuList;
import com.teambravo.impos.stock.domain.SelectStock;
import com.teambravo.impos.stock.domain.Stock;
import com.teambravo.impos.stock.service.StockService;

public class PurchaseDao {
	NamingService namingService = NamingService.getInstance();
	DataSource da = (DataSource)namingService.getAttribute("dataSource");
	StockService stockService;
	MaterialService materialService;
	
	
	public void purchaseProductInsertSales(Cart cart) {
		List<MenuList> list = cart.getCartList(); 		
		
		String sql = "INSERT INTO Sale(saCode,saName,saPrice,saCategory,saCount)"
				+ "VALUES(?,?,?,?,?)";	
		try {			
			Connection con = null;
			PreparedStatement pstmt = null;					
			try {				
				con = da.getConnection();			
				pstmt = con.prepareStatement(sql);	
				
				for(MenuList li : list) {
					Product p = li.getProduct();					
					
					String saCode = p.getProCode();
					String saName = p.getProName();
					Double saPrice = p.getProPrice();
					String saCategory = p.getProCategory();
					int saCount = li.getCount();
					
					pstmt.setString(1, saCode);
					pstmt.setString(2, saName);
					pstmt.setDouble(3, saPrice);
					pstmt.setString(4, saCategory);
					pstmt.setInt(5, saCount);
					
				
					pstmt.executeUpdate();						
				}								
			}			
			finally{
				da.close(pstmt,con);
			}				
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public void purchaseProductDeleteCoffeeMaterial(MenuList menuList) {	
		String sName = menuList.getProduct().getProName();		
		Material material = materialService.findMaterialByName(sName);
		double prematerial = material.getMaterialVolume();
		
		String sql = "UPDATE Material SET stock=? WHERE sCode=?";
		try {			
			Connection con = null;
			PreparedStatement pstmt = null;	
			ResultSet rs = null;
			try {				
				con = da.getConnection();			
				pstmt = con.prepareStatement(sql);
				rs = pstmt.executeQuery();				
				if(rs.next()) {					
					String sCode = menuList.getProduct().getProCode();
					double materialCount = prematerial - menuList.getCount();
					
					pstmt.setString(1,sCode);
					pstmt.setDouble(2,materialCount);						
						
					pstmt.executeUpdate();			
				}
				
			}			
			finally{
				da.close(rs,pstmt,con);
			}	
			
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public void purchaseProductDeleteCakeStock(MenuList menuList) {
		String sName = menuList.getProduct().getProName();
		String sCate = menuList.getProduct().getProCategory();
		SelectStock stock = stockService.findStockByName(sCate, sName);
		int preStock = stock.getStock();
		
		
		String sql = "UPDATE CakeStock SET stock=? WHERE sCode=?";
		try {			
			Connection con = null;
			PreparedStatement pstmt = null;	
			ResultSet rs = null;
			try {				
				con = da.getConnection();			
				pstmt = con.prepareStatement(sql);
				rs = pstmt.executeQuery();				
				if(rs.next()) {
					String sCode = menuList.getProduct().getProCode();
					int stockCount = preStock - menuList.getCount();
					
					pstmt.setString(1,sCode);
					pstmt.setDouble(2,stockCount);
					
					pstmt.executeUpdate();			
				}
				
			}			
			finally{
				da.close(rs,pstmt,con);
			}	
			
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public void purchaseProductDeleteCookieStock(MenuList menuList) {
		String sName = menuList.getProduct().getProName();
		String sCate = menuList.getProduct().getProCategory();
		SelectStock stock = stockService.findStockByName(sCate, sName);
		int preStock = stock.getStock();
		
		String sql = "UPDATE CookieStock SET stock=? WHERE sCode=?";
		try {			
			Connection con = null;
			PreparedStatement pstmt = null;	
			ResultSet rs = null;
			try {				
				con = da.getConnection();			
				pstmt = con.prepareStatement(sql);
				rs = pstmt.executeQuery();				
				if(rs.next()) {
					String sCode = menuList.getProduct().getProCode();
					int stockCount = preStock - menuList.getCount();
					
					pstmt.setString(1,sCode);
					pstmt.setDouble(2,stockCount);
					
						
					pstmt.executeUpdate();			
				}
				
			}			
			finally{
				da.close(rs,pstmt,con);
			}	
			
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
		
	
	

}
