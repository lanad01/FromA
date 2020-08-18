<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>�α��� ȭ��</title>
<link rel="stylesheet" type="text/css" href="css/3-3.css">
</head>
<body>
<div align="center" class="body">
<form:form action="login.html" method="post" modelAttribute="user">
<spring:hasBindErrors name="user">
	<font color="red">
		<c:forEach items="${errors.globalErrors }" var="error">
			<spring:message code="${error.code}"/>
		</c:forEach>
	</font>
</spring:hasBindErrors>
<table>
	<tr height="40px"><td>�����ID</td>
		<td><form:input path="id" cssClass="userId"/>
		<font color="red"><form:errors path="id"/></font></td></tr>
	<tr height="40px"><td>�н�����</td>
		<td><form:password path="pwd" cssClass="password"/>
		<font color="red"><form:errors path="pwd"/></font></td></tr>
</table>
<table>
	<tr><td align="center"><input type="submit" value="�α���"/></td>
		<td align="center"><input type="reset" value="�� ��"/></td></tr>
</table>
</form:form>
</div>
</body>
</html>

















