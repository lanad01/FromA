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
if(form.itemId.value==''){alert("��ȣ�� �Է��ϼ���.");return false;}
if(form.itemName.value==''){alert("�̸��� �Է��ϼ���.");return false;}
if(form.price.value==''){alert("������ �Է��ϼ���.");return false;}
if(form.description.value==''){alert("������ �Է��ϼ���.");return false;}
	var v = confirm("������ ����Ͻðڽ��ϱ�?");
	if(v == false) return false;
	return true;
}
</script>
<form:form modelAttribute="item" action="register.html" method="post"
enctype="multipart/form-data" name="form" onSubmit="return check(this)">
<div align="center" class="body">
<h2><font color="green"><spring:message code="itemAdd.title"/></font></h2>
<table>
	<tr height="40px"><td>��ǰ��ȣ</td><td><form:input path="itemId"
		cssClass="itemId" maxLength="20"/></td>
		<td><font color="red"><form:errors path="itemId"/></font></td></tr>
	<tr height="40px"><td>��ǰ��</td><td><form:input path="itemName"
		cssClass="itemName" maxLength="20"/></td>
		<td><font color="red"><form:errors path="itemName"/></font></td></tr>
	<tr height="40px"><td>����</td><td><form:input path="price"
		cssClass="price" maxLength="6"/>&nbsp;��</td>
		<td><font color="red"><form:errors path="price"/></font></td></tr>
	<tr height="40px"><td>����</td>
		<td><input type="file" name="pictureUrl"/></td><td></td></tr>
	<tr height="40px"><td>����</td>
		<td><form:textarea path="description" cssClass="description"/></td>
	<td><font color="red"><form:errors path="description"/></font></td></tr>
</table><br/>
	<input type="submit" value="���"/><input type="reset" value="���"/>
	<br/><a href="index.html">�� ���ư���</a>
</div>
</form:form>
</body>
</html>














