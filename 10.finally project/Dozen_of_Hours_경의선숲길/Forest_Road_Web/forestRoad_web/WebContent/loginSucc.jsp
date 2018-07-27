<%@page import="java.util.ArrayList"%>
<%@page import="model.domain.PlaceDTO"%>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR" session="true"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>   
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<title>Gyeongui-line-forest-road-web</title>
<meta charset="UTF-8">
 <script type="text/javascript" src="https://openapi.map.naver.com/openapi/v3/maps.js?clientId=ULpi3Dbxtgp5X4t6MXFE&submodules=geocoder"></script>
<script type="text/javascript" src="js/instafeed.min.js"></script>
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
<link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Raleway">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<style>
body,h1,h2,h3,h4,h5,h6 {font-family: "Raleway", sans-serif}
body, html {
    height: 100%;
    line-height: 1.8;
}
.table-wrapper-scroll-y {
  display: block;
  max-height: 200px;
  overflow-y: auto;
  -ms-overflow-style: -ms-autohiding-scrollbar;
}
/* The container */
.radio-container {
    display: block;
    position: relative;
    padding-left: 35px;
    margin-bottom: 12px;
    cursor: pointer;
    font-size: 15px;
    -webkit-user-select: none;
    -moz-user-select: none;
    -ms-user-select: none;
    user-select: none;
}

/* Hide the browser's default radio button */
.radio-container input {
    position: absolute;
    opacity: 0;
    cursor: pointer;
}

/* Create a custom radio button */
.checkmark {
    position: absolute;
    top: 2px;
    left: 120px;
    height: 25px;
    width: 25px;
    background-color: #eee;
    border-radius: 50%;
}

/* On mouse-over, add a grey background color */
.radio-container:hover input ~ .checkmark {
    background-color: #ccc;
}

/* When the radio button is checked, add a blue background */
.radio-container input:checked ~ .checkmark {
    background-color: #2196F3;
}

/* Create the indicator (the dot/circle - hidden when not checked) */
.checkmark:after {
    content: "";
    position: absolute;
    display: none;
}

/* Show the indicator (dot/circle) when checked */
.radio-container input:checked ~ .checkmark:after {
    display: block;
}

/* Style the indicator (dot/circle) */
.radio-container .checkmark:after {
 	top: 9px;
	left: 9px;
	width: 8px;
	height: 8px;
	border-radius: 50%;
	background: white;
}
/* Full height image header */
.bgimg-1 {
    background-position: center;
    background-size: cover;
    background-image: url("img/section3.jpg");
    min-height: 100%;
}
.w3-bar .w3-button {
    padding: 16px;
}
body {font-family: Arial, Helvetica, sans-serif;}

/* Full-width input fields */
input[type=text], input[type=password] {
    width: 80%;
    padding: 12px 20px;
    margin: 8px 0;
    display: inline-block;
    border: 1px solid #ccc;
    box-sizing: border-box;
}

/* Set a style for all buttons */
button {
    background-color: #4CAF50;
    color: white;
    padding: 14px 20px;
    margin: 8px 0;
    border: none;
    cursor: pointer;
}

button:hover {
    opacity: 0.8;
}

/* Extra styles for the cancel button */
.cancelbtn {
    width: auto;
    padding: 10px 18px;
    background-color: #f44336;
}

/* Center the image and position the close button */
.imgcontainer {
    text-align: center;
    margin: 24px 0 12px 0;
    position: relative;
}

img.avatar {
    width: 60%;
    border-radius: 70%;
}

.container {
    padding: 16px;
}

span.psw {
    float: right;
    padding-top: 16px;
}

/* The Modal (background) */
.modal {
    display: none; /* Hidden by default */
    position: fixed; /* Stay in place */
    z-index: 1; /* Sit on top */
    left: 0;
    top: 0;
    width: 100%; /* Full width */
    height: 100%; /* Full height */
    overflow: auto; /* Enable scroll if needed */
    background-color: rgb(0,0,0); /* Fallback color */
    background-color: rgba(0,0,0,0.4); /* Black w/ opacity */
    padding-top: 60px;
}

/* Modal Content/Box */
.modal-content {
    background-color: #fefefe;
    margin: 5% auto 15% auto; /* 5% from the top, 15% from the bottom and centered */
    border: 1px solid #888;
    width: 35%; /* Could be more or less, depending on screen size */
}

/* The Close Button (x) */
.close {
    position: absolute;
    right: 25px;
    top: 0;
    color: #000;
    font-size: 35px;
    font-weight: bold;
}

