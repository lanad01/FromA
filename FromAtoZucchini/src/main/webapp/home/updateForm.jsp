<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
<script type="text/javascript">
function validate(fm){
	if(fm.title.value==''){
		alert("제목을 입력하세요"); return false;
	}
	if(fm.writer_name.value==''){
		alert("작성자를 입력하세요."); return false;
	}
	if(fm.password.value==''){
		alert("암호를 입력하세요."); return false;
	}
	if(fm.content.value=''){
		alert("내용을 입력하세요."); return false;
	}
	var result = confirm("정말로 변경하시겠습니까?");
	if(result == false) return false;
}
</script>
<form:form action="../image/updateDo.html" method="post"
	enctype="multipart/form-data" modelAttribute="imageWriting"
	onSubmit="return validate(this)">
<form:hidden path="writing_id" value="${imageWriting.writing_id }"/>
<table border="1" width="100%">
	<tr><th>글제목</th><td><form:input path="title" size="20"
		value="${imageWriting.title }"/></td></tr>
	<tr><th>작성자</th><td><form:input path="writer_name" size="20"
		value="${imageWriting.writer_name }"/></td></tr>
	<tr><th>이메일</th><td><form:input path="email" size="30"
		value="${imageWriting.email }"/></td></tr>
	<tr><th>암호</th><td><form:password path="password" size="20"/>
		</td></tr>
	<tr><th>이미지</th><td><input type="file" name="imagename"/><br/>
		<img alt="" width="350" height="300" border="0" src=
"${pageContext.request.contextPath }/upload_img/${imageWriting.image_name}">
		</td></tr>
	<tr><th>글내용</th><td><form:textarea path="content" rows="8" 
		cols="40" value="${imageWriting.content }"></form:textarea>
		</td></tr>
	<tr><td colspan="2"><input type="submit" value="수정"/>
		<input type="button" value="취소" 
		onClick="javascript:history.go(-1)"/></td></tr>
</table>
</form:form>
</body>
</html>






















