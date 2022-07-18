<%@ page language="java" import="java.net.URLEncoder" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>IMPOS</title>
<link rel="stylesheet" href="../ms_incl/ms_init.css">
<link rel="stylesheet" href="./css/sale_style.css">
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
						<h2 class="title">매출관리</h2>
					</div>
					<div class="content-body">
						<div class="form-table">
							<table class="search-table">
								<tr>
									<th>전체보기</th>
									<td>
										<form action="find_AllSale.do" method="post">
											<button type="submit" name="button" class="findall">전체보기</button>
										</form>
									</td>
								</tr>
								<tr>
									<th>카테고리</th>
									<td>
										<form class="searchform" action="find_CategorySale.do" method="post">
											<select name="saCategory" class="category">
												<option value="coffee">coffee</option>
												<option value="cookie">cookie</option>
												<option value="cake">cake</option>
											</select>
											<button type="submit" name="button" class="searchbtn">검색</button>
										</form>
									</td>
								</tr>
								<tr>
									<th>날짜</th>
									<td>
										<form action="find_DateSale.do" method="post" id="saDateForm">
											연도 :
											<select name="saYear" form="saDateForm">
												<option value="all">전체</option>
												<option value="2020">2020년</option>
												<option value="2021">2021년</option>
												<option value="2022">2022년</option>
												<option value="2023">2023년</option>
											</select>
											월 :
											<select name="saMonth" form="saDateForm">
												<option value="all">전체</option>
												<option value="1">1월</option>
												<option value="2">2월</option>
												<option value="3">3월</option>
												<option value="4">4월</option>
												<option value="5">5월</option>
												<option value="6">6월</option>
												<option value="7">7월</option>
												<option value="8">8월</option>
												<option value="9">9월</option>
												<option value="10">10월</option>
												<option value="11">11월</option>
												<option value="12">12월</option>
											</select>
											일 :
											<select name="saDay" form="saDateForm">
												<option value="all">전체</option>
												<option value="1">1일</option>
												<option value="2">2일</option>
												<option value="3">3일</option>
												<option value="4">4일</option>
												<option value="5">5일</option>
												<option value="6">6일</option>
												<option value="7">7일</option>
												<option value="8">8일</option>
												<option value="9">9일</option>
												<option value="10">10일</option>
												<option value="11">11일</option>
												<option value="12">12일</option>
												<option value="13">13일</option>
												<option value="14">14일</option>
												<option value="15">15일</option>
												<option value="16">16일</option>
												<option value="17">17일</option>
												<option value="18">18일</option>
												<option value="19">19일</option>
												<option value="20">20일</option>
												<option value="21">21일</option>
												<option value="22">22일</option>
												<option value="23">23일</option>
												<option value="24">24일</option>
												<option value="25">25일</option>
												<option value="26">26일</option>
												<option value="27">27일</option>
												<option value="28">28일</option>
												<option value="29">29일</option>
												<option value="30">30일</option>
												<option value="31">31일</option>
											</select>

											<button type="submit" name="button" class="searchbtn">검색</button>
										</form>
									</td>
								</tr>
								<tr>
									<th>총 매출 금액</th>
									<td>0원</td>
								</tr>
							</table>
						</div>
						<div class="content-table">
							<table class="thead">
								<thead>
									<tr>
										<th class="t1">카테고리</th>
										<th class="t2">상품코드</th>
										<th class="t3">상품명</th>
										<th class="t4">가격</th>
										<th class="t5">갯수</th>
										<th class="t6">총 가격</th>
										<th class="t7">날짜</th>
									</tr>
								</thead>
							</table>
							<div class="tbl-content"></div>
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