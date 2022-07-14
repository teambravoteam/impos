package com.teambravo.impos.manager.servlet;

import java.io.IOException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.teambravo.impos.manager.service.ManagerService;

@WebServlet("/manager/login")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private ManagerService service;

	public void init(ServletConfig config) throws ServletException { // ServletConfig 는 서블릿 기본 설정이라는 개념, 코드와 분리해서 사용하여
		// 유지보수성을 높임
		service = new ManagerService();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.getRequestDispatcher("login.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// 입력한 아이디와 비번을 받아온다
		String userId = request.getParameter("userId");
		String passwd = request.getParameter("passwd");
		System.out.println(userId);
		System.out.println(passwd);
		if (!service.isVaildUser(userId, passwd)) { // 아이디와 비밀번호가 존재하지 않다면
			request.getRequestDispatcher("error.jsp").forward(request, response); // 다시 로그인 페이지로 돌아간다
			System.out.println("로그인 실패");
			return;
		}
		
		//존재한다면 로그인성공 mypage로 넘어간다
		HttpSession session = request.getSession(true);
		session.setAttribute("userId", userId);
		System.out.println("로그인 성공");
		response.sendRedirect("mypage");
	}
	
	
	
	

}
