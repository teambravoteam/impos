package com.teambravo.impos.material.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.teambravo.impos.stock.service.StockService;

@WebServlet("/material/find_material_for_edit")
public class FindMaterialForEditServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private StockService stockService = new StockService();

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		
		String search = request.getParameter("search");
		
		if (search == null) {
			//실패페이지
		}
		if (search != null) {
			
		}
	}

}
