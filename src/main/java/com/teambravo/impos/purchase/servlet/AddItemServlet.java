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

@WebServlet("/purchase/addItem.do")
public class AddItemServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	ProductService productService = new ProductService();
	Cart cart = Cart.getCart();

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		List<Product> coffeeList = productService.findProduct("coffee");
		List<Product> cakeList = productService.findProduct("cake");
		List<Product> cookieList = productService.findProduct("cookie");

		request.setAttribute("coffeeList", coffeeList);
		request.setAttribute("cakeList", cakeList);
		request.setAttribute("cookieList", cookieList);

		String itemname = request.getParameter("proName");
		String itemcate = request.getParameter("proCate");

		System.out.println(request.getParameter("proCount"));
		int count = Integer.parseInt(request.getParameter("proCount"));
		Product p = productService.findProductByNameAndCategory(itemname, itemcate);
		MenuList menu = new MenuList(p, count);
		if (cart.getCartList().size() >= 5) {
			request.setAttribute("cart", cart);
			RequestDispatcher dispatcher = request.getRequestDispatcher("item_menu.jsp");
			dispatcher.forward(request, response);
			return;
		} else {
			cart.addList(menu);

			request.setAttribute("cart", cart);
			RequestDispatcher dispatcher = request.getRequestDispatcher("item_menu.jsp");
			dispatcher.forward(request, response);
		}
	}
}
