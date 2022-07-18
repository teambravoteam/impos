<%@ page language="java" import="java.net.URLEncoder" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>IMPOS</title>
<link rel="stylesheet" href="../ms_incl/ms_init.css">
<link rel="stylesheet" href="../main/main_style.css">
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
					<div class="content-body">
						<div>
							<h1>IMPOS</h1>
							<span>아임포스! 무인점포 포스기 시스템</span>
						</div>
						<br>
						<div>
							<h2>상품관리</h2>
							<span>등록된 상품을 관리할 수 있습니다.</span>
						</div>
						<div>
							<h2>재고관리</h2>
							<span>현재 상품의 재고를 관리할 수 있습니다.</span>
						</div>
						<div>
							<h2>원재료관리</h2>
							<span>현재 원재료의 재고를 관리할 수 있습니다.</span>
						</div>
						<div>
							<h2>매출관리</h2>
							<span>점포의 매출 현황을 확인할 수 있습니다.</span>
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