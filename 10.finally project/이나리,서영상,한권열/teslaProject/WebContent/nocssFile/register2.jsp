<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>회원가입 화면</title>
</head>
<body>
	<form action="cont" method="post">
		<input type="hidden" name="command" value="register">
		* <input type="text" name="cust_email" placeholder="Enter the email"><br>
		* <input type="text" name="cust_name" placeholder="Enter your name"><br>
		* <input type="password" name="cust_pw" placeholder="Enter the password"><br>
		&nbsp;&nbsp;<input type="text" name="serialno" placeholder="Enter your serial number"><br>
		&nbsp;<input type="submit" value="register">
	</form>

</body>
</html>