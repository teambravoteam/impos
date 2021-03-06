package com.teambravo.impos.stock.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.teambravo.impos.stock.domain.SelectStock;
import com.teambravo.impos.stock.domain.Stock;
import com.teambravo.impos.stock.service.StockService;

@WebServlet("/stock/FindAllStock")
public class FindAllStockServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
      
	private StockService stockService = new StockService();
	
	private static List<SelectStock> stockList;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		
		stockList = stockService.allStockList();
		request.setAttribute("stockList", stockList);
		
		request.getRequestDispatcher("find_stock_list.jsp").forward(request, response);
	}



}
