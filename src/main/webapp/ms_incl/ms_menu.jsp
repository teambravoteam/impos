<%@ page language="java" import="java.net.URLDecoder"
	contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!-- 왼쪽 메뉴 영역 -->
        <section id="snb">
          <nav class="nav">
            <ul class="left-menu">
              <li><a href="../product/find_product_list.jsp">상품관리</a></li>
              <li class="submenu"><a href="../product/find_product_list.jsp">-상품검색</a></li>
              <li class="submenu"><a href="../product/add_product.jsp">-상품등록</a></li>
              <li><a href="../stock/find_stock_list.jsp">재고관리</a></li>
              <li class="submenu"><a href="../stock/find_stock_list.jsp">-재고검색</a></li>
              <li class="submenu"><a href="../stock/edit_stock.jsp" class="submenu">-재고수정</a></li>
              <li><a href="../material/find_material_list.jsp">원재료관리</a></li>
              <li class="submenu"><a href="../material/find_material_list.jsp" class="submenu">-원재료검색</a></li>
              <li class="submenu"><a href="../material/edit_material.jsp" class="submenu">-원재료수정</a></li>
              <li><a href="#">매출관리</a></li>
            </ul>
          </nav>
        </section>