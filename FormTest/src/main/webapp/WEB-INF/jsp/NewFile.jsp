<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
<form:form modelAttribute="bean" action="joinUpCompletee" method="post">
			<table>
				<tr>
					<td>아이디</td>
					<td>
						<form:input path="mem_id" />
					</td>
				</tr>
				<tr>
					<td>닉네임</td>
					<td>
						<form:input path="mem_nick"/>
					</td>
				</tr>
				<tr>
					<td>비밀번호</td>
					<td>
						<form:input path="mem_passward"/>
					</td>
				</tr>
				<tr>
					<td>비밀번호 확인</td>
					<td>
						<input type="password"/>
					</td>
				</tr>
				<tr>
					<td>
						<input type="submit" value="회원가입">
					</td>
				</tr>
				
			</table>			
		</form:form>
</body>
</html>