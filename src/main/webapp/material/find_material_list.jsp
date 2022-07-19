<%@ page language="java" import="java.net.URLEncoder" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>IMPOS</title>
<link rel="stylesheet" href="../ms_incl/ms_init.css">
<link rel="stylesheet" href="./css/material_style.css">
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
						<h2 class="title">원재료검색</h2>
					</div>
					<div class="content-body">
						<div class="form-table">
							<table class="search-table">
								<tr>
									<th>전체보기</th>
									<td>
										<button type="button" name="button" class="findall">
											<a href='<c:url value="/material/find_all_material"/>'>전체보기</a>
										</button>
									</td>
								</tr>
								<form class="searchform" action="find_material" method="post">
									<tr>
										<th>검색어</th>
										<td>
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
										<th class="t2">재료명</th>
										<th class="t3">남은재료</th>
									</tr>
								</thead>
							</table>
							<div class="tbl-content">
								<table class="tbody">
									<tbody>
										<c:forEach var="materialList" items="${materialList}" varStatus="status">
											<tr>
												<td class="t1">${status.index + 1}</td>
												<td class="t2">${fn:split(materialList, ',')[0]}</td>
												<td class="t3">
													<fmt:formatNumber type="number" maxFractionDigits="3" value="${fn:split(materialList, ',')[1]}" />
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
