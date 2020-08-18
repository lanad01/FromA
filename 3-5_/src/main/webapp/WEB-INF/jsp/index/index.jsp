<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="../css/3-5.css"> 
<!--  경로찾기 ../의 의미 = 상위폴더 찾아가기 -->
</head>
<body>
<%@ include file="/WEB-INF/jsp/menu_header.jsp" %>
<!-- Controller는 얘야 -->
<div align="center" class="body">
	<h2> 과일 상품 목록 </h2>
	<table border="1">
		<tr class="header">
			<th align="center" width="80">상품번호</th>
			<th align="center" width="320">상품이름</th>
			<th align="center" width="100">가격</th>
		</tr>
		<c:forEach items="${list}" var="item" >
		<tr class="record">
			<td align="center">${item.item_id }</td>
			<td align="center">
			<a href="../detail/detail.html?itemId=${item.item_id}">${item.item_name }</a></td>
			<!--  한 번 위로 거슬러 올라간 뒤(../) detail폴더를 탐색하고 detail.jsp(html)로 연다 -->
			<td align="center">${item.price }</td>
		</tr>
		</c:forEach>
	</table>
</div>
</body>
</html>