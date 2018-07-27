<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
	<title>Welcome to Tesla</title>
	<meta name="viewport" content="width=device-width, initial-scale=1, user-scalable=no" />
	<meta name="description" content="" />
	<meta name="keywords" content="" />
	<link rel="stylesheet" href="css/tmsmain.css" />
	
	
	<style type="text/css">
		<link rel="stylesheet" href="css/style.css">
		div{
		padding: 10%;
		}
		li{
		
		padding: 5%;
		
		
		}
	</style>
</head>
<body>
	<header id="header">
		<a href="http://localhost/teslaProject/main.jsp" ><img src= "images/black2.jpg" ></a>
				
	</header>
	
	<c:if test="${sessionScope.cust_email == null}">
		<script>
			alert("로그인 후 이용가능합니다.");
			location.href='loginindex.html';
		</script>
	</c:if>


	<c:if test="${not empty sessionScope.cust_email}">
	 	<div id="icon"; style="position:  relative; right:  -20px; bottom: 100px;">
			<ul>
				
				<li ><p class="inline-block"><a href="http://localhost/teslaProject/replace.jsp" accesskey="1" title=""><img src = "images/eng2.png" ></a></li>
				<li ><p class="inline-block"><a href="http://localhost/teslaProject/replace.jsp" accesskey="2" title=""><img src = "images/trans2.png" ></a></li>
				<li><p class="inline-block"><a href="http://localhost/teslaProject/replace.jsp" accesskey="3" title=""><img src = "images/break2.png" ></a></li>
				<li><p class="inline-block"><a href="http://localhost/teslaProject/replace.jsp" accesskey="4" title=""><img src = "images/cool2.png" ></a></li>
				<li><p class="inline-block"><a href="http://localhost/teslaProject/replace.jsp" accesskey="5" title=""><img src = "images/bat2.png" ></a></li>
			
			</ul>
		</div>
		
			<div id="icon"; style="position:  relative; right:  -20px; bottom: 480px;">
			<ul>
			
				<li><p class="inline-block"><a href="http://localhost/teslaProject/replace.jsp" accesskey="1" title=""><img src = "images/eng2.png" ></a></li>
				<li><p class="inline-block"><a href="http://localhost/teslaProject/replace.jsp" accesskey="2" title=""><img src = "images/trans2.png" ></a></li>
				<li><p class="inline-block"><a href="http://localhost/teslaProject/replace.jsp" accesskey="3" title=""><img src = "images/break2.png" ></a></li>
				<li><p class="inline-block"><a href="http://localhost/teslaProject/replace.jsp" accesskey="4" title=""><img src = "images/cool2.png" ></a></li>
				<li><p class="inline-block"><a href="http://localhost/teslaProject/replace.jsp" accesskey="5" title=""><img src = "images/bat2.png" ></a></li>
			
			</ul>
		</div>
		
		
		<link href="https://fonts.googleapis.com/css?family=Raleway:400,300,600,800,900" rel="stylesheet" type="text/css">
		<div id="container"></div>
		
		<c:forEach items="${requestScope.myCompo}" var="data">
		${data.percent} %<br>
		</c:forEach>
		
		
		
		
		
	</c:if>
</body>
</html>