.close:hover,
.close:focus {
    color: red;
    cursor: pointer;
}

/* Add Zoom Animation */
.animate {
    -webkit-animation: animatezoom 0.6s;
    animation: animatezoom 0.6s
}

@-webkit-keyframes animatezoom {
    from {-webkit-transform: scale(0)}
    to {-webkit-transform: scale(1)}
}

@keyframes animatezoom {
    from {transform: scale(0)}
    to {transform: scale(1)}
}

/* Change styles for span and cancel button on extra small screens */
@media screen and (max-width: 300px) {
    span.psw {
       display: block;
       float: none;
    }
    .cancelbtn {
       width: 100%;
    }
}
/* Style the tab */
.tab {
    overflow: hidden;
    border: 1px solid #d1d1d1;
    background-color: #ffffff;
}

/* Style the buttons inside the tab */
.tab button {

    background-color: inherit;
    float: left;
    border: none;
    outline: none;
    cursor: pointer;
    padding: 14px 16px;
    transition: 0.3s;
    font-size: 22px;
    font-color: #000000
}

/* Change background color of buttons on hover */
.tab button:hover {
    background-color: #ddd;
}

/* Create an active/current tablink class */
.tab button.active {
    background-color: #ccc;
}

/* Style the tab content  - about style*/
.tabcontent {
    display: none;
    padding: 6px 12px;
    -webkit-animation: fadeEffect 1s;
    animation: fadeEffect 1s;
}

/* Fade in tabs */
@-webkit-keyframes fadeEffect {
    from {opacity: 0;}
    to {opacity: 1;}
}

@keyframes fadeEffect {
    from {opacity: 0;}
    to {opacity: 1;}
}
table {
    font-family: arial, sans-serif;
    border-collapse: collapse;
    width: 100%;
}

td, th {
    border: 1px solid #dddddd;
    text-align: left;
    padding: 8px;
}

tr:nth-child(even) {
    background-color: #dddddd;
}
</style>
<body>

	<script>alert('${sessionScope.name}'+"님 반갑습니다!")</script>

<!-- Navbar (sit on top) -->
<div class="w3-top">
  <div class="w3-bar w3-white w3-card" id="myNavbar">
     <img src="img/logo.png" class="w3-opacity w3-hover-opacity-off" width="10%" height="10%" onclick="location.href='#home'">
    <!-- Right-sided navbar links -->
    <div class="w3-right w3-hide-small">
      <a href="#about" class="w3-bar-item w3-button">ABOUT</a>
      <a href="#search" class="w3-bar-item w3-button"><i class="fa fa-map-marker"></i> SEARCH</a>
      <a href="#instafeed" class="w3-bar-item w3-button"><i class="fa fa-instagram"></i> INSTA</a> 
      <a href="#team" class="w3-bar-item w3-button"><i class="fa fa-user"></i> TEAM</a>
      <a class ="w3-bar-item w3-button" onclick = 'location.href="cont?command=logout"'id="button_logout" ><i class="fa fa-sign-in"></i>LOGOUT</a>
    </div>
    <!-- Hide right-floated links on small screens and replace them with a menu icon -->

    <a href="javascript:void(0)" class="w3-bar-item w3-button w3-right w3-hide-large w3-hide-medium" onclick="w3_open()">
      <i class="fa fa-bars"></i>
    </a>
  </div>
</div>

<!-- Sidebar on small screens when clicking the menu icon -->
<nav class="w3-sidebar w3-bar-block w3-black w3-card w3-animate-left w3-hide-medium w3-hide-large" style="display:none" id="mySidebar">
  <a href="javascript:void(0)" onclick="w3_close()" class="w3-bar-item w3-button w3-large w3-padding-16">Close ×</a>
  <a href="#about" onclick="w3_close()" class="w3-bar-item w3-button">ABOUT</a>
  <a href="#instafeed" onclick="w3_close()" class="w3-bar-item w3-button">INSTA</a>
  <a href="#search" onclick="w3_close()" class="w3-bar-item w3-button">SEARCH</a>
   <a href="#team" onclick="w3_close()" class="w3-bar-item w3-button">TEAM</a>
  <a href="#signup" onclick="w3_close()" class="w3-bar-item w3-button">SIGNUP</a>
</nav>

