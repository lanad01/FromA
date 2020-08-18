<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ include file="/WEB-INF/jsp/header.jsp" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title><spring:message code="itemAdd.title"/></title>
<link rel="stylesheet" type="text/css" href="../css/3-6.css">
</head>
<body>
<script type="text/javascript">
function sendForm(){ document.form.submit();}
function check(form){
if(form.itemId.value==''){alert("번호를 입력하세요.");return false;}
if(form.itemName.value==''){alert("이름을 입력하세요.");return false;}
if(form.price.value==''){alert("가격을 입력하세요.");return false;}
if(form.description.value==''){alert("설명을 입력하세요.");return false;}
	var v = confirm("정말로 등록하시겠습니까?");
	if(v == false) return false;
	return true;
}
</script>
<form:form modelAttribute="item" action="register.html" method="post"
enctype="multipart/form-data" name="form" onSubmit="return check(this)">
<div align="center" class="body">
<h2><font color="green"><spring:message code="itemAdd.title"/></font></h2>
<table>
	<tr height="40px"><td>상품번호</td><td><form:input path="itemId"
		cssClass="itemId" maxLength="20"/></td>
		<td><font color="red"><form:errors path="itemId"/></font></td></tr>
	<tr height="40px"><td>상품명</td><td><form:input path="itemName"
		cssClass="itemName" maxLength="20"/></td>
		<td><font color="red"><form:errors path="itemName"/></font></td></tr>
	<tr height="40px"><td>가격</td><td><form:input path="price"
		cssClass="price" maxLength="6"/>&nbsp;원</td>
		<td><font color="red"><form:errors path="price"/></font></td></tr>
	<tr height="40px"><td>파일</td>
		<td><input type="file" name="pictureUrl"/></td><td></td></tr>
	<tr height="40px"><td>설명</td>
		<td><form:textarea path="description" cssClass="description"/></td>
	<td><font color="red"><form:errors path="description"/></font></td></tr>
</table><br/>
	<input type="submit" value="등록"/><input type="reset" value="취소"/>
	<br/><a href="index.html">■ 돌아가기</a>
</div>
</form:form>
</body>
</html>














