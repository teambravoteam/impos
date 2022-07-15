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

@WebServlet("/stock/find_all_stock_for_edit")
public class FindAllStockForEditServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
      
	private StockService stockService = new StockService();
	
	private static List<SelectStock> stockList;
	
    @Override
    public void init(ServletConfig config) throws ServletException {
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		
		stockList = stockService.allStockList();
		request.setAttribute("stockList", stockList);
		
		request.getRequestDispatcher("edit_stock.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		
		
	}

}
