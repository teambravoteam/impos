package com.teambravo.impos.stock.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.teambravo.impos.stock.service.StockService;

@WebServlet("/stock/edit_stock")
public class EditStockServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private StockService stockService = new StockService();

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");

		String category = request.getParameter("category");
		String code = request.getParameter("code");
		String stockbefore = request.getParameter("stock");
		int stock = Integer.parseInt(stockbefore);
		
		// 유효성 검증
		
		stockService.editStock(category, code, stock);
		request.getRequestDispatcher("success_edit_stock.jsp");
		
		
	}

}
