<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@page import="java.net.URLEncoder"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
  <form action="add_product" method="post">
    <table>
      <tr>
        <td>카테고리목록</td>
        <td>
          <div class="input-group">
            <select class="procategory" name="procategory">
              <option value="coffee">coffee</option>
              <option value="cake">cake</option>
              <option value="cookie">cookie</option>
             </select>
          </div>
        </td>
      </tr>
      <tr>
        <td>상품명</td>
        <td><input type="text" class="proname" name="proname" size="10"></td>
      </tr>
      <tr>
        <td>가격</td>
        <td><input type="number" class="proprice" name="proprice" size="10"></td>
      </tr>
      <tr>
        <td>상품이미지</td>
        <td><input type="file" class="proimg" name="proimg" size="10"></td>
      </tr>
      <tr>
        <td colspan="2">
          <button type="button" name="">취소</button>
          <button type="submit" name="">저장</button>
          <button type="button" name="">목록</button>
        </td>
      </tr>
    </table>
  </form>
</body>
</html>