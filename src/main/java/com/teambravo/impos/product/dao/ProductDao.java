package com.teambravo.impos.product.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.teambravo.impos.init.domain.DataSource;
import com.teambravo.impos.init.service.NamingService;
import com.teambravo.impos.product.domain.Product;

public class ProductDao {
	
	NamingService namingService = NamingService.getInstance();
	DataSource ds = (DataSource) namingService.getAttribute("dataSource");
	
	//상품등록
	public void addProduct (Product product) {
		String sql = "INSERT INTO Product(proCode, proName, proPrice, proCategory)"
				+ "VALUES(?, ?, ?, ?)";
		
		System.out.println(product.getProCode());
		try {
			Connection con = null;
			PreparedStatement pstmt = null;
			try {
				con = ds.getConnection();
				pstmt = con.prepareStatement(sql);
				
				pstmt.setString(1, product.getProCode());
				pstmt.setString(2, product.getProName());
				pstmt.setDouble(3, product.getProPrice());
				pstmt.setString(4, product.getProCategory());
				pstmt.executeUpdate();
				
				System.out.println(product.getProCategory());
				System.out.println("INSERTED...");
			} finally {
				ds.close(pstmt, con);
			}
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	//상품조회
	public List<Product> findAllProduct() {
		String sql = "SELECT * FROM Product";
		List<Product> productList = new ArrayList<Product>();
		
		try {
			Connection con = null;
			PreparedStatement pstmt = null;
			ResultSet rs = null;
			try {
				con = ds.getConnection();
				pstmt = con.prepareStatement(sql);
				rs = pstmt.executeQuery();
				while (rs.next()) {
					Product p = new Product();
					p.setProCode(rs.getString("proCode"));
					p.setProName(rs.getString("proName"));
					p.setProPrice(rs.getDouble("proPrice"));
					p.setProCategory(rs.getString("proCategory"));
					productList.add(p);
				}
			} finally {
				ds.close(rs, pstmt, con);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return productList;
	}
}

