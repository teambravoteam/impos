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
<link rel="stylesheet" href="./css/stock_edit_style.css">
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
						<h2 class="title">재고수정</h2>
					</div>
					<div class="content-body">
						<div class="form-table">
							<table class="search-table">
								<tr>
									<th>전체보기</th>
									<td>
										<button type="button" name="button" class="findall">
											<a href='<c:url value="/stock/find_all_stock_for_edit"/>'>전체보기</a>
										</button>
									</td>
								</tr>
								<form class="searchform" action="find_stock_for_edit" method="post">
									<tr>
										<th>카테고리</th>
										<td>
											<select name="category" class="category">
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
										<th class="t6">재고</th>
										<th class="t7">수정</th>
									</tr>
								</thead>
							</table>
							<div class="tbl-content">
								<table class="tbody">
									<tbody>
										<c:forEach var="stockList" items="${stockList}" varStatus="status">
											<form class="" action="edit_stock" method="post">
												<tr>
													<td class="t1">${status.index + 1}</td>
													<td class="t2">${fn:split(stockList, ',')[1]}
														<input type="hidden" name="category" value="${fn:split(stockList, ',')[1]}">
													</td>
													<td class="t3">
														${fn:split(stockList, ',')[2]}
														<input type="hidden" name="code" value="${fn:split(stockList, ',')[2]}">
													</td>
													<td class="t4">${fn:split(stockList, ',')[3]}</td>
													<td class="t5">
														<fmt:formatNumber type="number" maxFractionDigits="3" value="${fn:split(stockList, ',')[4]}" />
													</td>
													<td class="t6">
														<input type="text" name="stock" value="${fn:split(stockList, ',')[5]}">
													</td>
													<td class="t7">
														<button type="submit" name="button">수정</button>
													</td>
												</tr>
											</form>
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