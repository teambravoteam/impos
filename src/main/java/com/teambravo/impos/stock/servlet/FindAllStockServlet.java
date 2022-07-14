package com.teambravo.impos.stock.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.teambravo.impos.stock.domain.Stock;
import com.teambravo.impos.stock.service.StockService;

@WebServlet("/stock/FindAllStock")
public class FindAllStockServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
      
	private StockService stockService = new StockService();
	
	private static List<Stock> stockList;
	//private static List<Stock> cakeList;
	
    @Override
    public void init(ServletConfig config) throws ServletException {
    	stockList = stockService.allStockList();
    	//cakeList = stockService.findAllStock("cake");
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		request.setAttribute("stockList", stockList);
		//request.setAttribute("cakeList", cakeList);
		request.getRequestDispatcher("all_stock_list.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		
	}

}
