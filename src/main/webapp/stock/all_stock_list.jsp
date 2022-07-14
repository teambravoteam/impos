<%@ page language="java" import="java.net.URLEncoder" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
재고목록<br>
	<a href='<c:url value="/stock/FindAllStock"/>'>재고목록 불러오기</a>
	<c:forEach var="stockList" items="${stockList}">
		<p>${stockList}</p>
	</c:forEach>
</body>
</html>