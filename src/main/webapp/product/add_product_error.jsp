<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

<link rel="stylesheet" href="../ms_incl/ms_init.css">
<link rel="stylesheet" href="./css/product_style.css">

</head>
<body>
	<div class="wrap">
		<!-- header -->
		<%@ include file="/ms_incl/ms_header.jsp"%>
		<!-- main -->
		<main>
			<div id="container">
				<!-- 왼쪽 메뉴 영역 -->
				<%@ include file="/ms_incl/ms_menu.jsp"%>
				<!-- content영역 -->
				<div id="content">
					<c:if test="${not empty errorMsgs}">
						<h3>다음과 같은 에러가 발생했습니다.</h3>
						<ul>
							<c:forEach var="errorMsg" items="${errorMsgs}">
								<li>${errorMsg}</li>
							</c:forEach>
						</ul>
					</c:if>
					<jsp:useBean id="product" class="com.teambravo.impos.product.domain.Product" scope="request" />
					상품명 :
					<jsp:getProperty property="proName" name="product" /><br> 가격 :
					<jsp:getProperty property="proPrice" name="product" /><br>
					<button type="button" onclick="location.href='../product/add_product.jsp'">확인</button>
				</div>
			</div>
		</main>
		<!-- footer -->
		<%@ include file="/ms_incl/ms_footer.jsp"%>
	</div>
</body>
</html>