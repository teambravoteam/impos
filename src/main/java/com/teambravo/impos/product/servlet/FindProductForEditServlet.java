package com.teambravo.impos.product.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.teambravo.impos.product.domain.Product;
import com.teambravo.impos.product.service.ProductService;

@WebServlet("/product/find_product_for_edit")
public class FindProductForEditServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private ProductService productService = new ProductService();

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
			List<Product> productList = productService.findProduct(category);
			
			if (productList == null) {
				//실패페이지로 이동
				request.getRequestDispatcher("error_edit_product.jsp").forward(request, response);
			}
			
			if (productList != null) {				
				request.setAttribute("productList", productList);
				request.getRequestDispatcher("edit_product.jsp").forward(request, response);
			}
		}
		
		//search가 null아니면 중첩문
		if (search != "" ) {
			// 이름으로 검색
			if (findtype.equals("name")) {
				Product product = productService.findProductByNameAndCategory(search, category);
				
				if (product == null) {
					request.getRequestDispatcher("error_find_product.jsp").forward(request, response);
				}
				
				List<Product> productList = new ArrayList<Product>();
				productList.add(product);
				
				if (productList == null) {
					request.getRequestDispatcher("error_find_product.jsp").forward(request, response);					
				}
				
				request.setAttribute("productList", productList);
				request.getRequestDispatcher("edit_product.jsp").forward(request, response);					
				
				
			
			// 코드로 검색
			} else if (findtype.equals("code")) {
				Product product = productService.findProductByCode(category, search);
				
				if (product == null) {
					request.getRequestDispatcher("error_find_product.jsp").forward(request, response);					
				}
				
				List<Product> productList = new ArrayList<Product>();
				productList.add(product);
				
				if (productList == null) {
					request.getRequestDispatcher("error_find_product.jsp").forward(request, response);										
				}
				
				request.setAttribute("productList", productList);
				request.getRequestDispatcher("edit_product.jsp").forward(request, response);
			}
		}
	}
}
