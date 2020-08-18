<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
<%@ include file="/WEB-INF/jsp/menu_header.jsp" %>
<div align="center" class="body">
<h2>상품 계산 화면</h2>
<font color="red"><b>받을 곳</b></font>
<table>
	<tr><td>사용자ID</td><td>${loginUser.id }</td></tr>
	<tr><td>이름</td><td>${loginUser.name }</td></tr>
	<tr><td>주소</td><td>${loginUser.address }</td></tr>
	<tr><td>이메일</td><td>${loginUser.email }</td></tr>
</table>
<font color="red"><b>쇼핑 목록</b></font>
<table border="1">
	<tr><th width="200">상품명</th><th width="150">가격</th>
		<th width="50">갯수</th><th width="150">소계</th></tr>
	<c:forEach items="${itemList }" var="itemSet">
	<tr><td align="left">${itemSet.item.item_name }</td>
		<td align="right">${itemSet.item.price }원</td>
		<td align="right">${itemSet.quantity }개</td>
		<td align="right">${itemSet.quantity * itemSet.item.price }원</td>
	</tr>
	</c:forEach>
</table><br/>
<b>합계 총액:${totalAmount }원</b><br/><br/>
<form action="../end/end.html">
	<input type="submit" name="btn" value="확정"/>
</form>
<a href="../index/index.html">■ 목록으로 돌아가기</a>
</div>
</body>
</html>





















