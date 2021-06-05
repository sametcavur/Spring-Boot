<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>.: Ürün Kayıt :.</title>
</head>
<body>
	<form:form method="POST" modelAttribute="product">
	<form:errors/>
		<fieldset>
			<form:label path="productId">Eklenecek Ürün ID:</form:label>
			<form:input path="productId" type="text" disabled="true" />
			<form:errors path="productId"/>
		</fieldset>
		<fieldset>
			<form:label path="productName">Eklenecek Ürün Adı:</form:label>
			<form:input path="productName" type="text" />
			<form:errors path="productName"/>
		</fieldset>
		<fieldset>
			<form:label path="salesPrice">Eklenecek Ürün Fiyatı:</form:label>
			<form:input path="salesPrice" type="text" />
			<form:errors path="salesPrice"/>
		</fieldset>
		<fieldset>
			<form:button type="submit">Ürün Kayıt</form:button>
		</fieldset>

	</form:form>
</body>
</html>