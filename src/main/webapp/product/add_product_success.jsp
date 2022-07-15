<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@page import="java.net.URLDecoder"%>
<%@page import="java.util.*,java.io.*"%>

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
						<h2 class="title">상품등록에 성공하였습니다.</h2>
					</div>
					<div class="content-body">
						<div class="form-table">
							<table class="search-table">
								<form class="searchform" action="add_product" method="post">
									<tr>
										<th>카테고리</th>
										<td>${product.proCategory}</td>
									</tr>
									<tr>
										<th>상품명</th>
										<td>${product.proName}</td>
									</tr>
									<tr>
										<th>가격</th>
										<td>${product.proPrice}</td>
									</tr>
									<tr>
										<td colspan="2">
											<button type="button" onclick="location.href='../product/add_product.jsp'">확인</button>
											<button type="submit" onclick="location.href='../.jsp'">수정</button>
										</td>
									</tr>
								</form>
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

<body>
<div id="wrapper">
	<div id="content-wrapper">
	<h3>상품등록에 성공하였습니다.</h3>
	
	상품이름 : ${product.proName}<br>
	상품가격 : ${product.proPrice}<br>
	상품카테고리 : ${product.proCategory}<br>
	</div>
</div>
</body>
</html>