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
�������� �ʴ� ���Դϴ�.
</c:if>
<c:if test="${ ! empty IMAGE }">
<table width="100%" border="1">
	<tr><th>������</th><td>${IMAGE.title }</td></tr>
	<tr><th>�ۼ���</th><td>${IMAGE.writer_name }</td></tr>
	<tr><td colspan="2" align="center">
		<img alt="" 
src="${pageContext.request.contextPath }/upload_img/${IMAGE.image_name}"
	width="350" height="300" border="0"></td></tr>
	<tr><th>�۳���</th><td>${IMAGE.content }</td></tr>
	<tr><td colspan="2"><a href="javascript:goReply()">[���]</a>
			<a href="javascript:goModify()">[����]</a>
			<a href="javascript:goDelete()">[����]</a>
			<a href="../image/writeList.html">[���]</a>
		</td></tr>
</table>
</c:if>
<script type="text/javascript">
function goModify(){
	document.frm.action="../image/modify.html";
	document.frm.submit();
}
function goDelete(){
	//frm�̶�� �̸��� ���� action�� ä���.
	document.frm.action="../image/delete.html";
	//action���� �����Ѵ�.
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

















