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
	<header>
		<div class="headarea">
			<span class="logo"> <a>IMPOS</a>
			</span>
		</div>
	</header>
	<div id="content-wrapper">
		<div class="con">
			<h2>필수 입력 정보를 입력해주세요.</h2>
			<c:if test="${not empty errorMsgs}">
				<ul>
					<c:forEach var="message" items="${errorMsgs}">
						<li class="ms"><c:out value="${message}" /></li>
					</c:forEach>
				</ul>
			</c:if>
		</div>
		<div class="bt">
			<a href='<c:url value="/manager/add_manager1.jsp" />'>돌아가기</a>
		</div>
		
	</div>
</body>
<style>
ul, li {
	list-style: none;
	margin: 0;
	padding: 0;
}

body {
	font-family: 'Nanum Gothic', sans-serif;
	padding: 0;
	margin: 0;
}

a {
	text-decoration: none;
}

/* header */
.headarea {
	width: 100%;
	height: 80px;
	background: #f2f2f2;
	z-index: 10;
}

.headarea .logo {
	display: block;
	position: absolute;
	left: 50%;
	transform: translateX(-50%);
	top: 20px;
	font-family: 'Secular One', sans-serif;
	font-size: 30px;
}

.headarea .logo a {
	color: #3f5ec4;
	font-weight: bold;
}

.headarea .gnb {
	position: relative;
	height: 60px;
	right: 30px;
}

/* main */
#content-wrapper {
	max-width: 400px;
	margin: 0 auto;
}

#content-wrapper .con {
	margin-top: calc(100% - 55%);
	text-align: center;
}

#content-wrapper .con .ms {
	color: red;
	margin-bottom: 20px;
}

#content-wrapper .bt {
	width: 100%;
	text-align: center;
	margin-top: 30px;
}

#content-wrapper .bt a {
	padding: 10px 40px;
	background: lightgrey;
	border: 1px solid gray;
	color: black;
	border-radius: 5px;
}

a:hover {
	background-color: grey;
	color: #fff;
}


</style>
</html>