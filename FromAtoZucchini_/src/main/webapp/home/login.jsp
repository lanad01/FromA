<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
<div align="right"><a href="template.jsp?BODY=userentry.jsp">�����ϱ�</a></div>
<form action="Login.do" method="post"><!--  ������ ��ȣ�� �����ؾ��ϹǷ� ����Ʈ  -->
���̵�: <input type="text" name="ID" size="12" placeholder="����"><br/>
��ȣ :   <input type="password" name="PWD" size="12"/><br/>
 <input type="submit" value="�α���"/>
 <input type="reset" value="�� ��"/>
</form>
</body>
</html>