package com.teambravo.impos.material.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.teambravo.impos.material.domain.Material;
import com.teambravo.impos.material.service.MaterialService;

@WebServlet("/material/find_material")
public class FindMaterialServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private MaterialService mService = new MaterialService();

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		
		String search = request.getParameter("search");
		System.out.println(search);
		
		
		// 값없으면 에러
		if (search == "") {
			System.out.println("input에 값 없음");
			request.getRequestDispatcher("error_find_material.jsp").forward(request, response);
		}
		
		if (search != "") {
			System.out.println("input에 값 있음");
			Material result = mService.findMaterialByName(search);
			
			if (result == null) {
				request.getRequestDispatcher("error_find_material.jsp").forward(request, response);				
			}
			
			List<Material> materialList = new ArrayList<Material>();
			materialList.add(result);
			request.setAttribute("materialList", materialList);
			request.getRequestDispatcher("find_material_list.jsp").forward(request, response);;
		}
		
		
	}

}
