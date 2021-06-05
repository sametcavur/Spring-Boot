<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>.: Çalışan Kayıt :.</title>
</head>
<body>
	<form:form method="POST" modelAttribute="employee">
		<form:errors />
		<fieldset>
			<form:label path="employeeId">Eklenecek Çalışan ID:</form:label>
			<form:input path="employeeId" type="text" disabled="true" />
			<form:errors path="employeeId" />
		</fieldset>
		<fieldset>
			<form:label path="employeeName">Eklenecek Çalışan Adı:</form:label>
			<form:input path="employeeName" type="text" />
			<form:errors path="employeeName" />
		</fieldset>
		<fieldset>
			<form:label path="monthlySalary">Eklenecek Çalışan Maası:</form:label>
			<form:input path="monthlySalary" type="text" />
			<form:errors path="monthlySalary" />
		</fieldset>
		<fieldset>
			<form:button type="submit">Çalışan Kayıt</form:button>
		</fieldset>

	</form:form>
</body>
</html>