<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<link href="https://fonts.googleapis.com/css?family=Raleway:400,300,600,800,900" rel="stylesheet" type="text/css">
<title>Insert title here</title>
</head>
<style>




</style>
<body>
${requestScope.result}<br>

	
	<c:forEach items="${requestScope.myCompo}" var="data">
		${data.percent} %<br>
	</c:forEach>
	
	

<script>

</script>
	
	
</body>
</html>