<!-- Header with full-height image -->
<header class="bgimg-1 w3-display-container w3-grayscale-min" id="home">
  <div class="w3-display-left w3-text-white" style="padding:48px">
    <span class="w3-jumbo w3-hide-small"> .Railroad to Forest</span><br>
    <span class="w3-xxlarge w3-hide-large w3-hide-medium"> .Railroad to Forest</span><br>
    <span class="w3-xlarge">Do not waste your time visiting the Gyeongui line forest road</span>
    <p><a href="#about" class="w3-button w3-white w3-padding-large w3-large w3-margin-top w3-opacity w3-hover-opacity-off">Learn more and start today</a></p>
  </div> 
  <div class="w3-display-bottomleft w3-text-grey w3-large" style="padding:24px 48px">
    <i class="fa fa-facebook-official w3-hover-opacity"></i>
    <i class="fa fa-instagram w3-hover-opacity"></i>
    <i class="fa fa-snapchat w3-hover-opacity"></i>
    <i class="fa fa-pinterest-p w3-hover-opacity"></i>
    <i class="fa fa-twitter w3-hover-opacity"></i>
    <i class="fa fa-linkedin w3-hover-opacity"></i>
  </div>
</header>
<!-- About Section -->
   <div class="w3-container" style="padding: 64px 16px" id="about">
      <h2 class="w3-center">ABOUT</h2>
      <p class="w3-center w3-large">Gyeongui Line Forest Road Route
         Section</p>


      <div class="tab">
      <style> button{font-family: "Raleway", sans-serif}</style>
      
         <button class="tablinks" style="color:black" onclick="openCity(event, 'Yeonnam-dong')">
            Yeonnam-dong
         </button>
         <button class="tablinks" style="color:black" onclick="openCity(event, 'Wau-gyo')">
            Wau-gyo
         </button>
         <button class="tablinks" style="color:black" onclick="openCity(event, 'Sinsu-dong')">
            Sinsu-dong
         </button>
         <button class="tablinks" style="color:black" onclick="openCity(event, 'Daeheung-dong')">
            Daeheung-dong
         </button>
         <button class="tablinks" style="color:black" onclick="openCity(event, 'Yeomni-dong')">
            Yeomni-dong
         </button>
         <button class="tablinks" style="color:black" onclick="openCity(event, 'Saechang-ro')">
            Saechang-ro
         </button>
         <button class="tablinks" style="color:black" onclick="openCity(event, 'Wonhyo-ro')">
            Wonhyo-ro
         </button>
      </div>
      </div>
      <div class="w3-margin-left w3-center">
      <style>
         p{font-family: "NanumBarunGothic", sans-serif}   </style>
        
         <div id="Yeonnam-dong" class="tabcontent">
            <img src="img/section/section1.png" class="#Yeonnam-dong.tabcontent" width=65% height="55%" onclick="location.href='#search'">
         </div>

         <div id="Wau-gyo" class="tabcontent">
            <img src="img/section/section2.png" class="#Wau-gyo.tabcontent" width=65% height="55%" onclick="location.href='#search'">
         </div>

         <div id="Sinsu-dong" class="tabcontent">
            <img src="img/section/section3.png" class="#Sinsu-dong.tabcontent" width=65% height="55%" onclick="location.href='#search'">
         </div>


         <div id="Daeheung-dong" class="tabcontent">
            <img src="img/section/section4.png" class="#Daeheung-dong.tabcontent" width=65% height="55%" onclick="location.href='#search'">
         </div>

         <div id="Yeomni-dong" class="tabcontent">
            <img src="img/section/section5.png" class="#Yeomni-dong.tabcontent" width=65% height="55%" onclick="location.href='#search'">
         </div>

         <div id="Saechang-ro" class="tabcontent">
            <img src="img/section/section6.png" class="#Saechang-ro.tabcontent" width=65% height="55%" onclick="location.href='#search'">
         </div>

         <div id="Wonhyo-ro" class="tabcontent">
            <img src="img/section/section7.png" class="#Wonhyo-ro.tabcontent" width=65% height="55%" onclick="location.href='#search'">
         </div>
      </div>
   
   <script>
function openCity(evt, cityName) {
    var i, tabcontent, tablinks;
    tabcontent = document.getElementsByClassName("tabcontent");
    for (i = 0; i < tabcontent.length; i++) {
        tabcontent[i].style.display = "none";
    }
    tablinks = document.getElementsByClassName("tablinks");
    for (i = 0; i < tablinks.length; i++) {
        tablinks[i].className = tablinks[i].className.replace(" active", "");
    }
    document.getElementById(cityName).style.display = "block";
    evt.currentTarget.className += " active";
}
</script>


