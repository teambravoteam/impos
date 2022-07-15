<%@ page language="java" import="java.net.URLDecoder" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<header>
      <div class="headarea">
        <span class="logo">
          <a href='<c:url value="/stock/FindAllStock"/>'>IMPOS</a>
        </span>
        <div class="gnb">
          <ul>
            <li>
              <p>OOO님</p>
            </li>
            <li class="mypage">
              <a href="#">MY PAGE</a>
            </li>
            <li class="logout">
              <a href="#">로그아웃</a>
            </li>
          </ul>

        </div>
      </div>
</header>