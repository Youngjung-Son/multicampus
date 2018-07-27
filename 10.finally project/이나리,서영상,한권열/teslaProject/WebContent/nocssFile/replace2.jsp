<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
	<title>TMS - 교체부품 조회</title>
	<meta name="viewport" content="width=device-width, initial-scale=1, user-scalable=no" />
	<link rel='stylesheet prefetch' href='https://fonts.googleapis.com/css?family=Open+Sans:400,300'>
	<link rel='stylesheet prefetch' href='https://fonts.googleapis.com/icon?family=Material+Icons'>
	<link rel="stylesheet" href="css/style2.css">
</head>


<body>
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
	
			<br>
			<br>
			<h3>교체기록 조회</h3>
			<br>
			<p>조회하고 싶은 부품/소모품을 선택하세요.</p>
			<form action="cont" method="post">
			  	<select name="compo_name">
			    	<option value="엔진오일">엔진오일</option>
			    	<option value="배터리">배터리</option>
			    	<option value="냉각수">냉각수</option>
			   	 	<option value="오토미션오일">오토미션오일</option>
			   	 	<option value="브레이크오일">브레이크오일</option>
			  	</select>
			  <br>
			  
			  <input type="hidden" name="command" value="allCompoHist">
			  <button type="submit" value="조회" class="btn_login" onclick="cambiar_login()">조회</button>
			</form>		
			<br>
			<br>			
		</div>
	</div>
	<script>
		// Get the modal
		var modal = document.getElementById('id01');
		
		// When the user clicks anywhere outside of the modal, close it
		window.onclick = function(event) {
		    if (event.target == modal) {
		        modal.style.display = "none";
		    }
		}
	</script>
</body>
</html>