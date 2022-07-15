<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
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
	<header>
		<div class="headarea">
			<span class="logo"> <a href='<c:url value="/purchase/start_purchase.jsp"/>'>IMPOS</a>
			</span>

		</div>
	</header>
	<main id="main">
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
</body>
</html>