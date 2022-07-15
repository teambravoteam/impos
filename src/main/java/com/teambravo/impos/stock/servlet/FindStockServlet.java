package com.teambravo.impos.stock.servlet;

import java.io.IOException;
import java.util.ArrayList;
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
		
		System.out.println(category);
		System.out.println(findtype);
		System.out.println(search);
	
		// search가 null이면 카테고리별 검색
		if (search == "") {
			System.out.println("input에 값 없음");
			List<SelectStock> stockList = stockService.findAllStock(category);
			
			if (stockList == null) {
				//실패페이지로 이동
				request.getRequestDispatcher("error_edit_stock.jsp");
			}
			request.setAttribute("stockList", stockList);
			request.getRequestDispatcher("find_stock_list.jsp").forward(request, response);
		}
		
		//search가 null아니면 중첩문
		if (search != "" ) {
			// 이름으로 검색
			if (findtype.equals("name")) {
				SelectStock stock = stockService.findStockByName(category, search);
				
				// jsp에서 forEach문을 돌리기 대문에 arrayList에 담아야한다.
				List<SelectStock> stockList = new ArrayList<SelectStock>();
				stockList.add(stock);
				
				if (stockList == null) {
					//실패페이지로 이동
					request.getRequestDispatcher("error_edit_stock.jsp");
				}
				
				request.setAttribute("stockList", stockList);
				request.getRequestDispatcher("find_stock_list.jsp").forward(request, response);
			
			// 코드로 검색
			} else if (findtype.equals("code")) {
				SelectStock stock = stockService.findStockByCode(category, search);
				
				List<SelectStock> stockList = new ArrayList<SelectStock>();
				stockList.add(stock);
				
				if (stockList == null) {
					//실패페이지로 이동
					request.getRequestDispatcher("error_edit_stock.jsp");
				}
				
				request.setAttribute("stockList", stockList);
				request.getRequestDispatcher("find_stock_list.jsp").forward(request, response);
			}
		}
		

		
		

	}

}
