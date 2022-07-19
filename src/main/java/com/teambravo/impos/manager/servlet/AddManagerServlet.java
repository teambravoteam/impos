package com.teambravo.impos.manager.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.teambravo.impos.manager.domain.Managerdomain;
import com.teambravo.impos.manager.service.ManagerService;

@WebServlet("/manager/add_manager1")
public class AddManagerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private ManagerService service;

	public void init(ServletConfig config) throws ServletException { // ServletConfig 는 서블릿 기본 설정이라는 개념, 코드와 분리해서 사용하여
		// 유지보수성을 높임
		service = new ManagerService();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");

		String name = request.getParameter("name");
		String userId = request.getParameter("userId");
		String passwd = request.getParameter("passwd");
		String area = request.getParameter("area");
		String checkId = request.getParameter("checkId");
		String a = "";
		boolean check = service.checkId(userId);
		
		RequestDispatcher dispatcher = null; // 서버로 정보를 보내기위해 생성
		
		if (checkId.equals("checkId")) {
			
			if (check == false) {
				a = "중복된 아이디입니다";
				request.setAttribute("check", a);
			}
			
			else {
				a = "사용가능한 아이디입니다";
				request.setAttribute("check", a);
			}
			request.setAttribute("userId", userId);
			dispatcher = request.getRequestDispatcher("add_manager1.jsp");
			dispatcher.forward(request, response);
		}
		
		else {
			
			// 한개라도 입력 안했을시 안한 부분을 리스트에 저장
			List<String> errorMsgs = new ArrayList<>();
			if (name == null || name.length() == 0) {
				errorMsgs.add("이름은 필수입력 정보입니다");
			}
			if (userId == null || userId.length() == 0) {
				errorMsgs.add("아이디는 필수입력 정보입니다");
			}
			if (passwd == null || passwd.length() == 0) {
				errorMsgs.add("비밀번호는 필수입력 정보입니다");
			}
			if (area == null || area.length() == 0) {
				errorMsgs.add("점포명은 필수입력 정보입니다");
			}
			if (check == false) {
				errorMsgs.add("아이디가 중복되어있습니다");
			}

			// 리스트에 사이즈가 0이상이면 안한곳이 있으니 메서지를 set으로 저장
			if (errorMsgs.size() > 0) {
				request.setAttribute("errorMsgs", errorMsgs);
				dispatcher = request.getRequestDispatcher("adderror.jsp");
				dispatcher.forward(request, response);
				return;
			}

			
			// 도메인에 저장
			Managerdomain user = new Managerdomain();
			user.setName(name);
			user.setUserId(userId);
			user.setPassswd(passwd);
			user.setArea(area);
			
			service.addManager(user);
			request.setAttribute("user", user);
			dispatcher = request.getRequestDispatcher("success.jsp");
			dispatcher.forward(request, response);
			
		}
		
		
	}

}
