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
	�α��� �Ǿ����ϴ�.<br/>ȯ���մϴ�~${sessionScope.loginUser }��~<br/>
	</c:when>
	<c:otherwise>
	�α��� ���� �ʾҽ��ϴ�. ������ ��ȣ�� Ȯ���ϼ���.
	</c:otherwise>
</c:choose>
</body>
</html>








