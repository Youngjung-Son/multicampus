<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
 <table border="1">
 	<c:forEach items="${requestScope.data}" var="data">
	 	<tr><td>${data.hist_idx}</td>
	 	<td>${data.serialno}</td>
		<td>${data.compo_name}</td>
		<td>${data.replaceDate}</td></tr>
 	</c:forEach>
 </table>
