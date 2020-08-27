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
<c:if test="${empty LIST }">
등록된 게시글이 존재하지 않습니다.
</c:if>
<c:if test="${ ! empty LIST }">
<table width="100%">
	<tr><td align="right"><b>${STARTROW}~${ENDROW}/${COUNT}</b></td></tr>
</table>
<table border="1" width="100%">
	<tr><th>이미지</th><th>글제목</th><th>작성자</th><th>작성일</th></tr>
	<c:forEach var="w" items="${LIST }">
	<tr><td><img alt="" 
	src="${pageContext.request.contextPath }/upload_img/${w.image_name}"
	width="50" height="50"></td>
		<td><a href="javascript:goView(${w.writing_id })">${w.title }</a>
		</td><td>${w.writer_name }</td><td>${w.register_date }</td>
	</c:forEach>
</table>
<script type="text/javascript">
function goView(id){
//id에 있는 글번호로 DB에서 검색
//DB에서 검색하려면 컨트롤러로 매핑이 되어야 한다.-> form의 action이 필요
	document.frm.action = "../image/read.html";
	document.frm.id.value = id;
	document.frm.submit();
}
function goPage(page){
	document.frm.action = "../image/writeList.html";
	document.frm.PAGE_NUM.value = page;
	document.frm.submit();
}
</script>
<form name="frm" method="post">
	<input type="hidden" name="id"/>
	<input type="hidden" name="PAGE_NUM"/>
</form>
<c:set var="startPage"
value="${currentPage-(currentPage%10 == 0 ? 10:(currentPage%10))+1}"/>
<c:set var="endPage" value="${startPage + 9 }"/>
<c:if test="${endPage > pageCount }">
	<c:set var="endPage" value="${pageCount}"/>
</c:if>
<c:if test="${startPage > 10 }">
	<a href="javascript:goPage(${startPage - 1 })">[이전]</a>
</c:if>
<c:forEach var="pageNo" begin="${startPage }" end="${endPage }">
	<c:if test="${currentPage == pageNo }">
		<font size="5">
	</c:if>
	<a href="javascript:goPage(${pageNo })">${pageNo }</a>
	<c:if test="${currentPage == pageNo }">
		</font>
	</c:if>
</c:forEach>
<c:if test="${endPage < pageCount }">
	<a href="javascript:goPage(${endPage + 1 })">[다음]</a>
</c:if>

</c:if>

</body>
</html>


























