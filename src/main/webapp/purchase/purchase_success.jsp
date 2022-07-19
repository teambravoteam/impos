<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="../ms_incl/ms_init.css">
<link rel="stylesheet" href="../ms_incl/ms_style.css">
<link rel="stylesheet" href="./css/purchase_style.css">

<title>Insert title here</title>
</head>
<body>
	<div class="wrap">
		<!-- header -->
		<%@ include file="/ms_incl/ms_purchase_header.jsp"%>
		<main id="main">
			<h2>결제 성공!</h2>
			<h3>
				고객님의 해당 잔금은
				<fmt:formatNumber type="number" maxFractionDigits="3" value="${balance}" />원 
				입니다 구입 감사합니다, 처음으로 돌아갑니다.
			</h3>
			<div id="btn-box">
				<img src="./image/purchaseIcon.png" alt="purchaseIcon">
				<h4>
					시작 페이지로 돌아가기 위해서 <br>하단의 잔금반환 버튼을 눌러주세요.
				</h4>
				<form action="restart_purchase.do" method="get">
					<input class="startbtn" type="submit" value="잔금반환">
				</form>
			</div>
		</main>
	</div>
</body>
</html>