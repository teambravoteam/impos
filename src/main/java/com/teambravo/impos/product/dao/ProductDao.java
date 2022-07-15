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

	// 상품등록
	public void addProduct(Product product) {
		String sql = null;
		if (product.getProCategory().equals("coffee")) {
			sql = "INSERT INTO Coffee(proCode, proName, proPrice, proCategory)" + "VALUES(?, ?, ?, ?)";
		} else if (product.getProCategory().equals("cookie")) {
			sql = "INSERT INTO Cookie(proCode, proName, proPrice, proCategory)" + "VALUES(?, ?, ?, ?)";
		} else if (product.getProCategory().equals("cake")) {
			sql = "INSERT INTO Cake(proCode, proName, proPrice, proCategory)" + "VALUES(?, ?, ?, ?)";
		}

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
				System.out.println("ADD PRODUT INSERTED...");
			} finally {
				ds.close(pstmt, con);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	

	// 상품삭제
	public void deleteProduct(Product product) {
		String sql = null;
		if (product.getProCategory().equals("coffee")) {
			sql = "DELETE FROM Coffee WHERE proCode=?";
		} else if (product.getProCategory().equals("cookie")) {
			sql = "DELETE FROM Cookie WHERE proCode=?";
		} else if (product.getProCategory().equals("cake")) {
			sql = "DELETE FROM Cake WHERE proCode=?";
		}

		try {
			Connection con = null;
			PreparedStatement pstmt = null;

			try {
				con = ds.getConnection();
				pstmt = con.prepareStatement(sql);
				pstmt.setString(1, product.getProCode());

				System.out.println("DELETED...");
			} finally {
				ds.close(pstmt, con);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// 카테고리별 상품 조회
	public List<Product> findProduct(String category) {
		String sql = null;
		if (category.equals("coffee")) {
			sql = "SELECT * FROM Coffee";
		} else if (category.equals("cookie")) {
			sql = "SELECT * FROM Cookie";
		} else if (category.equals("cake")) {
			sql = "SELECT * FROM Cake";
		}
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

	// 이름과 카테고리로조회
	public Product findProductByNameAndCategory(String name, String category) {
		String sql = null;
		Product product = null;
		if (category.equals("coffee")) {
			sql = "SELECT * FROM Coffee WHERE proName=?";
		} else if (category.equals("cookie")) {
			sql = "SELECT * FROM Cookie WHERE proName=?";
		} else if (category.equals("cake")) {
			sql = "SELECT * FROM Cake WHERE proName=?";
		}

		try {
			Connection con = null;
			PreparedStatement pstmt = null;
			ResultSet rs = null;
			try {
				con = ds.getConnection();
				pstmt = con.prepareStatement(sql);
				pstmt.setString(1, name);
				rs = pstmt.executeQuery();

				if (rs.next()) {
					product = new Product();

					product.setProCode(rs.getString("proCode"));
					product.setProName(rs.getString("proName"));
					product.setProPrice(rs.getDouble("proPrice"));
					product.setProCategory(rs.getString("proCategory"));
					pstmt.executeUpdate();

				}
			} finally {
				ds.close(rs, pstmt, con);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return product;
	}

	// 코드로 상품조회
	public Product findProductByCode(String category, String code) {
		String sql = null;
		Product product = null;
		if (category.equals("coffee")) {
			sql = "SELECT * FROM Coffee WHERE proCode=?";
		} else if (category.equals("cookie")) {
			sql = "SELECT * FROM Cookie WHERE proCode=?";
		} else if (category.equals("cake")) {
			sql = "SELECT * FROM Cake WHERE proCode=?";
		}

		try {
			Connection con = null;
			PreparedStatement pstmt = null;
			ResultSet rs = null;
			try {
				con = ds.getConnection();
				pstmt = con.prepareStatement(sql);
				pstmt.setString(1, code);
				rs = pstmt.executeQuery();

				if (rs.next()) {
					product = new Product();

					product.setProCode(rs.getString("proCode"));
					product.setProName(rs.getString("proName"));
					product.setProPrice(rs.getDouble("proPrice"));
					product.setProCategory(rs.getString("proCategory"));
					pstmt.executeUpdate();

				}
			} finally {
				ds.close(rs, pstmt, con);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return product;
	}
}