<!--  Naver Map Tag -->

	<div class="w3-container" style="padding: 128px 16px" id="search">
		<h3 class="w3-center">SEARCH</h3>
		<p class="w3-center w3-large"> the Restuarant, RestRoom, Parking lot</p>
		<div id="map" style="width: 90%; height: 500px;"></div>
		<div class="w3-container w3-row w3-center w3-padding-16">
		<form action="cont" method="post">
		<div class="w3-quarter">
		<h4>1. Click on your location on the map</h4>
		latitude : <input id=lat type="text" name="lat"><br>
		longitude : <input id=lng type="text" name="lng">
		</div>
		<div class="w3-quarter">
				<h4>2. Where to search</h4>
				<label class="radio-container">Restaurant 
				<input type="radio" value="restaurant" checked="checked" name="type"> <span class="checkmark"></span>
				</label> <label class="radio-container">RestRoom 
				<input type="radio" value="restroom" name="type"> <span class="checkmark"></span>
				</label> <label class="radio-container">Parking lot 
				<input type="radio" value="parking" name="type"> <span class="checkmark"></span>
				</label> 
			</div>
		
		<div class="w3-quarter">
				<h4>3. Select distance</h4>
				<label class="radio-container">Within 300M
				<input type="radio" value="300" checked="checked" name="distance"> <span class="checkmark"></span>
				</label> <label class="radio-container">Within 500m 
				<input type="radio" value="500" name="distance"> <span class="checkmark"></span>
				</label> <label class="radio-container">Within 1000M 
				<input type="radio" value="1000" name="distance"> <span class="checkmark"></span>
				</label> <label class="radio-container">Within 2000M 
				<input type="radio" value="2000" name="distance"> <span class="checkmark"></span>
				</label> 
			</div>
			<input type="hidden" name="command" value="search"> 
		<div class="w3-quarter"><input class="w3-btn w3-theme w3-xxlarge w3-half" style="color:gray"type="submit" value="SEARCH">
		</div>
		</form>
		</div>
		<!-- Promo Section "Statistics" -->
		<div class="w3-container w3-row w3-center w3-padding-32">
			<div class="w3-half"><h3><%="전체 데이터"%></h3>
				<div class="table-wrapper-scroll-y">
					<table class="table table-bordered table-striped w3-center">
						<thead>
							<tr>
								<th scope="col">#</th>
								<th scope="col">이름</th>
								<th scope="col">종류</th>
								<th scope="col">거리</th>
							</tr>
						</thead>
						<tbody>
						<c:if test="${not empty sessionScope.dataAll}">
							<c:forEach items="${sessionScope.dataAll}" var="dto" varStatus="status">
								<tr><td>${status.count}</td><td>${dto.name }</td><td>${dto.type }</td><td>${dto.distance}</td></tr>
							</c:forEach>
						</c:if>
						
						<c:if test="${empty sessionScope.dataAll}">
							해당 데이터가 없음<br>
						</c:if>
							
							
							
						</tbody>
					</table>
				</div>
			</div>
			<div class="w3-half"><h3><%="선택한 거리 이내의 "%>${sessionScope.type } </h3>
				<div class="table-wrapper-scroll-y">
					<table class="table table-bordered table-striped w3-center">
						<thead>
							<tr>
								<th scope="col">#</th>
								<th scope="col">이름</th>
								<th scope="col">종류</th>
								<th scope="col">거리</th>
							</tr>
						</thead>
						<tbody>
							
						<c:if test="${not empty sessionScope.typesearch}">
							<c:forEach items="${sessionScope.typesearch}" var="dto2" varStatus="status" >
								<tr><td>${status.count}</td><td>${dto2.name }</td><td>${dto2.type }</td><td>${dto2.distance}</td></tr>
							</c:forEach>
						</c:if>
						
						<c:if test="${empty sessionScope.typesearch}">
							해당 데이터가 없음<br>
						</c:if>
							
							
							
						</tbody>
					</table>
				</div>
			</div>
				
			
			
		</div>
	</div>
	
	<!--  Naver Map Tag -->
	<script>
      var map = new naver.maps.Map('map');
      var myaddress = '동교동';// 도로명 주소나 지번 주소만 가능 (건물명 불가!!!!)
      naver.maps.Service.geocode({address: myaddress}, function(status, response) {
          if (status !== naver.maps.Service.Status.OK) {
              return alert(myaddress + '의 검색 결과가 없거나 기타 네트워크 에러');
          }
          var result = response.result;
          // 검색 결과 갯수: result.total
          // 첫번째 결과 결과 주소: result.items[0].address
          // 첫번째 검색 결과 좌표: result.items[0].point.y, result.items[0].point.x
          var myaddr = new naver.maps.Point(result.items[0].point.x, result.items[0].point.y);
          map.setCenter(myaddr); // 검색된 좌표로 지도 이동
          // 마커 표시s
          var marker = new naver.maps.Marker({
            position: myaddr,
            map: map
          });
          
          // 마커 클릭 이벤트 처리
          naver.maps.Event.addListener(marker, "click", function(e) {
            if (infowindow.getMap()) {
                infowindow.close();
            } else {
                infowindow.open(map, marker);
            }
          });
          //마커 이동
          naver.maps.Event.addListener(map, 'click', function(e) {
        	    marker.setPosition(e.latlng);
        	    document.getElementById("lat").value=e.coord.lat();
        	    document.getElementById("lng").value=e.coord.lng();
        	    //alert(e.coord.lat() + ', ' + e.coord.lng());
        	});
          // 마크 클릭시 인포윈도우 오픈
          var infowindow = new naver.maps.InfoWindow({
              content: '<h3> 선택한 지점</h3><img src="img/section4.jpg">'
          });
          function initGeocoder() {
        	    var latlng = map.getCenter();
        	    var utmk = naver.maps.TransCoord.fromLatLngToUTMK(latlng); // 위/경도 -> UTMK
        	    var tm128 = naver.maps.TransCoord.fromUTMKToTM128(utmk);   // UTMK -> TM128
        	    var naverCoord = naver.maps.TransCoord.fromTM128ToNaver(tm128); // TM128 -> NAVER

        	    infoWindow = new naver.maps.InfoWindow({
        	        content: ''
        	    });

        	    map.addListener('click', function(e) {
        	    	
        	    	loadDoc();
        	    	alert(1);
        	    	
        	    	
        	        var latlng = e.coord,
        	            utmk = naver.maps.TransCoord.fromLatLngToUTMK(latlng),
        	            tm128 = naver.maps.TransCoord.fromUTMKToTM128(utmk),
        	            naverCoord = naver.maps.TransCoord.fromTM128ToNaver(tm128);

        	        utmk.x = parseFloat(utmk.x.toFixed(1));
        	        utmk.y = parseFloat(utmk.y.toFixed(1));

        	        infoWindow.setContent([
        	            '<div style="padding:10px;width:380px;font-size:14px;line-height:20px;">',
        	            '<strong>LatLng</strong> : '+ latlng.toString() +'<br />',
        	            '<strong>UTMK</strong> : '+ utmk.toString() +'<br />',
        	            '<strong>TM128</strong> : '+ tm128.toString() +'<br />',
        	            '<strong>NAVER</strong> : '+ naverCoord.toString() +'<br />',
        	            '</div>'
        	        ].join(''));

        	        infoWindow.open(map, latlng);
        	        console.log('LatLng: ' + latlng.toString());
        	        console.log('UTMK: ' + utmk.toString());
        	        console.log('TM128: ' + tm128.toString());
        	        console.log('NAVER: ' + naverCoord.toString());
        	    });
        	}
          /*function loadDoc() {
  			var xhttp = new XMLHttpRequest();
  			
  			xhttp.onreadystatechange = function() {
  				if (this.readyState == 4 && this.status == 200) {
  					
  					var data = this.responseText;
  					data = eval(data);    //포맷이 배열 구조의 문자열일 경우 배열 객체로 반환
  					data = JSON.parse(data);  // 배열도 반환 가능.
  					alert(data);
  					
  					//document.getElementById("dataView2").innerText = data2+" "+data3;
  					
  				}
  			};
  			xhttp.open("GET", "cont?command=setLocation&lat=latlng.x&lng=latlng.y", true);
  			xhttp.send();
  		}*/

        	naver.maps.onJSContentLoaded = initGeocoder;
         
      });
      
      
      //비동기 요청 함수 개발 
      
      
      </script>




