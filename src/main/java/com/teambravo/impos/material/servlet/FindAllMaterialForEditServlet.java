package com.teambravo.impos.material.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.teambravo.impos.material.domain.Material;
import com.teambravo.impos.material.service.MaterialService;

@WebServlet("/material/find_all_material_for_edit")
public class FindAllMaterialForEditServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private MaterialService mservice = new MaterialService();
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<Material> materialList = mservice.findAllMaterial();
		
		request.setAttribute("materialList", materialList);
		
		request.getRequestDispatcher("edit_material.jsp").forward(request, response);
	
	}

	

}
