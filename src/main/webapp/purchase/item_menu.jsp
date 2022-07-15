<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">

<link rel="stylesheet" href="../ms_incl/ms_init.css">
<link rel="stylesheet" href="../ms_incl/ms_style.css">
<link rel="stylesheet" href="./css/purchase_style.css">

<script type="text/javascript" src="./js/jquery.js"></script>
<script type="text/javascript" src="./js/common.js"></script>
<title>Insert title here</title>
</head>
<body>

	<div id="wrap">
		<header>
			<div class="headarea">
				<span class="logo"> <a href='<c:url value="/purchase/start_purchase.jsp"/>'>IMPOS</a>
				</span>
			</div>
		</header>
		<main>
			<div id="container">
				<section id="snb">
					<nav class="nav">
						<ul class="left-menu">
							<li class="coffee-a"><a href="#">Coffee</a></li>
							<li class="cake-a"><a href="#">Cake</a></li>
							<li class="cookie-a"><a href="#">Cookie</a></li>
						</ul>
					</nav>
				</section>
				<div id="content">
					<div class="items-wrap coffee-me">
						<c:forEach var="proItem" items="${coffeeList}">
							<div class="items">
								<img src="./image/${proItem.proName}.jpg">
								<form action="addItem.do" method="get" id="addItemForm">
									<input type="text" class="proName" name="proName" value="${proItem.proName}" readonly />
									<input type="text" class="proCate" name="proCate" value="${proItem.proCategory}" readonly />
									<select class="proCount" name="proCount" form="addItemForm">
										<option value="1">1개</option>
										<option value="2">2개</option>
										<option value="3">3개</option>
										<option value="4">4개</option>
										<option value="5">5개</option>
										<option value="6">6개</option>
										<option value="7">7개</option>
										<option value="8">8개</option>
										<option value="9">9개</option>
										<option value="10">10개</option>
									</select>
									<input class="proSubmit" type="submit" value="장바구니 넣기">
								</form>

							</div>
						</c:forEach>
					</div>

					<div class="items-wrap cake-me">
						<c:forEach var="proItem" items="${cakeList}">
							<div class="items">
								<img src="./image/${proItem.proName}.jpg">
								<form action="addItem.do" method="get">
									<input type="text" class="proName" name="proName" value="${proItem.proName}" readonly />
									<input type="text" class="proCate" name="proCate" value="${proItem.proCategory}" readonly />
									<input type="text" class="proCount" name="proCount">
									<input type="submit" value="장바구니 넣기">
								</form>

							</div>
						</c:forEach>
					</div>

					<div class="items-wrap cookie-me">
						<c:forEach var="proItem" items="${cookieList}">
							<div class="items">
								<img src="./image/${proItem.proName}.jpg">
								<form action="addItem.do" method="get">
									<input type="text" class="proName" name="proName" value="${proItem.proName}" readonly />
									<input type="text" class="proCate" name="proCate" value="${proItem.proCategory}" readonly />
									<input type="text" class="proCount" name="proCount">
									<input type="submit" value="장바구니 넣기">
								</form>
							</div>
						</c:forEach>
					</div>
				</div>
				<div id="cart">
					<form action="purchase_item.do" method="get">
						보유 자산:
						<input type="text" name="money" value="0">
						<input type="submit" value="구매하기">
						<ul>
							<c:forEach var="menuList" items="${cart.cartList}" varStatus="status">
								<li>이름: <input type="text" value="${menuList.getProduct().proName}" name="proName${status.count}"> 카테고리: <input type="text" value="${menuList.getProduct().proCategory}" name="proCate${status.count}"> 가격: <input type="text" value="${menuList.getProduct().proPrice}" name="proPrice${status.count}"> 갯수: <input type="text" value="${menuList.count}" name="proCount${status.count}">
								</li>
							</c:forEach>
						</ul>
					</form>

				</div>


			</div>
		</main>
	</div>

</body>
</html>