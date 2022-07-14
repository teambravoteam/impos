<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>로그인 페이지</h1>
	<main>
		<div class="con">
			<h2>로그인</h2>
			<form action="login" method="post">
				<h3>아이디</h3>
				<input type="text" name="userId"/><br>
				<h3>비밀번호</h3>
				<input type="password" name="passwd"><br>
				<button type="submit" name="로그인">로그인</button>
			</form>
			<a href='<c:url value="/manager/add_manager1.jsp" />'>가입하기</a>
		</div>
	</main>
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