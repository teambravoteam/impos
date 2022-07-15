package com.teambravo.impos.purchase.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.teambravo.impos.purchase.service.PurchaseService;


@WebServlet("/purchase/restart_purchase.do")
public class ReStartPurchaseServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	PurchaseService purchaseService = new PurchaseService();
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		purchaseService.setMoney(0);
		RequestDispatcher dispatcher = request.getRequestDispatcher("start_purchase.jsp");
		dispatcher.forward(request, response);
	}

}
