<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="../ms_incl/ms_init.css">
<link rel="stylesheet" href="../ms_incl/ms_style.css">
<link rel="stylesheet" href="./css/purchase_style.css">

<title>무인카페 키오스크 시스템</title>
</head>
<body>
	<div class="wrap">
		<!-- header -->
		<%@ include file="/ms_incl/ms_purchase_header.jsp"%>
		<main id="main" style="width: auto; height: calc(100vh - 80px);">
			<div id="btn-box">
				<img src="./image/purchaseIcon.png" alt="purchaseIcon">
				<h2>무인카페 키오스크 시스템</h2>
				<h4>
					시스템을 시작하기 위해서 <br>하단의 시작 버튼을 눌러주세요.
				</h4>
				<form action="start_purchase.do" method="get">
					<input class="startbtn" type="submit" value="시작">
				</form>
			</div>
		</main>
	</div>
</body>
</html>