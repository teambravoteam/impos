<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@page import="java.util.List"%>
<%@page import="java.net.URLEncoder"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Error</title>
</head>
<body>
	<div id="wrapper">
		<div id="header"></div>
		<div id="content-wrapper">
			<h2>ERROR! 필수 입력 정보를 입력해주세요.</h2>
			<c:if test="${not empty errorMsgs}">
				<ul>
					<c:forEach var="message" items="${errorMsgs}">
						<li><c:out value="${message}" /></li>
					</c:forEach>
				</ul>
			</c:if>
		</div>
		<div id="footer"></div>
	</div>
</body>
</html>