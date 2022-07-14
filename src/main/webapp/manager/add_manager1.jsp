<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>매니져 등록</title>
</head>
<body>
	<header> </header>
	<main>
		<div class="con">
			<h2>회원가입</h2>
			<form action="add_manager1" method="get">
				<h3>이름</h3>
				<input type="text" name="name"/><br>
				<h3>아이디</h3>
				<input type="text" name="userId"/><br>
				<h3>비밀번호</h3>
				<input type="password" name="passwd"/><br>
				<h3>지역</h3>
				<input type="text" name="area"/><br>
				<button type="submit" name="가입하기">가입하기</button>
			</form>
			<a href='<c:url value="/manager/login.jsp" />'>취소</a>
		</div>
	</main>
	<footer> </footer>
</body>
<style>
html, body {
	width: 100%;
	height: 100%;
}

a {
	color: black;
	text-decoration: none;
}

main {
	height: 100%;
	display: flex;
	justify-content: center;
	align-items: center;
}

input {
	width: 200px;
	height: 20px;
	margin-bottom: 10px;
}
</style>
</html>