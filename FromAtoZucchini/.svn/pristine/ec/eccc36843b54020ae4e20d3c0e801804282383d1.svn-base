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
<c:if test="${empty param.id }">
<script type="text/javascript">
alert("삭제되었습니다.");
location.href="../image/writeList.html";//목록으로 진행
</script>
</c:if>
<c:if test="${! empty param.id }">
<script type="text/javascript">
alert("암호가 일치하지 않습니다.");
location.href="../image/read.html?id="+${param.id};
//삭제하기 전(즉, 상세정보 페이지)로 진행
</script>
</c:if>
</body>
</html>

















