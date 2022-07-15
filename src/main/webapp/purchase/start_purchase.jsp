<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="../ms_incl/ms_init.css">
<link rel="stylesheet" href="../ms_incl/ms_style.css">
<link rel="stylesheet" href="./css/purchase_style.css">

<title>Insert title here</title>
</head>
<body>
<header>
      <div class="headarea">
        <span class="logo">
          <a href='<c:url value="/stock/FindAllStock"/>'>IMPOS</a>
        </span>
  
      </div>
</header>
  <main id="main">
    <div id="btn-box">    
      <img src="./image/purchaseIcon.png" alt="purchaseIcon">
      <form action="start_purchase.do" method="get">
        <input class="startbtn" type="submit" value="시작하기">
      </form>
    </div>
  </main>
</body>
</html>