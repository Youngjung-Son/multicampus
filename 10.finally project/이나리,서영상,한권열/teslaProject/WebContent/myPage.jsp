<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>my Page</title>
<meta name="keywords" content="" />
<meta name="description" content="" />
<link href="http://fonts.googleapis.com/css?family=Source+Sans+Pro:200,300,400,600,700,900" rel="stylesheet" />
<link href="default.css" rel="stylesheet" type="text/css" media="all" />
<link href="fonts.css" rel="stylesheet" type="text/css" media="all" />
<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">

<style>
.mySlides {display:none}
h2,p{color: white;}
</style>

</head>
<body>
<div id="header-wrapper">
	<div id="header" class="container">
		<div id="logo">
			<a href="main.jsp"><img src= "images/logo.png" ></a>
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
	<c:if test="${requestScope.myInfo.modelName == '2016 Model X' || requestScope.myInfo.modelName == '2017 Model X'}">
	<div class="w3-container">

<h2 class="h2">내 차량 정보</h2>
<div class="w3-row-padding" style="margin:0 -16px">
  <div class="w3-col s4">
    <img src="images/modelx1.jpg" style="width:100%;cursor:pointer"
    onclick="openModal();currentDiv(1)" class="w3-hover-shadow">
  </div>
  <div class="w3-col s4">
    <img src="images/modelx2.jpg" style="width:100%;cursor:pointer"
    onclick="openModal();currentDiv(2)" class="w3-hover-shadow">
  </div>
  <div class="w3-col s4">
    <img src="images/modelx3.jpg" style="width:100%;cursor:pointer"
    onclick="openModal();currentDiv(3)" class="w3-hover-shadow">
  </div>
</div>

<div id="myModal" class="w3-modal w3-black">
 <span class="w3-text-white w3-xxlarge w3-hover-text-grey w3-container w3-display-topright" onclick="closeModal()" style="cursor:pointer">×</span>
 <div class="w3-modal-content">

  <div class="w3-content" style="max-width:1200px">
   <img class="mySlides" src="images/modelx1.jpg" style="width:100%">
   <img class="mySlides" src="images/modelx2.jpg" style="width:100%">
   <img class="mySlides" src="images/modelx3.jpg" style="width:100%">
   <div class="w3-row w3-black w3-center">
    <div class="w3-display-container">
     <p id="caption"></p>
     <span class="w3-display-left w3-btn" onclick="plusDivs(-1)">←</span>
     <span class="w3-display-right w3-btn" onclick="plusDivs(1)">→</span>
    </div>
    <div class="w3-col s4">
     <img class="demo w3-opacity w3-hover-opacity-off" src="images/modelx1.jpg" style="width:100%" onclick="currentDiv(1)" alt="Model X">
    </div>
    <div class="w3-col s4">
     <img class="demo w3-opacity w3-hover-opacity-off" src="images/modelx2.jpg" style="width:100%" onclick="currentDiv(2)" alt="Model X">
    </div>
    <div class="w3-col s4">
     <img class="demo w3-opacity w3-hover-opacity-off" src="images/modelx3.jpg" style="width:100%" onclick="currentDiv(3)" alt="Model X">
    </div>
   </div> <!-- End row -->
  </div> <!-- End w3-content -->
  
 </div> <!-- End modal content -->
</div> <!-- End modal -->

</div>
</c:if>


<c:if test="${requestScope.myInfo.modelName == '2017 Model S' || requestScope.myInfo.modelName == '2016 Model S'}">
	<div class="w3-container">

<h2>내 차량 정보</h2>
<div class="w3-row-padding" style="margin:0 -16px">
  <div class="w3-col s4">
    <img src="images/models1.jpg" style="width:100%;cursor:pointer"
    onclick="openModal();currentDiv(1)" class="w3-hover-shadow">
  </div>
  <div class="w3-col s4">
    <img src="images/models2.jpg" style="width:100%;cursor:pointer"
    onclick="openModal();currentDiv(2)" class="w3-hover-shadow">
  </div>
  <div class="w3-col s4">
    <img src="images/models3.jpg" style="width:100%;cursor:pointer"
    onclick="openModal();currentDiv(3)" class="w3-hover-shadow">
  </div>
</div>

<div id="myModal" class="w3-modal w3-black">
 <span class="w3-text-white w3-xxlarge w3-hover-text-grey w3-container w3-display-topright" onclick="closeModal()" style="cursor:pointer">×</span>
 <div class="w3-modal-content">

  <div class="w3-content" style="max-width:1200px">
   <img class="mySlides" src="images/models1.jpg" style="width:100%">
   <img class="mySlides" src="images/models2.jpg" style="width:100%">
   <img class="mySlides" src="images/models3.jpg" style="width:100%">
   <div class="w3-row w3-black w3-center">
    <div class="w3-display-container">
     <p id="caption"></p>
     <span class="w3-display-left w3-btn" onclick="plusDivs(-1)">←</span>
     <span class="w3-display-right w3-btn" onclick="plusDivs(1)">→</span>
    </div>
    <div class="w3-col s4">
     <img class="demo w3-opacity w3-hover-opacity-off" src="images/models1.jpg" style="width:100%" onclick="currentDiv(1)" alt="Model S">
    </div>
    <div class="w3-col s4">
     <img class="demo w3-opacity w3-hover-opacity-off" src="images/models2.jpg" style="width:100%" onclick="currentDiv(2)" alt="Model S">
    </div>
    <div class="w3-col s4">
     <img class="demo w3-opacity w3-hover-opacity-off" src="images/models3.jpg" style="width:100%" onclick="currentDiv(3)" alt="Model S">
    </div>
   </div> <!-- End row -->
  </div> <!-- End w3-content -->
  
 </div> <!-- End modal content -->
</div> <!-- End modal -->

</div>
</c:if>

	<p>이름: ${sessionScope.cust_name}<br>
	이메일: ${sessionScope.cust_email}<br>
	모델명: ${requestScope.myInfo.modelName}<br>
	시리얼번호: ${requestScope.myInfo.serialno}<br>
	구매 날짜: ${requestScope.myInfo.saledate}</p>
	<c:if test="${requestScope.myInfo.modelName == null}">
		<form action="cont" method="post">
		<input type="hidden" name="command" value="serialRegister">
		<input type="text" name="serialno" placeholder="Enter the serial number">
		<input type="submit" value="register">
	</form>
	</c:if>
	<br>
</c:if>

<script>
function openModal() {
  document.getElementById('myModal').style.display = "block";
}

function closeModal() {
  document.getElementById('myModal').style.display = "none";
}

var slideIndex = 1;
showDivs(slideIndex);

function plusDivs(n) {
  showDivs(slideIndex += n);
}

function currentDiv(n) {
  showDivs(slideIndex = n);
}

function showDivs(n) {
  var i;
  var x = document.getElementsByClassName("mySlides");
  var dots = document.getElementsByClassName("demo");
  var captionText = document.getElementById("caption");
  if (n > x.length) {slideIndex = 1}
  if (n < 1) {slideIndex = x.length}
  for (i = 0; i < x.length; i++) {
     x[i].style.display = "none";
  }
  for (i = 0; i < dots.length; i++) {
     dots[i].className = dots[i].className.replace(" w3-opacity-off", "");

  }
  x[slideIndex-1].style.display = "block";
  dots[slideIndex-1].className += " w3-opacity-off";
  captionText.innerHTML = dots[slideIndex-1].alt;
}
</script>

</body>
</html>