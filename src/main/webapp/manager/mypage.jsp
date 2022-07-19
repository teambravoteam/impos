<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="../ms_incl/ms_init.css">
<title>Insert title here</title>
</head>
<body>
	<div class="wrap">
		<header>
			<div class="headarea">
				<span class="logo"> <a
					href='<c:url value="/stock/FindAllStock"/>'>IMPOS</a>
				</span>
				<div class="gnb">
					<ul>
						<li class="logout"><a href='<c:url value="/main/ms_main.jsp" />'>돌아가기</a></li>			
						<li><a href='<c:url value="/manager/logout.jsp" />'>로그아웃</a></li>
					</ul>
				</div>
			</div>
		</header>

		<main id="container">
			<section id="snb">
				<nav class="nav">
					<ul class="left-menu">
						<li><a href="#">내정보</a></li>
					</ul>
				</nav>
			</section>
			<div id="content">
				<div class="con">
					<h1>마이페이지</h1>
				</div>
				<div class="content-body">
					<div class="form-table">
						<table class="search-table">
							<tr>
								<th>이름</th>
								<td><c:out value="${name}" /></td>
							</tr>
							<tr>
								<th>아이디</th>
								<td><c:out value="${userId}" /></td>
							<tr>
								<th>비밀번호</th>
								<td><c:out value="${passwd}" /></td>
							</tr>
							<tr>
								<th>지점명</th>
								<td><c:out value="${area}" /></td>
							</tr>
						</table>
					</div>
				</div>
			</div>
		</main>

	</div>

	<!-- wrap -->


</body>

<style>
body {
	font-family: 'Noto Sans KR', sans-serif;
}

.wrap {
	width: 100%;
	height: 100%;
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
	left: 50px;
	top: 20px;
	width: 60px;
	height: 30px;
	font-family: 'Secular One', sans-serif;
	font-size: 30px;
}

.headarea .logo a {
	color: #3f5ec4;
}

.headarea .gnb {
	position: relative;
	height: 60px;
	right: 30px;
}

.gnb ul {
	width: 100%;
	height: 80px;
	text-align: right;
	margin: 0 auto;
}

.gnb li {
	display: inline-block;
	height: 100%;
	margin-right: 20px;
}

.gnb li a {
	display: block;
	height: 80px;
	line-height: 80px;
	color: black;
	transition: .3s;
}

.gnb li a:hover {
	color: #4d6edb;
}

/* container */
main {
	display: block;
	height: calc(100vh - 130px);
}

#container {
	display: flex;
	height: calc(100vh - 80px - 50px); /*100% - header - footer*/
}

/* 왼쪽 메뉴 */
section#snb {
	flex: 250px;
	flex-shrink: 0;
	flex-grow: 0;
	box-sizing: border-box;
	background: #e1e7f0;
}

section#snb nav ul {
	border-bottom: 1px solid #d3d8dd;
}

section#snb nav ul li {
	border-bottom: 1px solid #eaeef3;
}

section#snb nav ul li a {
	color: #555;
	display: inline-block;
	width: 100%;
	line-height: 50px;
	font-size: 18px;
	box-sizing: border-box;
	padding-left: 50px;
}

/*content영역*/
#content {
	width: 100%;
	padding: 50px;
}

/* content table영역 */
table {
	width: 100%;
	border-collapse: collapse;
}

/* form table */
table.search-table {
	margin-top: 10px;
	border: 1px solid #bdbdbd;
}

table.search-table tr {
	border: 1px solid #bdbdbd;
}

table.search-table th {
	width: 20%;
	border-right: 1px solid #bdbdbd;
	padding: 10px 0;
	background: #f2f2f2;
}

table.search-table td {
	width: 80%;
	padding: 5px 10px;
}
</style>

</html>