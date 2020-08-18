<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ include file="/WEB-INF/jsp/header.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title><spring:message code="itemAdd.title"/></title>
<link rel="stylesheet" type="text/css" href="../css/3-6.css">
</head>
<body>
<script type="text/javascript">
</script>
<form:form modelAttribute="fruit" action="register.html" method="post"  
enctype="multipart/form-data" name="form" onSubmit="return check(this)">
<!--  model에는 소문자로 쓴다 -->
<div align="center" class="body">
<h2><font color="green"><spring:message code="itemAdd.title"/></font></h2>
<table>
	<tr height="40px"><td>상품번호</td>
		<td><form:input path="item_id" cssClass="item_id" maxLength="20"/></td>
		<td><font color="red"><form:errors path="item_id"/></font></td></tr>
	<tr height="40px"><td>상품명</td><td><form:input path="item_name" cssClass="item_name" maxLength="20"/></td>
		<td><font color="red"><form:errors path="item_name"/></font></td></tr>
	<tr height="40px"><td>가격</td><td><form:input path="price" cssClass="price" maxLength="6"/>&nbsp;원</td>
		<td><font color="red"><form:errors path="price"/></font></td></tr>
	<tr height="40px"><td>파일</td>
		<td><input type="file" name="picture"/></td><td></td></tr>
	<tr height="40px"><td>설명</td>
		<td><form:textarea path="description"/></td><td></td></tr>	
</table><br/>
	<input type="submit" value="등록"/><input type="reset" value="취소"/>
	<br/><a href="index.html">돌아가기</a>
</div>
</form:form>
</body>
</html>
