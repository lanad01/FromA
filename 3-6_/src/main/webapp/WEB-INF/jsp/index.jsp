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
	상품명 검색<input type="text" name="item_name"/><input type="submit" value="검색"/>
	<!--  얘는 form:form의 action에 간다  search.html-->
	<a href="create.html"> 상품등록</a>
	<!--  http://localhost:8080/3-6-cos/item/index.html 에서 만약 상품등록을 누르면? -->
	<!--  http://localhost:8080/3-6-cos/ ??  -->
	<!--  http://localhost:8080/3-6-cos/item/create.html 
   		item콘트롤러에서 받아줘야한다 아니면 404뜬다 -->
	<table border="1">
		<tr class="header">
			<th align="center" width="80">상품ID</th>
			<th align="center" width="320">상품명</th>
			<th align="center" width="100">가격</th>
			<th align="center" width="80">편집</th>
			<th align="center" width="80">삭제</th>
		</tr>
		<c:forEach items="${itemList }" var="item">
		<tr class="record">
			<td align="center">${item.item_id }</td>
			<td align="left">${item.item_name }</td>
			<td align="right">${item.price }</td>
			<td align="center"><a href="edit.html?itemId=${item.item_id }">상품편집</a></td>
			<td align="center"><a href="confirm.html?itemId=${item.item_id }">상품삭제</a></td>
		</tr>
		</c:forEach>
	</table>
	</div>
</form:form>
</body>
</html>