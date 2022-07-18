package com.teambravo.impos.purchase.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.teambravo.impos.product.domain.Product;
import com.teambravo.impos.product.service.ProductService;
import com.teambravo.impos.purchase.domain.Cart;
import com.teambravo.impos.purchase.domain.MenuList;
import com.teambravo.impos.purchase.service.PurchaseService;

/**
 * Servlet implementation class MinusItemServlet
 */
@WebServlet("/purchase/minus_item.do")
public class MinusItemServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ProductService productService = new ProductService();
	private PurchaseService purchaseService = new PurchaseService();
	private Cart cart = Cart.getCart();

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {		
		List<Product> coffeeList = productService.findProduct("coffee");
		List<Product> cakeList = productService.findProduct("cake");
		List<Product> cookieList = productService.findProduct("cookie");

		request.setAttribute("coffeeList", coffeeList);
		request.setAttribute("cakeList", cakeList);
		request.setAttribute("cookieList", cookieList);

		
		
		String count1 =request.getParameter("cleanitem");
		System.out.println(count1);		
		cart.cleanCartList();
		
		request.setAttribute("cart", cart);
		RequestDispatcher dispatcher = request.getRequestDispatcher("item_menu.jsp");
		dispatcher.forward(request, response);
		
	
		
	}

}
