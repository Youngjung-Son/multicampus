<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
	<title>TMS - 교체부품 조회</title>
	<meta name="viewport" content="width=device-width, initial-scale=1, user-scalable=no" />
	<link rel='stylesheet prefetch' href='https://fonts.googleapis.com/css?family=Open+Sans:400,300'>
	<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
	<link rel="stylesheet" href="css/style.css">
</head>


<body>
<c:if test="${sessionScope.cust_email == null}">
	alert("로그인 후 이용가능합니다.");
		location.href='loginindex.html';
</c:if>

<c:if test="${not empty sessionScope.cust_email}">
	<div class="cont_principal">
    	<div class="cont_back_info">
    
			<form action="cont" method="post">
				<br><h3>교체부품 기록</h3>
				<br>
				<p> 교체부품명을 고르고, 교체날짜를 선택하세요. </p>
				<br>
				<b>교체부품명</b>
				<br>
				<select name="compo_name">
			    	<option value="엔진오일">엔진오일</option>
			    	<option value="배터리">배터리</option>
			    	<option value="냉각수">냉각수</option>
			   	 	<option value="오토미션오일">오토미션오일</option>
			   	 	<option value="브레이크오일">브레이크오일</option>
			  	</select>
  	
  				<br>
				<b>교체날짜</b>
				<br>
				<input type="date" name="replacedate"><br>
				<input type="hidden" name="command" value="replaceCompo">
			    <button type="submit" value="교체날짜기록" class="btn_login" onclick="cambiar_login()">교체날짜기록</button>
			</form>
			<c:if test="${requestScope.result == 'success'}">
				<script>
					alert("부품 교체 성공"); 
					location.href='${pageContext.request.contextPath}/cont?command=allCompoState';
				</script>
			</c:if>
			
			<c:if test="${requestScope.result == 'fail'}">
				<script>alert("부품 교체 실패");</script>
			</c:if>
			
			<br>
			<h3>교체기록 조회</h3>
			<br>
			<p>조회하고 싶은 부품/소모품을 선택하세요.</p>
			<!-- <form action="cont" method="post">
			  	<select name="compo_name">
			    	<option value="엔진오일">엔진오일</option>
			    	<option value="배터리">배터리</option>
			    	<option value="냉각수">냉각수</option>
			   	 	<option value="오토미션오일">오토미션오일</option>
			   	 	<option value="브레이크오일">브레이크오일</option>
			  	</select>
			  <br>
			  <div class="w3-container">
			  <input type="hidden" name="command" value="allCompoHist">
			  <button type="submit" value="조회" class="btn_login" onclick="cambiar_login()">조회</button>
			  
			  </form> -->
			  
			  	<select name="compo_name" id="compo_name">
			    	<option value="엔진오일">엔진오일</option>
			    	<option value="배터리">배터리</option>
			    	<option value="냉각수">냉각수</option>
			   	 	<option value="오토미션오일">오토미션오일</option>
			   	 	<option value="브레이크오일">브레이크오일</option>
			  	</select>
			  <br>
			  <div class="w3-container">
			  <button type="submit" value="조회" class="btn_login" onclick="reqAjax()">조회</button>
			  
			  <script type="text/javascript">
			  	function reqAjax(){
			  		var xhttp = new XMLHttpRequest();
					xhttp.onreadystatechange = function() {
						if (this.readyState == 4 && this.status == 200) {
							var data = this.responseText;
							document.getElementById('id01').style.display='block';
							
							document.getElementById("dataAll").innerHTML = data;
							
							
							
							
						}
					};
					//xhttp.setRequestHeader('Content-Type', 'application/x-www-form-urlencoded');
					reqData = encodeURIComponent(document.getElementById("compo_name").value);
					xhttp.open("get", "cont?command=allCompoHist&compo_name=" + reqData, true);
					
					xhttp.send();
			  		
			  	}
			  </script>
			  
			  
			  
			  
			  <div id="id01" class="w3-modal">
   				 <div class="w3-modal-content">
     				 <div class="w3-container">
     				   <!-- <span onclick="document.getElementById('id01').style.display='none'" class="w3-button w3-display-topright">&times;</span> -->
       					<span onclick="document.getElementById('id01').style.display='none'" class="w3-button w3-display-topright">&times;</span>
       					
       					 <p><b>교체기록 조회 결과</b></p>
       				
       					 	<div id="dataAll"></div>
    				  </div>
   	 			</div>
 			 </div>
		</div>
  
	</div>
	</div>
</c:if>
	</body>
	
</html>