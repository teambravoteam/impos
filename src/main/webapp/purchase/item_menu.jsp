<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>  
 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">

<link rel="stylesheet" href="../ms_incl/ms_init.css">
<link rel="stylesheet" href="../ms_incl/ms_style.css">
<link rel="stylesheet" href="./css/purchase_style.css">

<script type="text/javascript" src="./js/jquery.js"></script>
<script type="text/javascript" src="./js/common.js"></script>
<title>Insert title here</title>
</head>
<body>

<div id="wrap">
<header>
      <div class="headarea">
        <span class="logo">
          <a href=''>IMPOS</a>
        </span>    
      </div>
</header>
	<main>
		<div id="container">
		 <section id="snb">
          <nav class="nav">
            <ul class="left-menu">
              <li class="coffee-a"><a href="#" >Coffee</a></li>
              <li class="cake-a"><a href="#" >Cake</a></li>
              <li class="cookie-a"><a href="#" >Cookie</a></li>              
            </ul>
          </nav>
        </section>
        <div id="content">
        <div class="items-wrap coffee-me">
        	<c:forEach var="proItem" items="${coffeeList}">
        		<div class="items">
        		 <img src="./image/${proItem.proName}.jpg">
        		 <form action="addItem.do" method="get">
        		 	<input type="text" name="proName" value="${proItem.proName}">
        		 	<input type="text" name="proCate" value="${proItem.proCategory}">
        		 	<input type="text" name="proCount" value=>
        		 	<input type="submit" value="ㅇㅋ">
        		 </form>
        			<p>${proItem.proName}</p>
        			<p>${proItem.proPrice}</p>
        			<input type="text" name="proCount"> 
        			<button class="cart-btn">구입하기</button>
        			       		
        		</div>       	
        	</c:forEach>
        </div>  
        
        <div class="items-wrap cake-me">
        	<c:forEach var="proItem" items="${cakeList}">
        		<div class="items">
        		 <img src="./image/${proItem.proName}.jpg">
        		  	<form action="addItem.do" method="get">
        		 	<input type="text" name="proName" value="${proItem.proName}">
        		 	<input type="text" name="proCate" value="${proItem.proCategory}">
        		 	<input type="text" name="proCount">
        		 	<input type="submit" value="ㅇㅋ">
        		 	</form>
        			<p>${proItem.proName}</p>
        			<p>${proItem.proPrice}</p> 
        			<button class="cart-btn">구입하기</button>       		
        		</div>       	
        	</c:forEach>
        </div>   
        
        <div class="items-wrap cookie-me">
        	<c:forEach var="proItem" items="${cookieList}">
        		<div class="items">
        		 <img src="./image/${proItem.proName}.jpg">
        			<p>${proItem.proName}</p>
        			<p>${proItem.proPrice}</p> 
        			<button class="cart-btn">구입하기</button>       		
        		</div>       	
        	</c:forEach>
        </div>    
        </div>
        <div id="cart">
    	<form action="purchase_item.do" method= "get">
    		<ul>
    			<c:forEach var="menuList" items="${cart.cartList}" varStatus="status">    				
    				<li>
    					이름: <input type="text" value="${menuList.getProduct().proName}" name="proName${status.count}">
    					카테: <input type="text" value="${menuList.getProduct().proCategory}" name="proCate${status.count}">
    					가격: <input type="text" value= "${menuList.getProduct().proPrice}" name="proPrice${status.count}">
    				    갯수: <input type="text" value= "${menuList.count}" name="proCount${status.count}">    				       				 
    				</li>
    			</c:forEach>    			
    		</ul>
    		넣으실 돈: <input type="text" name="money">
    		<input type="submit" value="구매하기">    	
    	</form>
     
    </div>
        
        
		</div>
	</main>
</div>  
 
</body>
</html>