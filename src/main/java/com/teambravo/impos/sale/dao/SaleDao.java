package com.teambravo.impos.sale.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.teambravo.impos.init.domain.DataSource;
import com.teambravo.impos.init.service.NamingService;
import com.teambravo.impos.sale.service.Sale;

public class SaleDao {
	NamingService nameService = NamingService.getInstance();
	DataSource data = (DataSource) nameService.getAttribute("dataSource");

	// 전체 매출 불러오기
	public List<Sale> findAllSale() {
		String sql = "SELECT * FROM Sale";
		List<Sale> saleList = new ArrayList<>(); // List 배열로 데이터를 받기 위해 배열 생성
		try {
			Connection con = data.getConnection(); // DB와 연결
			PreparedStatement pstmt = con.prepareStatement(sql); // con에 sql을 입력하는 것을 pstmt에 담음
			ResultSet rs = pstmt.executeQuery();
			try {
				while (rs.next()) { // 해당 테이블에서 데이터를 찾으면 true, 없으면 false
					Sale sale = new Sale();
					sale.setSaCode(rs.getString("saCode"));
					sale.setSaName(rs.getString("saName"));
					sale.setSaPrice(rs.getDouble("saPrice"));
					sale.setSaCategory(rs.getString("saCategory"));
					sale.setSaCount(rs.getInt("saCount"));
					sale.setSaAllPrice(rs.getDouble("saPrice") * rs.getInt("saCount"));
					sale.setRegDate(rs.getDate("regDate"));
					saleList.add(sale);
				}
			} finally {
				data.close(rs, pstmt, con);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return saleList; // List 에 결과값을 받음
	}

	// 전체 매출 금액 불러오기
	public double findAllSaPrice() {
		String sql = "SELECT * FROM Sale";
		double allSaPrice = 0;
		try {
			Connection con = data.getConnection(); // DB와 연결
			PreparedStatement pstmt = con.prepareStatement(sql); // con에 sql을 입력하는 것을 pstmt에 담음
			ResultSet rs = pstmt.executeQuery();
			try {
				while (rs.next()) { // 해당 테이블에서 데이터를 찾으면 true, 없으면 false
					allSaPrice += rs.getDouble("saPrice") * rs.getDouble("saCount");
				}
			} finally {
				data.close(rs, pstmt, con);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return allSaPrice; // List 에 결과값을 받음
	}

	// 카테고리 별 매출 불러오기
	public List<Sale> findCategorySale(String saCategory) {
		String sql = "SELECT * FROM Sale WHERE saCategory = ?";
		List<Sale> saleList = new ArrayList<>(); // List 배열로 데이터를 받기 위해 배열 생성

		try {
			Connection con = data.getConnection(); // DB와 연결
			PreparedStatement pstmt = con.prepareStatement(sql); // con에 sql을 입력하는 것을 pstmt에 담음
			pstmt.setString(1, saCategory);
			ResultSet rs = pstmt.executeQuery(); // 데이터베이스에서 데이터를 가져와서(pstmt 입력) 결과 집합을 반환
			try {
				while (rs.next()) { // 해당 테이블에서 데이터를 찾으면 true, 없으면 false
					Sale sale = new Sale();
					sale.setSaCode(rs.getString("saCode"));
					sale.setSaName(rs.getString("saName"));
					sale.setSaPrice(rs.getDouble("saPrice"));
					sale.setSaCategory(rs.getString("saCategory"));
					sale.setSaCount(rs.getInt("saCount"));
					sale.setSaAllPrice(rs.getDouble("saPrice") * rs.getInt("saCount"));
					sale.setRegDate(rs.getDate("regDate"));
					saleList.add(sale);
				}
			} finally {
				data.close(rs, pstmt, con);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return saleList;
	}

	// 카테고리 별 매출 금액 불러오기
	public Double findCategorySaPrice(String saCategory) {
		String sql = "SELECT * FROM Sale WHERE saCategory = ?";
		double allSaPrice = 0;
		try {
			Connection con = data.getConnection(); // DB와 연결
			PreparedStatement pstmt = con.prepareStatement(sql); // con에 sql을 입력하는 것을 pstmt에 담음
			pstmt.setString(1, saCategory);
			ResultSet rs = pstmt.executeQuery();
			try {
				while (rs.next()) { // 해당 테이블에서 데이터를 찾으면 true, 없으면 false
					allSaPrice += rs.getDouble("saPrice") * rs.getDouble("saCount");
				}
			} finally {
				data.close(rs, pstmt, con);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return allSaPrice; // List 에 결과값을 받음
	}

	// 연 매출 불러오기
	public List<Sale> findYearSale(String yearDate) {
		String sql = "SELECT * FROM Sale WHERE YEAR(regDate) = ?";

		List<Sale> saleList = new ArrayList<>(); // List 배열로 데이터를 받기 위해 배열 생성

		try {
			Connection con = data.getConnection(); // DB와 연결
			PreparedStatement pstmt = con.prepareStatement(sql); // con에 sql을 입력하는 것을 pstmt에 담음
			pstmt.setString(1, yearDate);
			ResultSet rs = pstmt.executeQuery(); // 데이터베이스에서 데이터를 가져와서(pstmt 입력) 결과 집합을 반환
			try {
				while (rs.next()) { // 해당 테이블에서 데이터를 찾으면 true, 없으면 false
					Sale sale = new Sale();
					sale.setSaCode(rs.getString("saCode"));
					sale.setSaName(rs.getString("saName"));
					sale.setSaPrice(rs.getDouble("saPrice"));
					sale.setSaCategory(rs.getString("saCategory"));
					sale.setSaCount(rs.getInt("saCount"));
					sale.setSaAllPrice(rs.getDouble("saPrice") * rs.getInt("saCount"));
					sale.setRegDate(rs.getDate("regDate"));
					saleList.add(sale);
				}
			} finally {
				data.close(rs, pstmt, con);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return saleList;
	}

	// 연 매출 금액 불러오기
	public Double findYearSaPrice(String yearDate) {
		String sql = "SELECT * FROM Sale WHERE YEAR(regDate) = ?";
		double allSaPrice = 0;
		try {
			Connection con = data.getConnection(); // DB와 연결
			PreparedStatement pstmt = con.prepareStatement(sql); // con에 sql을 입력하는 것을 pstmt에 담음
			pstmt.setString(1, yearDate);
			ResultSet rs = pstmt.executeQuery();
			try {
				while (rs.next()) { // 해당 테이블에서 데이터를 찾으면 true, 없으면 false
					allSaPrice += rs.getDouble("saPrice") * rs.getDouble("saCount");
				}
			} finally {
				data.close(rs, pstmt, con);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return allSaPrice; // List 에 결과값을 받음
	}

	// 월 매출 불러오기
	public List<Sale> findMonthSale(String monthDate) {
		String sql = "SELECT * FROM Sale WHERE MONTH(regDate) = ?";

		List<Sale> saleList = new ArrayList<>(); // List 배열로 데이터를 받기 위해 배열 생성

		try {
			Connection con = data.getConnection(); // DB와 연결
			PreparedStatement pstmt = con.prepareStatement(sql); // con에 sql을 입력하는 것을 pstmt에 담음
			pstmt.setString(1, monthDate);
			ResultSet rs = pstmt.executeQuery(); // 데이터베이스에서 데이터를 가져와서(pstmt 입력) 결과 집합을 반환
			try {
				while (rs.next()) { // 해당 테이블에서 데이터를 찾으면 true, 없으면 false
					Sale sale = new Sale();
					sale.setSaCode(rs.getString("saCode"));
					sale.setSaName(rs.getString("saName"));
					sale.setSaPrice(rs.getDouble("saPrice"));
					sale.setSaCategory(rs.getString("saCategory"));
					sale.setSaCount(rs.getInt("saCount"));
					sale.setSaAllPrice(rs.getDouble("saPrice") * rs.getInt("saCount"));
					sale.setRegDate(rs.getDate("regDate"));
					saleList.add(sale);
				}
			} finally {
				data.close(rs, pstmt, con);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return saleList;
	}

	// 월 매출 금액 불러오기
	public Double findMonthSaPrice(String monthDate) {
		String sql = "SELECT * FROM Sale WHERE MONTH(regDate) = ?";
		double allSaPrice = 0;
		try {
			Connection con = data.getConnection(); // DB와 연결
			PreparedStatement pstmt = con.prepareStatement(sql); // con에 sql을 입력하는 것을 pstmt에 담음
			pstmt.setString(1, monthDate);
			ResultSet rs = pstmt.executeQuery();
			try {
				while (rs.next()) { // 해당 테이블에서 데이터를 찾으면 true, 없으면 false
					allSaPrice += rs.getDouble("saPrice") * rs.getDouble("saCount");
				}
			} finally {
				data.close(rs, pstmt, con);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return allSaPrice; // List 에 결과값을 받음
	}

	// 일 매출 불러오기
	public List<Sale> findDaySale(String dayDay) {
		String sql = "SELECT * FROM Sale WHERE DAY(regDate) = ?";

		List<Sale> saleList = new ArrayList<>(); // List 배열로 데이터를 받기 위해 배열 생성

		try {
			Connection con = data.getConnection(); // DB와 연결
			PreparedStatement pstmt = con.prepareStatement(sql); // con에 sql을 입력하는 것을 pstmt에 담음
			pstmt.setString(1, dayDay);
			ResultSet rs = pstmt.executeQuery(); // 데이터베이스에서 데이터를 가져와서(pstmt 입력) 결과 집합을 반환
			try {
				while (rs.next()) { // 해당 테이블에서 데이터를 찾으면 true, 없으면 false
					Sale sale = new Sale();
					sale.setSaCode(rs.getString("saCode"));
					sale.setSaName(rs.getString("saName"));
					sale.setSaPrice(rs.getDouble("saPrice"));
					sale.setSaCategory(rs.getString("saCategory"));
					sale.setSaCount(rs.getInt("saCount"));
					sale.setSaAllPrice(rs.getDouble("saPrice") * rs.getInt("saCount"));
					sale.setRegDate(rs.getDate("regDate"));
					saleList.add(sale);
				}
			} finally {
				data.close(rs, pstmt, con);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return saleList;
	}

	// 일 매출 금액 불러오기
	public Double findDaySaPrice(String dayDay) {
		String sql = "SELECT * FROM Sale WHERE DAY(regDate) = ?";
		double allSaPrice = 0;
		try {
			Connection con = data.getConnection(); // DB와 연결
			PreparedStatement pstmt = con.prepareStatement(sql); // con에 sql을 입력하는 것을 pstmt에 담음
			pstmt.setString(1, dayDay);
			ResultSet rs = pstmt.executeQuery();
			try {
				while (rs.next()) { // 해당 테이블에서 데이터를 찾으면 true, 없으면 false
					allSaPrice += rs.getDouble("saPrice") * rs.getDouble("saCount");
				}
			} finally {
				data.close(rs, pstmt, con);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return allSaPrice; // List 에 결과값을 받음
	}

	// 연월일 매출 불러오기
	public List<Sale> findDateSale(String yearDate, String monthDate, String dayDate) {
		String sql1 = "SELECT * FROM Sale";
		String sql2 = "SELECT * FROM Sale WHERE DAY(regDate) = ?";
		String sql3 = "SELECT * FROM Sale WHERE MONTH(regDate) = ?";
		String sql4 = "SELECT * FROM Sale WHERE MONTH(regDate) = ? AND DAY(regDate) = ?";
		String sql5 = "SELECT * FROM Sale WHERE YEAR(regDate) = ?";
		String sql6 = "SELECT * FROM Sale WHERE YEAR(regDate) = ? AND DAY(regDate) = ?";
		String sql7 = "SELECT * FROM Sale WHERE YEAR(regDate) = ? AND MONTH(regDate) = ?";
		String sql8 = "SELECT * FROM Sale WHERE YEAR(regDate) = ? AND MONTH(regDate) = ? AND DAY(regDate) = ?";

		List<Sale> saleList = new ArrayList<>(); // List 배열로 데이터를 받기 위해 배열 생성

		try {
			Connection con = data.getConnection(); // DB와 연결
			PreparedStatement pstmt = null;

			if (yearDate.equals("all")) { // year가 all
				if (monthDate.equals("all")) { // month가 all
					if (dayDate.equals("all")) { // day가 all
						pstmt = con.prepareStatement(sql1);
						System.out.println(yearDate + " / " + monthDate + " / " + dayDate);
					} else { // day 값 존재
						pstmt = con.prepareStatement(sql2);
						pstmt.setString(1, dayDate);
						System.out.println(yearDate + " / " + monthDate + " / " + dayDate);
					}

				} else { // month 값 존재
					if (dayDate.equals("all")) { // day가 all
						pstmt = con.prepareStatement(sql3);
						pstmt.setString(1, monthDate);
						System.out.println(yearDate + " / " + monthDate + " / " + dayDate);
					} else { // day 값 존재
						pstmt = con.prepareStatement(sql4);
						pstmt.setString(1, monthDate);
						pstmt.setString(2, dayDate);
						System.out.println(yearDate + " / " + monthDate + " / " + dayDate);
					}
				}
			} else { // year 값 존재
				if (monthDate.equals("all")) { // month가 all
					if (dayDate.equals("all")) { // day가 all
						pstmt = con.prepareStatement(sql5);
						pstmt.setString(1, yearDate);
						System.out.println(yearDate + " / " + monthDate + " / " + dayDate);
					} else { // day 값 존재
						pstmt = con.prepareStatement(sql6);
						pstmt.setString(1, yearDate);
						pstmt.setString(2, dayDate);
						System.out.println(yearDate + " / " + monthDate + " / " + dayDate);
					}

				} else { // month 값 존재
					if (dayDate.equals("all")) { // day가 all
						pstmt = con.prepareStatement(sql7);
						pstmt.setString(1, yearDate);
						pstmt.setString(2, monthDate);
						System.out.println(yearDate + " / " + monthDate + " / " + dayDate);
					} else { // day 값 존재
						pstmt = con.prepareStatement(sql8);
						pstmt.setString(1, yearDate);
						pstmt.setString(2, monthDate);
						pstmt.setString(3, dayDate);
						System.out.println(yearDate + " / " + monthDate + " / " + dayDate);
					}
				}
			}

			ResultSet rs = pstmt.executeQuery(); // 데이터베이스에서 데이터를 가져와서(pstmt 입력) 결과 집합을 반환
			try {
				while (rs.next()) { // 해당 테이블에서 데이터를 찾으면 true, 없으면 false
					Sale sale = new Sale();
					sale.setSaCode(rs.getString("saCode"));
					sale.setSaName(rs.getString("saName"));
					sale.setSaPrice(rs.getDouble("saPrice"));
					sale.setSaCategory(rs.getString("saCategory"));
					sale.setSaCount(rs.getInt("saCount"));
					sale.setSaAllPrice(rs.getDouble("saPrice") * rs.getInt("saCount"));
					sale.setRegDate(rs.getDate("regDate"));
					saleList.add(sale);
				}
			} finally {
				data.close(rs, pstmt, con);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return saleList;
	}

	// 연월일 매출 금액 불러오기
	public Double findDateSaPrice(String yearDate, String monthDate, String dayDate) {
		String sql1 = "SELECT * FROM Sale";
		String sql2 = "SELECT * FROM Sale WHERE DAY(regDate) = ?";
		String sql3 = "SELECT * FROM Sale WHERE MONTH(regDate) = ?";
		String sql4 = "SELECT * FROM Sale WHERE MONTH(regDate) = ? AND DAY(regDate) = ?";
		String sql5 = "SELECT * FROM Sale WHERE YEAR(regDate) = ?";
		String sql6 = "SELECT * FROM Sale WHERE YEAR(regDate) = ? AND DAY(regDate) = ?";
		String sql7 = "SELECT * FROM Sale WHERE YEAR(regDate) = ? AND MONTH(regDate) = ?";
		String sql8 = "SELECT * FROM Sale WHERE YEAR(regDate) = ? AND MONTH(regDate) = ? AND DAY(regDate) = ?";
		double allSaPrice = 0;
		try {
			Connection con = data.getConnection(); // DB와 연결
			PreparedStatement pstmt = null;

			if (yearDate.equals("all")) { // year가 all
				if (monthDate.equals("all")) { // month가 all
					if (dayDate.equals("all")) { // day가 all
						pstmt = con.prepareStatement(sql1);
						System.out.println(yearDate + " / " + monthDate + " / " + dayDate);
					} else { // day 값 존재
						pstmt = con.prepareStatement(sql2);
						pstmt.setString(1, dayDate);
						System.out.println(yearDate + " / " + monthDate + " / " + dayDate);
					}

				} else { // month 값 존재
					if (dayDate.equals("all")) { // day가 all
						pstmt = con.prepareStatement(sql3);
						pstmt.setString(1, monthDate);
						System.out.println(yearDate + " / " + monthDate + " / " + dayDate);
					} else { // day 값 존재
						pstmt = con.prepareStatement(sql4);
						pstmt.setString(1, monthDate);
						pstmt.setString(2, dayDate);
						System.out.println(yearDate + " / " + monthDate + " / " + dayDate);
					}
				}
			} else { // year 값 존재
				if (monthDate.equals("all")) { // month가 all
					if (dayDate.equals("all")) { // day가 all
						pstmt = con.prepareStatement(sql5);
						pstmt.setString(1, yearDate);
						System.out.println(yearDate + " / " + monthDate + " / " + dayDate);
					} else { // day 값 존재
						pstmt = con.prepareStatement(sql6);
						pstmt.setString(1, yearDate);
						pstmt.setString(2, dayDate);
						System.out.println(yearDate + " / " + monthDate + " / " + dayDate);
					}

				} else { // month 값 존재
					if (dayDate.equals("all")) { // day가 all
						pstmt = con.prepareStatement(sql7);
						pstmt.setString(1, yearDate);
						pstmt.setString(2, monthDate);
						System.out.println(yearDate + " / " + monthDate + " / " + dayDate);
					} else { // day 값 존재
						pstmt = con.prepareStatement(sql8);
						pstmt.setString(1, yearDate);
						pstmt.setString(2, monthDate);
						pstmt.setString(3, dayDate);
						System.out.println(yearDate + " / " + monthDate + " / " + dayDate);
					}
				}
			}

			ResultSet rs = pstmt.executeQuery();
			try {
				while (rs.next()) { // 해당 테이블에서 데이터를 찾으면 true, 없으면 false
					allSaPrice += rs.getDouble("saPrice") * rs.getDouble("saCount");
				}
			} finally {
				data.close(rs, pstmt, con);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return allSaPrice; // List 에 결과값을 받음
	}
}
