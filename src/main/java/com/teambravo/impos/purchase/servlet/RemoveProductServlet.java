package com.teambravo.impos.purchase.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/RemoveProductServlet")
public class RemoveProductServlet extends HttpServlet {
	//해당 서블릿은 jsp 파일 내에 장바구니에 담긴 상품을 선택 후,
	// 해당 파일내에 'x' 혹은 '상품 취소' 버튼을 누를시 호출 됨
	// 해당 서블릿은 호출됨과 즉시, ProductService를 호출
	// Service 클래스 내에 있는 removeProductFromCart 매소드를 호출함
	
	private static final long serialVersionUID = 1L;
       

    public RemoveProductServlet() {
        super();
     
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}
