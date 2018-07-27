<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Tesla</title>

<meta name="viewport" content="width=device-width, initial-scale=1, user-scalable=no" />
		<meta name="description" content="" />
		<meta name="keywords" content="" />
		<link rel="stylesheet" href="css/tmsmain.css" />
		<style type="text/css">
		
</style>
</head>
<body>

<div id="header-wrapper">
	<div id="header" class="container">
	
		<div id="logo">
			<c:if test="${sessionScope.cust_email != null}">
				<a href="http://localhost/teslaProject/main.jsp" ><img src= "images/black2.jpg" ></a>
		</c:if>	
		<c:if test="${sessionScope.cust_email == null}">
				<a href="http://localhost/teslaProject/index.html" ><img src= "images/black2.jpg" ></a>
		</c:if>
		</div>
		<div id="menu">
			<ul>
				<li><a href="#" accesskey="1" title="">NEWS</a></li>
				<li><a href="#" accesskey="2" title="">CHARGING</a></li>
				<li><a href="${pageContext.request.contextPath}/cont?command=myPage" accesskey="3" title="">MY PAGE</a></li>
				<li><a href="${pageContext.request.contextPath}/cont?command=allCompoState" >TMS</a></li>
				<li><a href="${pageContext.request.contextPath}/cont?command=logout">LOGOUT</a></li>
			</ul>
		</div>
	</div>
</div>
	
		
	
	
	
	
	<c:if test="${sessionScope.cust_email == null}">
		<script>
			alert("로그인 후 이용가능합니다.");
			location.href='loginindex.html';
		</script>
	</c:if>


	<c:if test="${not empty sessionScope.cust_email}">
	
	 	<div class="bigcontainer">
	 	 <div class="container2">
			<ul>
												<!-- 배터리, 냉각수, 오토미션오일,브레이크 오일, 엔진오일 -->
				<li><p class="inline-block"><a href="http://localhost/teslaProject/replace.jsp"><img src = "images/bat2.png" width=75% ></a></li>
				<li><p class="inline-block"><a href="http://localhost/teslaProject/replace.jsp"><img src = "images/cool2.png" width=75% ></a></li>
				<li><p class="inline-block"><a href="http://localhost/teslaProject/replace.jsp"><img src = "images/trans2.png" width=75% ></a></li>
				<li><p class="inline-block"><a href="http://localhost/teslaProject/replace.jsp"><img src = "images/break2.png" width=75%></a></li>
				<li><p class="inline-block"><a href="http://localhost/teslaProject/replace.jsp"><img src = "images/eng2.png"width=75% ></a></li>
			
			</ul>
			</div>
		
		<div id="container"></div>
		<div class="container">
			<ul>
			<c:forEach items="${requestScope.myCompo}" var="data">
				<li><div><p class="box"><div class="chart" data-percent="${data.percent}">${data.percent}%</div></li>
			</c:forEach>
			</ul>
			</div>
			
			
	
	</c:if>
	<script src="https://code.jquery.com/jquery-3.3.1.js"></script>
	<script src="jquery.easypiechart.js"></script>
	<script>
    $(function() {
        $('.chart').easyPieChart({
			
        });
    });
</script>
</body>
</html>