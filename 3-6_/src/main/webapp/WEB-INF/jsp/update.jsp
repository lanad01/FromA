<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ include file="/WEB-INF/jsp/header.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title><spring:message code="itemEdit.title"/></title>
<link rel="stylesheet" type="text/css" href="../css/3-6.css">
</head>
<body>
<form:form modelAttribute="fruit" action="update.html" method="post"
enctype="multipart/form-data"> 
<!--  얘는 edit에서 item을 받았기에 각 항목이 해당 item정보로 Default되어 있다. 그림도 그렇고 -->
<form:hidden path="item_id"/><form:hidden path="picture_url"/>
<div align="center" class="body">
<h2><font color="green"><spring:message code="itemEdit.title"></spring:message></font></h2>
<table>
	<tr height="40px"><td>상품명</td>
		<td><form:input path="item_name" cssClass="itemName" maxLength="20"/></td>
		<td><font color="red"><form:errors path="item_name"/></font></td></tr>
	<tr height="40px"><td>가격</td>
		<td><form:input path="price" cssClass="price" maxLength="6"/>&nbsp;원</td>
		<td><font color="red"><form:errors path="price"/></font></td></tr>
	<tr height="40px"><td>파일</td><td><input type="file" name="picture"/></td><td></td></tr>
	<tr height="40px"><td>설명</td><td><form:textarea path="description" cssClass="description"/></td>
		<td><font color="red"><form:errors path="description"/></font></td></tr>
</table><br/>
	<input type="submit" value="갱신"/><input type="reset" value="취소"/>
	<br/><br/><a href="index.html">돌아가기</a>
</div>
</form:form>
</body>
</html>