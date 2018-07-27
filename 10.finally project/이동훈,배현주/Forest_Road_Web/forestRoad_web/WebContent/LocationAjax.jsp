
 <%@page import="java.util.ArrayList"%>
<%@page import="model.domain.PlaceDTO"%>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR" session="true"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>   
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>LocationAjax.jsp</title>
</head>
<body>
	<%
		ArrayList<PlaceDTO> data = (ArrayList<PlaceDTO>)session.getAttribute("typesearch");
		System.out.println(data);
	%>
</body>
</html>