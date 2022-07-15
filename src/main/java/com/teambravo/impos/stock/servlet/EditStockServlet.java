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
	
    public void init() throws ServletException {
    	
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		
	}

}
