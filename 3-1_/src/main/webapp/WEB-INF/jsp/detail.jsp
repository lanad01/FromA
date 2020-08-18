<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="css/3-1.css">
</head>
<body>
<div align="center" class="body"></div>
<h2>과일 상세 정보</h2>
<table>
	<tr><td><img alt="" src="img/${sendMap.picture_url }"></td>
		<td align="center">
			<table>
				<tr height="50">
					<td width="80">상품이름</td>
					<td width="160">${sendMap.item_name }</td>
				</tr>
				<tr height="50">
					<td width="80">가격</td>
					<td width="160">${sendMap.price }</td>
				</tr>
				<tr height="50">
					<td width="80">상품설명</td>
					<td width="160">${sendMap.description }</td>
				</tr>
				<tr><td colspan="2" align="center" width="240">
					<a href="index.html"> 목록으로 돌아가기</a></td>
				</tr>
			</table>
		</td>
	</tr>
</table>
</body>
</html>