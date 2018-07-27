<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>로그인 후 화면</title>
</head>
<body>
${requestScope.result}
${sessionScope.result}
${sessionScope.result2}
<br>
${sessionScope.cust_name}<br>
${sessionScope.cust_email}
${sessionScope.serialno}

<br><hr><br>
<button onclick="location.href='index.html'">login</button>
<button onclick="location.href='${pageContext.request.contextPath}/cont?command=logout'">logout</button>
<button onclick="location.href='serialRegister.jsp'">Register serial number</button>
<button onclick="location.href='${pageContext.request.contextPath}/cont?command=myPage'">my page</button>
<button onclick="location.href='${pageContext.request.contextPath}/cont?command=allCompoState'">my compo</button>
<button onclick="location.href='replace.jsp'">replace compo</button>
</body>
</html>