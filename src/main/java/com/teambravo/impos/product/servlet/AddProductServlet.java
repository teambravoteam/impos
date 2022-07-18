package com.teambravo.impos.product.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;
import com.teambravo.impos.product.domain.Product;
import com.teambravo.impos.product.service.ProductService;

@WebServlet("/product/add_product")
public class AddProductServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private ProductService productService = new ProductService();

	public void init(ServletConfig config) throws ServletException {

	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");

		String path = "/purchase/image";
		ServletContext context = request.getSession().getServletContext();
		String realPath = context.getRealPath(path);

		String directory = realPath;

		int sizeLimit = 100 * 1024 * 1024;
		String encode = "UTF-8";

		MultipartRequest multi = new MultipartRequest(request, directory, sizeLimit, encode,
				new DefaultFileRenamePolicy());
		// httprequest, 디렉토리위치, 파일크기제한, encoding방식, 동일파일명에 대한 처리

		String fileName = multi.getFilesystemName("proimage"); // 파일이름가져오기
		System.out.println(fileName);

		// 1. 폼 파라메터 얻기
		String proName = multi.getParameter("proname");
		String proPriceString = multi.getParameter("proprice");
		String proCategory = multi.getParameter("procategory");
		double proPrice = Double.parseDouble(proPriceString);

		RequestDispatcher dispatcher = null;
		try {
			if (request.getParameter("proprice") != null) {
				System.out.println("proPriceString" + proPriceString);
			}
		} catch (Exception e) {
			// 2. 유효성 검증 및 변환
			List<String> errorMsgs = new ArrayList<>();
			if (proName == null || proName.length() == 0) {
				errorMsgs.add("물품이름은 필수입력 정보입니다.");
			} else if (proPriceString == null || proPriceString.length() == 0) {
				errorMsgs.add("물품가격은 필수입력 정보입니다.");
			}
			request.setAttribute("errorMsgs", errorMsgs);

			if (errorMsgs.size() > 0) {
				dispatcher = request.getRequestDispatcher("add_product_error.jsp");
				dispatcher.forward(request, response);
				return;
			}
			return;
		}

		// 3. 비즈니스 서비스 호출(상품등록)
		productService.addProductTable(proName, proPrice, proCategory, fileName);
		Product product = new Product();
		product.setProName(proName);
		product.setProCategory(proCategory);
		System.out.println("2:" + proPrice);
		product.setProPrice(proPrice);
		request.setAttribute("product", product);

		// 4. NextPage
		dispatcher = request.getRequestDispatcher("add_product_success.jsp");
		dispatcher.forward(request, response);
	}
}