<script>
 var feed = new Instafeed({
  get: 'user',
  userId: 307851484,
  accessToken: '307851484.0bae29a.0eaa632555b94683825551177628680f',
  resolution: 'low_resolution',
  template: '<a href="{{link}}" class="w3-image w3-card w3-col l3 m6 w3-margin-bottom"><img src="{{image}}"></a>',
  filter: function(image) {
    return image.tags.indexOf('forest') >= 0;
  }
});
feed.run();
</script>
<div class="w3-container" style="padding: 128px 16px" id="instafeed">
	<h3 class="w3-center">
		<i class="fa fa-instagram w3-hover-opacity"></i>My Instagram
	</h3>
	<p class="w3-center w3-large">Tagged - 'Forest'</p>
</div>



	<!-- Team Section -->
	<div class="w3-container w3-center" style="padding: 128px 16px"
		id="team">
		<h3 class="w3-center">
			<i class="fa fa-user"></i> TEAM
		</h3>
		<p class="w3-center w3-large">DOZEN OF HOURS</p>
		<p class="w3-center w3-large"></p>
		<div class=" w3-row-padding" style="margin-top: 128px">
			<div class="w3-center w3-col l3 m6 w3-margin-bottom"></div>

			<div class="w3-center w3-col l3 m6 w3-margin-bottom">
				<div class="w3-image w3-card">
					<img src="img/team1.jpg?ver=1" alt="Donghoon" style="width: 100%">
					<div class="w3-container">
						<h3>Dong hoon</h3>
						<p class="w3-opacity">Developer</p>
					</div>
				</div>
			</div>
			
			<div class="w3-center w3-col l3 m6 w3-margin-bottom">
				<div class="w3-image w3-card">
					<img src="img/team2.jpg" alt="Hyeonjoo" style="width: 100%">
					<div class="w3-container">
						<h3>Hyeon joo</h3>
						<p class="w3-opacity">Art Director & Analyst</p>
					</div>
				</div>
			</div>
			<div class="w3-center w3-col l3 m6 w3-margin-bottom"></div>

		</div>
	</div>


	<!-- Work Section -->
