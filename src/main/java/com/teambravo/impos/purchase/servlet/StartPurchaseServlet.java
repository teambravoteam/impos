package com.teambravo.impos.purchase.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.teambravo.impos.product.domain.Product;
import com.teambravo.impos.product.service.ProductService;
import com.teambravo.impos.purchase.domain.Cart;
import com.teambravo.impos.purchase.service.PurchaseService;


@WebServlet("/purchase/start_purchase.do")
public class StartPurchaseServlet extends HttpServlet {
	//해당 서블릿은 jsp 파일 내에 장바구니에 구입을 시작할 경우
	// 해당 파일내에 '구매 하기' 버튼을 누를시 호출 됨
	// 해당 서블릿은 호출됨과 즉시, ProductService를 호출
	// Service 클래스 내에 있는 startPurchase 매소드를 호출함
 	
	private static final long serialVersionUID = 1L;

	private ProductService productService;

	
	public void init(ServletConfig config) throws ServletException {
	
		
		productService = new ProductService();
		//productService = new ProductService();
	}
       
   
    public StartPurchaseServlet() {
        super();      
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<Product> coffeeList = productService.findProduct("coffee");
		List<Product> cakeList = productService.findProduct("cake");
		List<Product> cookieList = productService.findProduct("cookie");
		
		
		request.setAttribute("coffeeList", coffeeList);
		request.setAttribute("cakeList", cakeList);
		request.setAttribute("cookieList", cookieList);
		
		
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("item_menu.jsp");
		dispatcher.forward(request, response);
	}

	

}
