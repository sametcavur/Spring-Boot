<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>.: Ürün List:.</title>
</head>
<body>
	<table border="1">
		<c:forEach var="product" items="${product}">
			<tr>
				<td>${product.productId}</td>
				<td>${product.productName}</td>
				<td>${product.salesPrice}</td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>