<%@ page language="java" import="java.net.URLDecoder" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<header>
	<div class="headarea">
		<span class="logo" style="width: auto; height: auto; z-index: 11;"> <a href='<c:url value="../main/ms_main.jsp"/>'>IMPOS</a>
		</span>
		<div class="gnb">
			<ul>
				<li>
					<p>
						<c:if test="${empty name}">
							<c:redirect url="../manager/error.jsp" />
						</c:if>
						<c:if test="${not empty name}">
							<c:out value="${name}님" />
						</c:if>
					</p>
				</li>
				<li class="mypage"><a href='<c:url value="/manager/mypage.jsp" />'>마이페이지</a></li>
				<li class="logout"><a href='<c:url value="/manager/logout.jsp" />'>로그아웃</a></li>
			</ul>

		</div>
	</div>
</header>