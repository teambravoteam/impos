<%@ page language="java" import="java.net.URLDecoder" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<style>
.headarea {
  width: 100%;
  height: 80px;
  background: grey;
  z-index: 10;
}

.headarea .logo {
  display: block;
  position: absolute;
  left: 50px;
  top: 20px;
  width: 60px;
  height: 30px;
  font-family: 'Secular One', sans-serif;
  font-size: 30px;
}

.headarea .logo a {
  color: black;
}


.headarea .gnb {
  position: relative;
  height: 60px;
}

.gnb ul {
  width: 100%;
  text-align: right;

  margin: 0 auto;
}
.gnb li {
  display: inline-block;
  margin-right: 20px;
}

.gnb li a {
  display: block;
  height: 60px;
  line-height: 60px;
  color: black;
}
</style>
<header>
      <div class="headarea">
        <span class="logo">
          <a href="#">IMPOS</a>
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