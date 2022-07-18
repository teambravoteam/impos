<%@page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@page import="java.net.URLEncoder"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

<link rel="stylesheet" href="../ms_incl/ms_init.css">
<link rel="stylesheet" href="./css/product_style.css">

</head>
<body>
	<div class="wrap">
		<!-- header -->
		<%@ include file="/ms_incl/ms_header.jsp"%>
		<!-- main -->
		<main>
			<div id="container">
				<!-- 왼쪽 메뉴 영역 -->
				<%@ include file="/ms_incl/ms_menu.jsp"%>
				<!-- content영역 -->
				<div id="content">
					<div class="content-info">
						<h2 class="title">상품등록</h2>
					</div>
					<div class="content-body">
						<div class="form-table">
							<table class="search-table">
								<tr>
									<th>카테고리</th>
									<td>
										<form class="searchform" action="add_product" method="post" enctype="multipart/form-data">
											<select name="procategory" class="procategory"
												style="width: 204px; height: 28px;">
												<option value="coffee">coffee</option>
												<option value="cookie">cookie</option>
												<option value="cake">cake</option>
											</select>
									</td>
								</tr>
								<tr>
									<th>상품명</th>
									<td><input type="text" name="proname" class="searchinput">
									</td>
								</tr>
								<tr>
									<th>가격</th>
									<td><input type="number" name="proprice"
										class="searchinput"></td>
								</tr>
								<tr>
									<th>상품이미지</th>
									<td><input type="file" name="proimage" class="searchinput">
									</td>
								</tr>
								<tr>
									<td colspan="2">
										<button type="button" style="width: 50px; height: 35px"
											onclick="location.href='../product/find_product_list.jsp'">취소</button>
										<button type="submit" style="width: 50px; height: 35px">저장</button>
										<button type="button" style="width: 50px; height: 35px"
											onclick="location.href='../product/find_product_list.jsp'">목록</button>
										</form>
									</td>
								</tr>
							</table>
						</div>
					</div>
				</div>
			</div>
		</main>
		<!-- footer -->
		<%@ include file="/ms_incl/ms_footer.jsp"%>
	</div>
</body>
</html>