<div class="w3-container" style="padding:128px 16px" id="work">
  <h3 class="w3-center">OUR WORK</h3>
  <p class="w3-center w3-large">What we've done for people</p>

  <div class="w3-row-padding" style="margin-top:64px">
    <div class="w3-col l3 m6">
      <img src="img/tech_mic.jpg" style="width:100%" onclick="onClick(this)" class="w3-hover-opacity" alt="A microphone">
    </div>
    <div class="w3-col l3 m6">
      <img src="img/tech_phone.jpg" style="width:100%" onclick="onClick(this)" class="w3-hover-opacity" alt="A phone">
    </div>
    <div class="w3-col l3 m6">
      <img src="img/tech_drone.jpg" style="width:100%" onclick="onClick(this)" class="w3-hover-opacity" alt="A drone">
    </div>
    <div class="w3-col l3 m6">
      <img src="img/tech_sound.jpg" style="width:100%" onclick="onClick(this)" class="w3-hover-opacity" alt="Soundbox">
    </div>
  </div>

  <div class="w3-row-padding w3-section">
    <div class="w3-col l3 m6">
      <img src="img/tech_tablet.jpg" style="width:100%" onclick="onClick(this)" class="w3-hover-opacity" alt="A tablet">
    </div>
    <div class="w3-col l3 m6">
      <img src="img/tech_camera.jpg" style="width:100%" onclick="onClick(this)" class="w3-hover-opacity" alt="A camera">
    </div>
    <div class="w3-col l3 m6">
      <img src="img/tech_typewriter.jpg" style="width:100%" onclick="onClick(this)" class="w3-hover-opacity" alt="A typewriter">
    </div>
    <div class="w3-col l3 m6">
      <img src="img/tech_tableturner.jpg" style="width:100%" onclick="onClick(this)" class="w3-hover-opacity" alt="A tableturner">
    </div>
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
<!-- Modal for full size images on click-->
<div id="modal01" class="w3-modal w3-black" onclick="this.style.display='none'">
  <span class="w3-button w3-xxlarge w3-black w3-padding-large w3-display-topright" title="Close Modal Image">×</span>
  <div class="w3-modal-content w3-animate-zoom w3-center w3-transparent w3-padding-64">
    <img id="img01" class="w3-image">
    <p id="caption" class="w3-opacity w3-large"></p>
  </div>
</div>

<!-- copyright -->
<div class="w3-container w3-light-grey">
			<h3>Railroad To Forest.</h3>
			<p>Phone : 010-3967-3325, 010-9003-4096 Copyright(c) 2018   Email : glee1228@naver.com    www.RailroadtoForest.com Allright Reserved.</p>
</div>


</body>
</html>
