<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>.: Employee :.</title>
</head>
<body>
	<form:form method="POST" modelAttribute="employee">
		<fieldset>
			<form:label path="employeeId">Çalışan ID:</form:label>
			<form:input path="employeeId" type="text" disabled="true" />
		</fieldset>
		<fieldset>
			<form:label path="employeeName">Çalışan Adı:</form:label>
			<form:input path="employeeName" type="text" />
		</fieldset>
		<fieldset>
			<form:label path="employeeSurname">Çalışan Soyadı:</form:label>
			<form:input path="employeeSurname" type="text" />
		</fieldset>
		<fieldset>
			<form:label path="employeeSalary">Çalışan Maaşı:</form:label>
			<form:input path="employeeSalary" type="text" />
		</fieldset>
		<fieldset>
			<form:button type="submit">Kayıt Ol</form:button>
		</fieldset>

	</form:form>
</body>
</html>