<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ include file="/WEB-INF/jsp/header.jsp" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title><spring:message code="itemDelete.title"/></title>
<link rel="stylesheet" type="text/css" href="../css/3-6.css">
</head>
<body>
<form:form modelAttribute="fruit" action="delete.html">
<form:hidden path="item_id"/>
<div align="center" class="body">
<h2><font color="green"><spring:message code="itemDelete.title"/></font></h2>
<table>
	<tr height="40px"><td>��ǰ��</td><td><form:input path="item_name"
		cssClass="itemName" disabled="true"/></td></tr>
	<tr height="40px"><td>����</td><td><form:input path="price"
		cssClass="price" disabled="true"/>&nbsp;��</td></tr>
	<tr height="40px"><td>����</td><td><img alt="" 
		src="${pageContext.request.contextPath }/upload/${imageName}"
		width="210" height="240"></td></tr>
	<tr height="40px"><td>����</td><td><form:textarea path="description"
		disabled="true"/></td></tr>
</table><br/><input type="submit" value="����"/><br/><br/>
<a href="index.html">�� ���ư���</a>
</div>
</form:form>
</body>
</html>














