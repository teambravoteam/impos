<%@ page language="java" import="java.net.URLEncoder" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>IMPOS</title>
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
						<h2 class="title">상품검색</h2>
					</div>
					<div class="content-body">
						<div class="form-table">
							<table class="search-table">
								<tr>
									<th>전체보기</th>
									<td>
										<button type="button" name="button" class="findall">
											<a href='<c:url value="/product/FindAllProduct"/>'>전체보기</a>
										</button>
									</td>
								</tr>
								<form class="searchform" action="find_product" method="post">
									<tr>
										<th>카테고리</th>
										<td>
											<select name="category" class="category">
												<option value="coffee">coffee</option>
												<option value="cookie">cookie</option>
												<option value="cake">cake</option>
											</select>
										</td>
									</tr>
								<tr>
									<th>검색어</th>
									<td>
										<select name="findtype" class="findtype">
											<option value="name">상품이름</option>
											<option value="code">상품코드</option>
										</select>
										<input type="text" name="search" class="searchinput">
										<button type="submit" name="button" class="searchbtn">검색</button>
									</td>
								</tr>
								</form>
							</table>
						</div>
						<div class="content-table">
							<table class="thead">
								<thead>
									<tr>
										<th class="t1">No</th>
										<th class="t2">카테고리</th>
										<th class="t3">상품코드</th>
										<th class="t4">상품명</th>
										<th class="t5">가격</th>
									</tr>
								</thead>
							</table>
							<div class="tbl-content">
								<table class="tbody">
									<tbody>
										<c:forEach var="productList" items="${productList}" varStatus="status">
											<tr>
												<td class="t1">${status.index + 1}</td>
												<td class="t2">${fn:split(productList, ',')[0]}</td>
												<td class="t3">${fn:split(productList, ',')[1]}</td>
												<td class="t4">${fn:split(productList, ',')[2]}</td>
												<td class="t5">
													<fmt:formatNumber type="number" maxFractionDigits="3" value="${fn:split(productList, ',')[3]}" />
												</td>
											</tr>
										</c:forEach>
									</tbody>
								</table>
							</div>
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