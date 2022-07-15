<%@ page language="java" import="java.net.URLDecoder" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<header>
	<div class="headarea">
		<a class="logo" href='<c:url value="/main/ms_main.jsp"/>'>
			<span>IMPOS</span>
		</a>
		<div class="gnb">
			<ul>
				<li>
					<p>OOO님</p>
				</li>
				<li class="mypage"><a href="#">MY PAGE</a></li>
				<li class="logout"><a href="#">로그아웃</a></li>
			</ul>

		</div>
	</div>
</header>