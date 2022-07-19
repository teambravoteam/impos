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
	<header>
		<div class="headarea">
			<span class="logo"> 
			<a>IMPOS</a>
			</span>
		</div>
	</header>
	<div id="wrap">
		<div id="content-wrapper">
			<div class="title">회원가입</div>
			<form action="add_manager1" method="get">
				<ul>
					<li><p>아이디</p>
						<input type="text" name="userId" value="<c:out value="${userId}"/>" /><button type="submit" name="checkId" value="checkId">중복체크</button>
					</li>
						<div><c:out value="${check}" /></div>
					<li><p>비밀번호</p>
						<input type="password" name="passwd"></li>
					<li><p>이름</p>
						<input type="text" name="name"></li>
					<li><p>지점명</p>
						<input type="text" name="area"></li>
					<li>
						<button type="submit" name="checkId" value="all">확인</button>
					</li>
					<li><a href='<c:url value="/manager/login.jsp" />'>취소</a></li>
				</ul>
			</form>
		</div>
	</div>
	
</body>
<style>
@import url('https://fonts.googleapis.com/css2?family=Nanum+Gothic:wght@400;700;800&display=swap');

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



#banner {
	width: 100%;
	height: 60px;
	display: flex;
	justify-content: center;
	align-items: center;
	margin-bottom: 15px;
}

#banner a {
	text-decoration: none;
	width: 25%;
	text-align: center;
	font-size: 20px;
	color: black;
	transiton: .3s;
}

#banner a:hover {
	color: grey;
}

ul, li {
	list-style: none;
	margin: 0;
	padding: 0;
}

#wrap ul li:nth-child(7) {
	text-align: center;
	margin-top: 20px;
}

#wrap ul li:nth-child(7) a {
	color: black;
}

#wrap {
	max-width: 400px;
	margin: 0 auto;
}

#wrap #content-wrapper {
	margin-top: calc( 100% - 55%);
}

#wrap .title {
	text-align: center;
	font-size: 35px;
}
#content-wrapper .title {
	margin-bottom: 35px;
}

#wrap ul li:nth-child(1) input {
	width: 80%;
}


input {
	width: 100%;
	height: 40px;
	background-color: #f1f1f1;
	border: 1px solid #fff;
	box-sizing: border-box;
	padding: 10px 14px 10px 14px;
	transition: .3s;
}

input:hover {
	box-sizing: border-box;
	border: 1px solid grey;
}

input:focus {
	outline: none;
	border: 1px solid #3f5ec4;
	box-sizing: border-box;
}

input.email {
	width: 65%;
}

input.addr {
	width: 86%;
}



li span {
	margin-left: 3px;
	margin-right: 3px;
}

li select {
	padding: 10px 14px 10px 14px;
	margin: 0;
}

li p {
	font-weight: bold;
}

button {
	background-color: lightgrey;
	text-align: center;
	border: 1px solid grey;
	height: 40px;
	width: 100%;
	font-size: 15px;
	margin-top: 30px;
	transition: .3s;
	border-radius: 5px;
}


#wrap ul li:nth-child(1) button {
	height: 39px;
	width: calc( 100% - 80% );
}
button:hover {
	background-color: grey;	
	color: #fff;
}


</style>


<script type="text/javascript">
  function mySubmit(index) {
    if (index == 1) {
      document.myForm.action='ok1.html';
    }
    if (index == 2) {
      document.myForm.action='ok2.html';
    }
    document.myForm.submit();
  }
</script>


</html>