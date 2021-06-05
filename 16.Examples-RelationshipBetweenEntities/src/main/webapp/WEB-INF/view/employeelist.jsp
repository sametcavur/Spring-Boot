<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>.: Çalışan List:.</title>
</head>
<body>
	<table border="1">
		<c:forEach var="employee" items="${employee}">
			<tr>
				<td>${employee.employeeId}</td>
				<td>${employee.employeeName}</td>
				<td>${employee.monthlySalary}</td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>