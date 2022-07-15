package com.teambravo.impos.purchase.servlet;

import java.io.IOException;

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

@WebServlet("/purchase/purchase_item.do")
public class PurchaseProductServlet extends HttpServlet {
	// 해당 서블릿은 jsp 파일 내에 장바구니에 모든 상품을 담은후,
	// 해당 파일내에 '구매 하기' 버튼을 누를시 호출 됨
	// 해당 서블릿은 호출됨과 즉시, ProductService를 호출
	// Service 클래스 내에 있는 purchaseProduct 매소드를 호출함

	private static final long serialVersionUID = 1L;
	private ProductService productService = new ProductService();
	private PurchaseService purchaseService = new PurchaseService();
	private Cart cart = Cart.getCart();

	public PurchaseProductServlet() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		cart.cleanCartList();
		double money = Integer.parseInt(request.getParameter("money"));
		Product p = null;
		String item1name = request.getParameter("proName1");
		System.out.println(item1name);
		String item1cate = request.getParameter("proCate1");
		System.out.println(item1cate);
		int count1 = Integer.parseInt(request.getParameter("proCount1"));
		System.out.println(count1);
		if (count1 > 0) {			
			p = productService.findProductByNameAndCategory(item1name, item1cate);
			
			MenuList menu1 = new MenuList(p, count1);
			cart.addList(menu1);
		}

		String item2name = request.getParameter("proName2");
		String item2cate = request.getParameter("proCate2");
		int count2;
		if(request.getParameter("proCount2") == null) {
			count2 = 0;
		}else {
			count2 = Integer.parseInt(request.getParameter("proCount2"));
		}
		

		if (count2 > 0) {
			MenuList menu2 = new MenuList(productService.findProductByNameAndCategory(item2name, item2cate), count2);
			cart.addList(menu2);
		}

		String item3name = request.getParameter("proName3");
		String item3cate = request.getParameter("proCate3");
		int count3;
		if(request.getParameter("proCount3") == null) {
			count3 = 0;
		}else {
			count3 = Integer.parseInt(request.getParameter("proCount3"));
		}

		if (count3 > 0) {
			MenuList menu3 = new MenuList(productService.findProductByNameAndCategory(item3name, item3cate), count3);
			cart.addList(menu3);
		}

		String item4name = request.getParameter("proName4");
		String item4cate = request.getParameter("proCate4");
		int count4;
		if(request.getParameter("proCount4") == null) {
			count4 = 0;
		}else {
			count4 = Integer.parseInt(request.getParameter("proCount4"));
		}

		if (count4 > 0) {
			MenuList menu4 = new MenuList(productService.findProductByNameAndCategory(item4name, item4cate), count4);
			cart.addList(menu4);
		}

		String item5name = request.getParameter("proName5");
		String item5cate = request.getParameter("proCate5");
		int count5;
		if(request.getParameter("proCount5") == null) {
			count5 = 0;
		}else {
			count5 = Integer.parseInt(request.getParameter("proCount5"));
		}

		if (count5 > 0) {
			MenuList menu5 = new MenuList(productService.findProductByNameAndCategory(item5name, item5cate), count5);
			cart.addList(menu5);
		}
		
		//분기
		purchaseService.insertMoney(money);
		if(purchaseService.calMoney(cart)) {
			purchaseService.PurchaseItem(cart);
			cart.cleanCartList();
			
			double balance = purchaseService.getBalance();
			request.setAttribute("balance", balance);
			RequestDispatcher dispatcher = request.getRequestDispatcher("purchase_success.jsp");
			dispatcher.forward(request, response);
		}else {
			cart.cleanCartList();
			double balance = purchaseService.getBalance();
			request.setAttribute("balance", balance);
			RequestDispatcher dispatcher = request.getRequestDispatcher("purchase_failed.jsp");
			dispatcher.forward(request, response);
		}
		
	}

}
