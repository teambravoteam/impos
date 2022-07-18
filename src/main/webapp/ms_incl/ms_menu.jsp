<%@ page language="java" import="java.net.URLDecoder" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<link rel="stylesheet" href="./css/main_style.css">
<script type="text/javascript" src="../ms_incl/ms_js.js"></script>

<!-- 왼쪽 메뉴 영역 -->
<section id="snb">
	<nav class="nav">
		<ul class="left-menu" style="border: 0;">
			<li style="border-bottom: 2px solid #eaeef3;"><a id="productMenuA" href="#" style="background: #e1e7f0;" onclick="myFunc0()">상품관리</a>
				<ul class="productMenu" style="border-bottom: 0px;">
					<li class="submenu" style="border-bottom: 0px;"><a href="../product/add_product.jsp" style="background: #f2f4f7;">- 상품등록</a></li>
					<li class="submenu" style="border-bottom: 0px;"><a href="../product/find_product_list.jsp" style="background: #f2f4f7;">- 상품검색</a></li>
					<li class="submenu" style="border-bottom: 0px;"><a href="../product/edit_product.jsp" style="background: #f2f4f7;">- 상품 수정/삭제</a></li>
				</ul></li>
			<li style="border-bottom: 2px solid #eaeef3;"><a id="stockMenuA" href="#" style="background: #e1e7f0;" onclick="myFunc1()">재고관리</a>
				<ul class="stockMenu" style="border-bottom: 0px;">
					<li class="submenu" style="border-bottom: 0px;"><a href="../stock/find_stock_list.jsp" style="background: #f2f4f7;">- 재고검색</a></li>
					<li class="submenu" style="border-bottom: 0px;"><a href="../stock/edit_stock.jsp" style="background: #f2f4f7;">- 재고수정</a></li>
				</ul></li>
			<li style="border-bottom: 2px solid #eaeef3;"><a id="materialMenuA" href="#" style="background: #e1e7f0;" onclick="myFunc2()">원재료관리</a>
				<ul class="materialMenu" style="border-bottom: 0px;">
					<li class="submenu" style="border-bottom: 0px;"><a href="../material/find_material_list.jsp" style="background: #f2f4f7;">- 원재료검색</a></li>
					<li class="submenu" style="border-bottom: 0px;"><a href="../material/edit_material.jsp" style="background: #f2f4f7;">- 원재료수정</a></li>
				</ul></li>
				
				
			<li style="border-bottom: 2px solid #eaeef3;"><a href="../sale/find_sale_list.jsp" style="background: #e1e7f0;">매출관리</a></li>
		</ul>
	</nav>
</section>