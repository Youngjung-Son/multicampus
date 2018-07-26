<%@ page contentType="text/html; charset=utf-8" %>	
	
${sessionScope.name}<br>

<button onclick="location.href='${pageContext.request.contextPath}/cont?command=all'">
	모두 보기
</button>

<button onclick='location.href="${pageContext.request.contextPath}/cont?command=logout"'>
	로그아웃
</button>

<!-- 
http://ip:port/project/cont
http://ip:port/project/alogin/loginSucc.jsp

 -->






