package com.teambravo.impos.manager.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.print.attribute.PrintJobAttribute;

import com.teambravo.impos.init.domain.DataSource;
import com.teambravo.impos.init.service.NamingService;
import com.teambravo.impos.manager.domain.Managerdomain;


public class Managerdao {
	NamingService nameService = NamingService.getInstance();
	DataSource data = (DataSource) nameService.getAttribute("dataSource");
	

	public void addmanager(Managerdomain user) {
		String sql = "INSERT INTO Manager(name,userId,passwd,area) VALUES (?,?,?,?)";
		
		try {
			
			Connection con = data.getConnection(); // DB와 연결
			PreparedStatement pstmt = con.prepareStatement(sql);
			
			pstmt.setString(1, user.getName());
			pstmt.setString(2, user.getUserId());
			pstmt.setString(3, user.getPasswd());
			pstmt.setString(4, user.getArea());
			pstmt.executeUpdate();
			
			data.close(pstmt, con);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	
	// 관리자가 입력한 아이디를 받아와서 테이블에 있는지 확인후 있으면 그이름이 포함된 테이블 정보를 찾아서 저장한다
	public Managerdomain findUser(String userId) {
		String sql = "SELECT * FROM Manager WHERE userId = ?";
		Managerdomain user = null;
		
		try {
			Connection con = data.getConnection(); // DB와 연결
			PreparedStatement pstmt = con.prepareStatement(sql); // con에 sql을 입력하는 것을 pstmt에 담음
			pstmt.setString(1, userId); // id를 가져와서 저장
			ResultSet rs = pstmt.executeQuery(); // 데이터베이스에서 데이터를 가져와서(pstmt 입력) 결과 집합을 반환
			
			
			try {
				if (rs.next()) { // 테이블에 입력한 아이디가 있는 행이 있는지 테이블 끝까지 검사한다
					user = new Managerdomain();
					user.setName(rs.getString("name"));
					user.setUserId(rs.getString("userId"));
					user.setPassswd(rs.getString("passwd"));
					user.setArea(rs.getString("area"));
				}
				
				
			
				
			} finally {
				data.close(rs,pstmt,con);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
		return user;
		
	}
	
	
	
}
