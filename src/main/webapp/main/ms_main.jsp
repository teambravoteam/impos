<%@ page language="java" import="java.net.URLEncoder" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>IMPOS</title>
<link rel="stylesheet" href="../ms_incl/ms_init.css">
<link rel="stylesheet" href="./css/main_style.css">
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
						<h1><span>IMPOS</span> 무인점포 포스기 시스템</h1>
					</div>
				</div>
			</div>

		</main>

		<!-- footer -->
		<%@ include file="/ms_incl/ms_footer.jsp"%>
	</div>

</body>

</html>