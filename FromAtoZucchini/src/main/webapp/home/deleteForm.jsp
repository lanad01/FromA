<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
<form:form action="../image/deleteDo.html" method="post"
	onSubmit="return validate(this)" modelAttribute="imageWriting">
<form:hidden path="writing_id" value="${imageWriting.writing_id }"/>
<table width="100%" border="1">
<tr><th>������</th><td>${imageWriting.title }</td></tr>
<tr><th>�ۼ���</th><td>${imageWriting.writer_name }</td></tr>
<tr><th>�̸���</th><td>${imageWriting.email }</td></tr>
<tr><th>��ȣ</th><td><form:password path="password" size="10"/></td></tr>
<tr><th>�̹���</th><td><img alt="" width="350" height="300" border="0"
	src=
"${pageContext.request.contextPath }/upload_img/${imageWriting.image_name}">
	</td></tr>
<tr><td colspan="2"><input type="submit" value="����"/>
	<input type="button" value="���" onClick="javascript:history.go(-1)"/>
	</td></tr>
</table>
</form:form>
</body>
</html>






















