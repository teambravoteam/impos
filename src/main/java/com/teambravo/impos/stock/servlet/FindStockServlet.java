package com.teambravo.impos.stock.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.teambravo.impos.stock.domain.SelectStock;
import com.teambravo.impos.stock.service.StockService;

@WebServlet("/stock/find_stock")
public class FindStockServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private StockService stockService = new StockService();

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");

		String category = request.getParameter("category");
		String findtype = request.getParameter("findtype");
		String search = request.getParameter("search");
		
		
		if (!category.equals("all") && search==null) {
			List<SelectStock> stockList = stockService.findAllStock(category);
		}
		
		// category==전체, findtype==전체, search==null 일 경우 findAllStock
		// category가 전체가 아니고 search==null이면 카테고리별 findall
		// findtype이 name이면 이름으로 재고 검색
		// findtype이 code면 코드로 재고검색

	}

}
