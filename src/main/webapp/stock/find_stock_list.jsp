<%@ page language="java" import="java.net.URLEncoder"
	contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>재고수정</title>
<link rel="stylesheet" href="../ms_incl/ms_init.css">
<link rel="stylesheet" href="../ms_incl/ms_style.css">
<link rel="stylesheet" href="./css/stock_style.css">
</head>
<body>
	<div class="wrap">
		<!-- header -->
		<jsp:include page="/ms_incl/ms_header.jsp">
			<jsp:param name="sub-title" value="<%=URLEncoder.encode(\"managerSystem : 배너\", \"UTF-8\") %>" />
		</jsp:include>
		<!-- main -->
		<main id="container">
			<div id="contentWrap">
				<!-- 왼쪽 메뉴 영역 -->
				<section id="snb">
					<nav class="nav">
						<ul class="left-menu">
							<li><a href="#">상품관리</a></li>
							<li><a href="#">재고관리</a></li>
							<li><a href="#">원재료관리</a></li>
							<li><a href="#">매출관리</a></li>
						</ul>
					</nav>
				</section>
				<!-- content영역 -->
				<div id="content">
					<div class="content-info">
						<h2 class="title">재고수정</h2>
						<div class="loaction-wrap">location</div>
					</div>
					<div class="content-body">
						<form class="searchform" action="index.html" method="post">
							<select name="category" class="category">
								<option value="all">전체</option>
								<option value="coffee">coffee</option>
								<option value="cookie">cookie</option>
								<option value="cake">cake</option>
							</select> <select name="findtype" class="findtype">
								<option value="all">전체</option>
								<option value="name">상품이름</option>
								<option value="code">상품코드</option>
							</select> <input type="text" name="search" class="searchinput">
							<button type="submit" name="button">검색</button>
						</form>
						<div class="content-table">
							<table class="thead">
								<thead>
									<tr>
										<th>id</th>
										<th>카테고리</th>
										<th>상품코드</th>
										<th>상품명</th>
										<th>가격</th>
										<th>재고</th>
									</tr>
								</thead>
							</table>
							<div class="tbl-content">
								<table class="tbody">
									<tbody>
										<c:forEach var="stockList" items="${stockList}">
											<tr>
												<td>${fn:split(stockList, ',')[0]}</td>
												<td>${fn:split(stockList, ',')[1]}</td>
												<td>${fn:split(stockList, ',')[2]}</td>
												<td>${fn:split(stockList, ',')[3]}</td>
												<td>${fn:split(stockList, ',')[4]}</td>
												<td>${fn:split(stockList, ',')[5]}</td>
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