<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
<h2 align="center">��ǰ ���</h2>
<table border="1">
	<tr><td width="40">��ǰ�ڵ�</td><td width="150">��ǰ�̸�</td>
		<td width="100">��ǰ����</td><td width="100">������</td>
		<td></td></tr>
	<c:forEach items="${ITEM_LIST }" var="item">
	<tr><td>${item.item_id }</td>
		a<td><a href="../item/itemDetail.html?CODE=${item.item_id }">${item.item_name }</a></td>
		<td>${item.price }</td><td>${item.origin }</td>
		<td><a href="">��ٱ��� ���</a></td></tr>
	</c:forEach>
</table>
</body>
</html>


















