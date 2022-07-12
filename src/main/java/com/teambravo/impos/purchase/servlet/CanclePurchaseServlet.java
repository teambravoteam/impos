package com.teambravo.impos.purchase.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/CanclePurchaseServlet")
public class CanclePurchaseServlet extends HttpServlet {
	//해당 서블릿은 jsp 파일 내에 장바구니에 구입을 취소할 경우
	// 해당 파일내에 '구매 취소 하기' 버튼을 누를시 호출 됨
	// 해당 서블릿은 호출됨과 즉시, ProductService를 호출
	// Service 클래스 내에 있는 canclePurchase 매소드를 호출함
 	
	private static final long serialVersionUID = 1L;
       
   
    public CanclePurchaseServlet() {
        super();
      
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

	
}
