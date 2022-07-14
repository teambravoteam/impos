package com.teambravo.impos.purchase.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.teambravo.impos.init.domain.DataSource;
import com.teambravo.impos.init.service.NamingService;
import com.teambravo.impos.product.domain.Product;
import com.teambravo.impos.purchase.domain.Cart;

public class PurchaseDao {
	NamingService namingService = NamingService.getInstance();
	DataSource da = (DataSource)namingService.getAttribute("dataSource");
	
	
	public void purchaseProductInsertSales(Cart cart) {
		List<List> run = new ArrayList<List>(); 		
		
		String sql = "INSERT INTO Sale(saCode,saName,saPrice,saCategory,saCount)"
				+ "VALUES(?,?,?,?,?)";	
		try {			
			Connection con = null;
			PreparedStatement pstmt = null;					
			try {				
				con = da.getConnection();			
				pstmt = con.prepareStatement(sql);	
				
				for(List<Product> li : run) {
					
					String saCode = li.get(0).getProCode();
					String saName = li.get(0).getProName();
					Double saPrice = li.get(0).getProPrice();
					String saCategory = li.get(0).getProCategory();			
					int saCount = li.size();	
					
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
	
	public void purchaseProductDeleteStock(Cart cart) {
		List<List> run = new ArrayList<List>(); 
		
		String sql = "UPDATE Stock SET stock=? WHERE sCode=?";
		try {			
			Connection con = null;
			PreparedStatement pstmt = null;	
			ResultSet rs = null;
			try {				
				con = da.getConnection();			
				pstmt = con.prepareStatement(sql);
				rs = pstmt.executeQuery();				
				if(rs.next()) {
					for(List<Product> li : run) {										
						pstmt.executeUpdate();			
					}
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
