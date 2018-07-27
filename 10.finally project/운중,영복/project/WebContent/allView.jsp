<%@page import="model.domain.PlayerDTO"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<style>
#customers {
    font-family: "Trebuchet MS", Arial, Helvetica, sans-serif;
    border-collapse: collapse;
    width: 100%;
}

#customers td, #customers th {
    border: 1px solid #ddd;
    padding: 8px;
}

#customers tr:nth-child(even){background-color: #f2f2f2;}

#customers tr:hover {background-color: #ddd;}

#customers th {
    padding-top: 12px;
    padding-bottom: 12px;
    text-align: left;
    background-color: #4CAF50;
    color: white;
}
</style>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>
</head>
<body>
<h1><b>전체 선수 목록 출력</b></h1>
<table id="customers">
  <tr>
    <th>팀이름</th>
    <th>이름</th>
    <th>백넘버</th>
    <th>포지션</th>
    <th>스탯</th>
    <th>선수번호</th>
  </tr>
  		<c:forEach items="${sessionScope.allData}" var="data">
  		 <tr>
			<td><b>${data.tname}</b></td>
			<td><b>${data.name}</b></td>
			<td><b>${data.bnumber}</b></td>
			<td><b>${data.position}</b></td>
			<td><b>${data.stat}</b></td>
			<td><b>${data.inumber}</b></td>
		</tr>
		</c:forEach>
  
</table>

</body>
</html>