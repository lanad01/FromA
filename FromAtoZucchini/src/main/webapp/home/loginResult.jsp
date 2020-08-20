<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
<c:choose>
	<c:when test="${sessionScope.loginUser != null }">
	로그인 되었습니다.<br/>환영합니다~${sessionScope.loginUser }님~<br/>
	</c:when>
	<c:otherwise>
	로그인 되지 않았습니다. 계정과 암호를 확인하세요.
	</c:otherwise>
</c:choose>
</body>
</html>









