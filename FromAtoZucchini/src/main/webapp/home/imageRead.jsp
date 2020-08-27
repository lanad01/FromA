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
<c:if test="${empty IMAGE }">
존재하지 않는 글입니다.
</c:if>
<c:if test="${ ! empty IMAGE }">
<table width="100%" border="1">
	<tr><th>글제목</th><td>${IMAGE.title }</td></tr>
	<tr><th>작성자</th><td>${IMAGE.writer_name }</td></tr>
	<tr><td colspan="2" align="center">
		<img alt="" 
src="${pageContext.request.contextPath }/upload_img/${IMAGE.image_name}"
	width="350" height="300" border="0"></td></tr>
	<tr><th>글내용</th><td>${IMAGE.content }</td></tr>
	<tr><td colspan="2"><a href="javascript:goReply()">[답글]</a>
			<a href="javascript:goModify()">[수정]</a>
			<a href="javascript:goDelete()">[삭제]</a>
			<a href="../image/writeList.html">[목록]</a>
		</td></tr>
</table>
</c:if>
<script type="text/javascript">
function goModify(){
	document.frm.action="../image/modify.html";
	document.frm.submit();
}
function goDelete(){
	//frm이라는 이름의 폼에 action을 채운다.
	document.frm.action="../image/delete.html";
	//action으로 전송한다.
	document.frm.submit();
}
</script>
<form name="frm" method="post">
<input type="hidden" name="id" value="${IMAGE.writing_id}"/>
<input type="hidden" name="parent_id" value="${IMAGE.writing_id}"/>
<input type="hidden" name="group_id" value="${IMAGE.group_id}"/>
</form>
</body>
</html>


















