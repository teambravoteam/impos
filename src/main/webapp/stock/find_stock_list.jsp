<%@ page language="java" import="java.net.URLEncoder"
	contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>IMPOS</title>
<link rel="stylesheet" href="../ms_incl/ms_init.css">
<link rel="stylesheet" href="./css/stock_style.css">
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
          <div class="content-info">
            <h2 class="title">재고검색</h2>
          </div>
          <div class="content-body">
            <div class="form-table">
                <table class="search-table">
                  <tr>
                    <th>전체보기</th>
                    <td>
                      <button type="button" name="button" class="findall">
                        <a href="#">전체보기</a>
                      </button>
                    </td>
                  </tr>
             	 <form class="searchform" action="/stock/find_stock" method="post">
                  <tr>
                    <th>카테고리</th>
                    <td>
                      <select name="category" class="category">
                        <option value="all">전체</option>
                        <option value="coffee">coffee</option>
                        <option value="cookie">cookie</option>
                        <option value="cake">cake</option>
                      </select>
                    </td>
                  </tr>
                  <tr>
                    <th>검색어</th>
                    <td>
                      <select name="findtype" class="findtype">
                        <option value="all">전체</option>
                        <option value="name">상품이름</option>
                        <option value="code">상품코드</option>
                      </select>
                      <input type="text" name="search" class="searchinput">
                      <button type="submit" name="button" class="searchbtn">검색</button>
                    </td>
                  </tr>
             	 </form>
                </table>
            </div>
            <div class="content-table">
              <table class="thead">
                <thead>
                  <tr>
                    <th class="t1">id</th>
                    <th class="t2">카테고리</th>
                    <th class="t3">상품코드</th>
                    <th class="t4">상품명</th>
                    <th class="t5">가격</th>
                    <th class="t6">재고</th>
                  </tr>
                </thead>
              </table>
              <div class="tbl-content">
                <table class="tbody">
                  <tbody>
                      <tr>
                        <td class="t1">1</td>
                        <td class="t2">2</td>
                        <td class="t3">3</td>
                        <td class="t4">4</td>
                        <td class="t5">5</td>
                        <td class="t6">6</td>
                      </tr>
                      <tr>
                        <td class="t1">1</td>
                        <td class="t2">2</td>
                        <td class="t3">3</td>
                        <td class="t4">4</td>
                        <td class="t5">5</td>
                        <td class="t6">6</td>
                      </tr>
                      <tr>
                        <td class="t1">1</td>
                        <td class="t2">2</td>
                        <td class="t3">3</td>
                        <td class="t4">4</td>
                        <td class="t5">5</td>
                        <td class="t6">6</td>
                      </tr>
                  </tbody>
                </table>
              </div>
            </div>
          </div>
        </div>
      </div>

    </main>
	
    <!-- footer -->
		<%@ include file="/ms_incl/ms_footer.jsp"%>
	</div>

</body>

</html>