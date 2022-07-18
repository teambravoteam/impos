package com.teambravo.impos.material.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.teambravo.impos.init.domain.DataSource;
import com.teambravo.impos.init.service.NamingService;
import com.teambravo.impos.material.domain.Material;
import com.teambravo.impos.stock.domain.Stock;

public class MaterialDao {

	NamingService namingService = NamingService.getInstance();
	DataSource ds = (DataSource) namingService.getAttribute("dataSource");
	
	
	// 원재료 리스트 가져오기
	public List<Material> findAllMaterial() {
		List<Material> materialList = new ArrayList<Material>();
		String sql = "SELECT * FROM Material";
		
		try {
			Connection con = null;
			PreparedStatement pstmt = null;
			ResultSet rs = null;
			try {
				con = ds.getConnection();
				pstmt = con.prepareStatement(sql);
				rs = pstmt.executeQuery();
				
				while(rs.next()) {
					Material m = new Material();
					m.setMaterialName(rs.getString("materialName"));
					m.setMaterialVolume(rs.getDouble("materialVolume"));
					materialList.add(m);
				}
			} finally {
				ds.close(rs, pstmt, con);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return materialList;
	}
	
	
	// 재료명으로 항목찾기
	public Material findMaterialByName(String materialName) {
		String sql = "SELECT * FROM Material WHERE materialName = ?";
		Material m = null;
		
		try {
			Connection con = null;
			PreparedStatement pstmt = null;
			ResultSet rs = null;
			try {
				con = ds.getConnection();
				pstmt = con.prepareStatement(sql);
				
				pstmt.setString(1, materialName);
				
				rs = pstmt.executeQuery();
				
				while(rs.next()) {
					m = new Material();
					m.setMaterialName(rs.getString("materialName"));
					m.setMaterialVolume(rs.getDouble("materialVolume"));
				}
			} finally {
				ds.close(rs, pstmt, con);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return m;
	}
	
	
	// 원재료 차감, 추가 (수정)
	public void editVolume(String materialName, double materialVolume) {
		String sql = "UPDATE Material SET materialVolume = ? WHERE materialName = ?";
		
		try {
			Connection con = null;
			PreparedStatement pstmt = null;
			try {
				con = ds.getConnection();
				pstmt = con.prepareStatement(sql);
				
				pstmt.setDouble(1, materialVolume);
				pstmt.setString(2, materialName);
				
				pstmt.executeUpdate();
				
				System.out.println("MATERIAL UPDATE COMPELTE!");
				
			} finally {
				ds.close(pstmt, con);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
}
