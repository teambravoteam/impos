package com.teambravo.impos.product.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.teambravo.impos.product.domain.Product;
import com.teambravo.impos.product.service.ProductService;

@WebServlet("/product/find_all_product_for_edit")
public class FindAllProductForEditServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
      
	private ProductService productService = new ProductService();
	
	private static List<Product> productList;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		
		productList = productService.findAllProduct();
		request.setAttribute("productList", productList);
		
		request.getRequestDispatcher("edit_product.jsp").forward(request, response);
	}

}