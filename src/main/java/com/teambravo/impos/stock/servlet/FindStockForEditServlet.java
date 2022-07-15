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

@WebServlet("/stock/find_stock_for_edit")
public class FindStockForEditServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private StockService stockService = new StockService();

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");

		String category = request.getParameter("category");
		String findtype = request.getParameter("findtype");
		String search = request.getParameter("search");
		
		
		// search가 null이면 카테고리별 검색
		if (search == null) {
			List<SelectStock> stockList = stockService.findAllStock(category);
			if (stockList == null) {
				//실패페이지로 이동
				request.getRequestDispatcher("error_edit_stock.jsp");
			}
			request.setAttribute("stockList", stockList);
			request.getRequestDispatcher("edit_stock.jsp").forward(request, response);
		}
		
		//serach가 null아니면 중첩문
		if (search != null ) {
			if (findtype.equals("name")) {
				SelectStock stockList = stockService.findStockByName(category, search);
				
				System.out.println(stockList);
				if (stockList == null) {
					//실패페이지로 이동
					request.getRequestDispatcher("error_edit_stock.jsp");
				}
				request.setAttribute("stockList", stockList);
				request.getRequestDispatcher("edit_stock.jsp").forward(request, response);
				
			} else if (findtype.equals("code")) {
				SelectStock stockList = stockService.findStockByCode(category, search);
				
				System.out.println(stockList);
				if (stockList == null) {
					//실패페이지로 이동
					request.getRequestDispatcher("error_edit_stock.jsp");
				}
				request.setAttribute("stockList", stockList);
				request.getRequestDispatcher("edit_stock.jsp").forward(request, response);
			}
		}
		

		
		

	}

}
