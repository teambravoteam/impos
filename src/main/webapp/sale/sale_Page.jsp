<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@page import="java.net.URLEncoder"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<div id="wrapper">
		<div id="header"></div>
		<h3>총 매출 현황</h3>
		<form action="find_AllSale.do" method="post">
			<p>
				<input type="submit" value="총 매출 현황">
			</p>
		</form>

		<h3>카테고리 별 매출 현황</h3>
		<form action="find_CategorySale.do" method="post" id="saCategoryForm">
			<select name="saCategory" form="saCategoryForm">
				<option value="커피">커피</option>
				<option value="쿠키">쿠키</option>
				<option value="케이크">케이크</option>
			</select>
			<input type="submit">
		</form>

		<h3>연도 별 매출 현황</h3>
		<form action="find_YearSale.do" method="post" id="saYearForm">
			<select name="saYear" form="saYearForm">
				<option value="2020">2020년</option>
				<option value="2021">2021년</option>
				<option value="2022">2022년</option>
				<option value="2023">2023년</option>
			</select>
			<input type="submit">
		</form>

		<h3>월 별 매출 현황</h3>
		<form action="find_MonthSale.do" method="post" id="saMonthForm">
			<select name="saMonth" form="saMonthForm">
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
			<input type="submit">
		</form>

		<h3>일 별 매출 현황</h3>
		<form action="find_DaySale.do" method="post" id="saDayForm">
			<select name="saDay" form="saDayForm">
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
			<input type="submit">
		</form>

		<h3>날짜 별 매출 현황</h3>
		<form action="find_DateSale.do" method="post" id="saDateForm">
			연도 :
			<select name="saYear" form="saDateForm">
				<option value="2020">2020년</option>
				<option value="2021">2021년</option>
				<option value="2022">2022년</option>
				<option value="2023">2023년</option>
			</select>

			월 :
			<select name="saMonth" form="saDateForm">
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
			<input type="submit">
		</form>
		<div id="footer"></div>
	</div>
</body>
</html>