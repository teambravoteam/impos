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
  	<h3> 결제에 실패하셨습니다 </h3>
  	<h3> 고객님의 해당 잔금은 ${balance} 입니다 구입 감사합니다</h3>
    <div id="btn-box">    
      <img src="./image/purchaseIcon.png" alt="purchaseIcon">
      <form action="restart_purchase.do" method="get">
        <input class="startbtn" type="submit" value="잔금반환">
      </form>
    </div>
  </main>
</body>
</html>