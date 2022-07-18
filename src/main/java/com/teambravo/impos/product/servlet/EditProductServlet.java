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


@WebServlet("/product/edit_product")
public class EditProductServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private ProductService productService = new ProductService();
	
	private static List<Product> productList;
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		
		String category = request.getParameter("category");
		String code = request.getParameter("code");
		String name = request.getParameter("name");
		String pricebefore = request.getParameter("price");
		double price = Double.parseDouble(pricebefore);
		
		String button = request.getParameter("button");
		
		Product p = new Product();
		p.setProCategory(category);
		p.setProCode(code);
		p.setProName(name);
		p.setProPrice(price);
		
		// 가격이 음수이거나 인풋값들이 빈값이면 에러
		if (price < 0 || pricebefore == "") {
			request.getRequestDispatcher("error_edit_product.jsp").forward(request, response);
		}
		if (category == "" || name == "") {
			request.getRequestDispatcher("error_edit_product.jsp").forward(request, response);
		}
		
		if (button.equals("edit")) {
			System.out.println("edit");
			System.out.println("name: " + name);
			productService.updateProduct(p);
			request.getRequestDispatcher("product_edit_success.jsp").forward(request, response);
			
		} else if (button.equals("delete")) {
			System.out.println("delete");
			productService.deleteProduct(p);
			request.getRequestDispatcher("product_delete_success.jsp").forward(request, response);
		}
	
	}

}
