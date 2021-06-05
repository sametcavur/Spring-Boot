<%@ page language="java" contentType="text/html; charset=ISO-8859-9"
	pageEncoding="ISO-8859-9"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-9">
<title>.: KULLANICILAR :.</title>
</head>
<body>
	<table border="1">
		<c:forEach var="users" items="${users}">
			<tr>
				<td>${users.userId}</td>
				<td>${users.userName}</td>
				<td>${users.userSurname}</td>
				<td>${users.birthOfDate}</td>
				<td>
				<c:if test="${users.userId==1}"> ID = 1</c:if>
				<c:if test="${users.userId!=1}"> ID = 1 DEĞİL</c:if>
				</td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>