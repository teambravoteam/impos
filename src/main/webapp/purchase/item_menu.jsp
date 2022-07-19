<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">


<link rel="stylesheet" href="../ms_incl/ms_init.css">
<link rel="stylesheet" href="../ms_incl/ms_style.css">
<link rel="stylesheet" href="./css/purchase_style.css">

<script type="text/javascript" src="./js/jquery.js"></script>
<script type="text/javascript" src="./js/common.js"></script>
<title>메뉴 선택</title>
</head>
<body>
	<div class="wrap">
		<!-- header -->
		<%@ include file="/ms_incl/ms_purchase_header.jsp"%>
		<main style="height: 100vh">
			<div id="container">
				<section id="snb" style="position: fixed; top: 80px; bottom: 0; left: 0; right: calc(100% - 250px);">
					<nav class="nav">
						<ul class="left-menu" style="margin-top: 0px;">
							<li class="coffee-a"><a href="#">Coffee</a></li>
							<li class="cake-a"><a href="#">Cake</a></li>
							<li class="cookie-a"><a href="#">Cookie</a></li>
						</ul>
					</nav>
				</section>

				<div id="content-wrap" style="overflow-x: hidden;">
					<div id="content" style="margin-top: 80px; margin-left: 300px; padding-bottom: 450px;">
						<div class="items-wrap coffee-me close">
							<c:forEach var="proItem" items="${coffeeList}">
								<div class="items">
									<img src="./image/${proItem.proImage}">
									<form action="addItem.do" method="get" id="addItemForm">
										<input type="text" class="proName" name="proName" value="${proItem.proName}" readonly />
										<input type="text" class="proCate" name="proCate" value="${proItem.proCategory}" readonly />
										<input type="text" class="proPrice" name="proPrice" value="<fmt:formatNumber type="number" maxFractionDigits="3" value="${proItem.proPrice}" />원" readonly />
										<input type="number" class="proCount" name="proCount" placeholder="갯수" min="1" max="50" required/>
										<input class="proSubmit" type="submit" value="장바구니 넣기">
									</form>
								</div>
							</c:forEach>
						</div>
						<div class="items-wrap cake-me close">
							<c:forEach var="proItem" items="${cakeList}">
								<div class="items">
									<img src="./image/${proItem.proImage}">
									<form action="addItem.do" method="get" id="addItemForm">
										<input type="text" class="proName" name="proName" value="${proItem.proName}" readonly />
										<input type="text" class="proCate" name="proCate" value="${proItem.proCategory}" readonly />
										<input type="text" class="proPrice" name="proPrice" value="<fmt:formatNumber type="number" maxFractionDigits="3" value="${proItem.proPrice}" />원" readonly />
										<input type="number" class="proCount" name="proCount" placeholder="갯수" min="1" max="50" required/>
										<input class="proSubmit" type="submit" value="장바구니 넣기">
									</form>

								</div>
							</c:forEach>
						</div>

						<div class="items-wrap cookie-me close">
							<c:forEach var="proItem" items="${cookieList}">
								<div class="items">
									<img src="./image/${proItem.proImage}">
									<form action="addItem.do" method="get" id="addItemForm">
										<input type="text" class="proName" name="proName" value="${proItem.proName}" readonly />
										<input type="text" class="proCate" name="proCate" value="${proItem.proCategory}" readonly />
										<input type="text" class="proPrice" name="proPrice" value="<fmt:formatNumber type="number" maxFractionDigits="3" value="${proItem.proPrice}" />원" readonly />
										<input type="number" class="proCount" name="proCount" placeholder="갯수" min="1" max="50" required/>
										<input class="proSubmit" type="submit" value="장바구니 넣기">
									</form>

								</div>
							</c:forEach>
						</div>
					</div>
					<div id="cart">
						<form action="purchase_item.do" method="get">
							보유 자산:
							<input type="number" name="money" min="1" max="10000000" required>
							<input type="submit" value="구매하기">
							<ul>
								<c:set var="total" value="0" />
								<c:forEach var="menuList" items="${cart.cartList}" varStatus="status">
									<li>이름: <input type="text" value="${menuList.getProduct().proName}" name="proName${status.count}"> 카테고리: <input type="text" value="${menuList.getProduct().proCategory}" name="proCate${status.count}"> 가격: <input type="text" value="<fmt:formatNumber type="number" maxFractionDigits="3" value="${menuList.getProduct().proPrice}" />원" name="proPrice${status.count}"> 갯수: <input type="text" value="${menuList.count}" name="proCount${status.count}">
									</li>
									<c:set var="total" value="${total + menuList.getProduct().proPrice * menuList.getCount()}" />
								</c:forEach>
								<li><strong>총 금액 : <fmt:formatNumber type="number" maxFractionDigits="3" value="${total}" />원
								</strong></li>
							</ul>
							<br>
						</form>
						<form action="minus_item.do" method="get">
							<input type="submit" name="cleanitem" value="삭제하기">
						</form>
					</div>
				</div>
			</div>
		</main>
	</div>

</body>
</html>