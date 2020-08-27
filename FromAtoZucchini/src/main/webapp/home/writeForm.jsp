<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>  
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
<h3 align="center">이미지 글 작성</h3><br/>
<form:form action="../image/write.html" method="post" 
			enctype="multipart/form-data" modelAttribute="imageWriting">
<form:hidden path="order_no" value="${writing.order_no + 1 }"/>
<c:if test="${ ! empty writing.group_id }">
<form:hidden path="group_id" value="${writing.group_id }"/>
</c:if>	
<c:if test="${ ! empty writing.parent_id }">
<form:hidden path="parent_id" value="${writing.parent_id }"/>
</c:if>
<table border="1">
	<tr><th>글제목</th><td>
		<form:input path="title" size="40" value="${title }"/>
		<font color="red"><form:errors path="title"/></font></td></tr>
	<tr><th>닉네임</th><td><form:input path="writer_name"
		size="20"/>
		<font color="red"><form:errors path="writer_name"/></font></td></tr>
	<tr><th>이메일</th><td><form:input path="email" size="20"/>
		<font color="red"><form:errors path="email"/></font></td></tr>
	<tr><th>암 호</th><td><form:password path="password"
		size="20"/>
		<font color="red"><form:errors path="password"/></font></td></tr>
	<tr><th>이미지</th><td><input type="file" name="imagename"
		size="20"/></td></tr>
	<tr><th>글내용</th><td><form:textarea rows="8" cols="40" 
		path="content"></form:textarea></td></tr>
	<tr><td colspan="2"><input type="submit" value="등 록"/></td></tr>
</table>
</form:form>
</body>
</html>





















