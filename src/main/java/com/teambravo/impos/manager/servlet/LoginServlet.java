package com.teambravo.impos.manager.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.teambravo.impos.manager.domain.Managerdomain;
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
		
		if (!service.isVaildUser(userId, passwd)) { // 아이디와 비밀번호가 존재하지 않다면
			request.getRequestDispatcher("error.jsp").forward(request, response); // 다시 로그인 페이지로 돌아간다
			System.out.println("로그인 실패");
			return;
		}

		
		// 존재한다면 로그인성공
		HttpSession session = request.getSession(true);
		System.out.println("로그인 성공");
		
		
		
		// 로그인 성공후 페이지에 로그인한 아이디로 저장되어있는 유저의 정보를 보낸다
		Managerdomain user = new Managerdomain();
		user = service.user(userId);
		session.setAttribute("name", user.getName());
		session.setAttribute("userId", user.getUserId());
		session.setAttribute("passwd", user.getPasswd());
		session.setAttribute("area", user.getArea());
		System.out.println(user.getName());
		response.sendRedirect("/impos/main/ms_main.jsp");
		
		
	}

}
