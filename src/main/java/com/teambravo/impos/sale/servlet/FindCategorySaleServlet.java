package com.teambravo.impos.sale.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.teambravo.impos.sale.service.Sale;
import com.teambravo.impos.sale.service.SaleService;

@WebServlet("/sale/find_CategorySale.do")
public class FindCategorySaleServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private SaleService saleService;

	public void init(ServletConfig config) throws ServletException { // ServletConfig 는 서블릿 기본 설정이라는 개념, 코드와 분리해서 사용하여
																		// 유지보수성을 높임
		saleService = new SaleService(); // init 메소드에 넣음으로써, 여러 개의 객체 생성을 방지함
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");

		String saCategory = request.getParameter("saCategory");

		List<String> errorMsgs = new ArrayList<>();
		if (saCategory == null || saCategory.length() == 0) {
			errorMsgs.add("카테고리는 필수입력 정보입니다.");
		}

		RequestDispatcher dispatcher = null;
		if (errorMsgs.size() > 0) {
			request.setAttribute("errorMsgs", errorMsgs);
			dispatcher = request.getRequestDispatcher("error.jsp");
			dispatcher.forward(request, response);
			return;
		}

		// 3. 비즈니스 서비스 호출
		request.setAttribute("saCategory", saCategory);
		List<Sale> saleList = saleService.findCategorySale(saCategory);
		Double allSaPrice = saleService.findCategorySaPrice(saCategory);
		request.setAttribute("saleList", saleList);
		request.setAttribute("allSaPrice", allSaPrice);

		dispatcher = request.getRequestDispatcher("find_CategorySale.jsp");
		dispatcher.forward(request, response);
	}
}
