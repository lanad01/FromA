<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>���� ���</title>
<link rel="stylesheet" type="text/css" href="css/3-1.css">
</head>
<body>
<div align="center" class="body">
	<h2>���� ��ǰ ���</h2>
	<table border="1">
		<tr class="header">
			<th align="center" width="80">��ǰ��ȣ</th>
			<th align="center" width="320">��ǰ�̸�</th>
			<th align="center" width="100">����</th>
		</tr>
		<c:forEach items="${list}" var="item">
		<tr class="record">
			<td align="center">${item.item_id }</td>
			<td align="center">${item.item_name }</td>
			<td align="center">${item.price }</td>
		</tr>
		</c:forEach>
	</table>
</div>
</body>
</html>












