<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ include file="/WEB-INF/jsp/header.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title><spring:message code="itemMenu.title"/></title>
<link rel="stylesheet" type="text/css" ref="../css/3-6.css">
</head>
<body>
<form:form method="post" action="search.html">
	<div align="center" class="body">
	<h2><spring:message code="itemMenu.title"/></h2>
	��ǰ�� �˻�<input type="text" name="item_name"/><input type="submit" value="�˻�"/>
	<!--  ��� form:form�� action�� ����  search.html-->
	<a href="create.html"> ��ǰ���</a>
	<!--  http://localhost:8080/3-6-cos/item/index.html ���� ���� ��ǰ����� ������? -->
	<!--  http://localhost:8080/3-6-cos/ ??  -->
	<!--  http://localhost:8080/3-6-cos/item/create.html 
   		item��Ʈ�ѷ����� �޾�����Ѵ� �ƴϸ� 404��� -->
	<table border="1">
		<tr class="header">
			<th align="center" width="80">��ǰID</th>
			<th align="center" width="320">��ǰ��</th>
			<th align="center" width="100">����</th>
			<th align="center" width="80">����</th>
			<th align="center" width="80">����</th>
		</tr>
		<c:forEach items="${itemList }" var="item">
		<tr class="record">
			<td align="center">${item.item_id }</td>
			<td align="left">${item.item_name }</td>
			<td align="right">${item.price }</td>
			<td align="center"><a href="edit.html?itemId=${item.item_id }">��ǰ����</a></td>
			<td align="center"><a href="confirm.html?itemId=${item.item_id }">��ǰ����</a></td>
		</tr>
		</c:forEach>
	</table>
	</div>
</form:form>
</body>
</html>