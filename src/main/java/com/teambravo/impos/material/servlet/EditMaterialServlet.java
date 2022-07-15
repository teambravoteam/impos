package com.teambravo.impos.material.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.teambravo.impos.material.service.MaterialService;

@WebServlet("/material/edit_material")
public class EditMaterialServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private MaterialService mservice = new MaterialService();
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("UTF-8");

		String name = request.getParameter("name");
		String countbefore = request.getParameter("count");
		int count = Integer.parseInt(countbefore);
		
		
		// 음수로 저장하면 error
		if (count < 0 || countbefore == "") {
			request.getRequestDispatcher("error_edit_material.jsp").forward(request, response);
		}
		
		if (!(count<0)) {
			mservice.editVolume(name, count);	
			request.getRequestDispatcher("success_edit_material.jsp").forward(request, response);
		}
		
		
	}

}
