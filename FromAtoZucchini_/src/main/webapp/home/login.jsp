<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
<div align="right"><a href="template.jsp?BODY=userentry.jsp">가입하기</a></div>
<form action="Login.do" method="post"><!--  계정과 암호를 은닉해야하므로 포스트  -->
아이디: <input type="text" name="ID" size="12" placeholder="계정"><br/>
암호 :   <input type="password" name="PWD" size="12"/><br/>
 <input type="submit" value="로그인"/>
 <input type="reset" value="취 소"/>
</form>
</body>
</html>