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
					<td>���̵�</td>
					<td>
						<form:input path="mem_id" />
					</td>
				</tr>
				<tr>
					<td>�г���</td>
					<td>
						<form:input path="mem_nick"/>
					</td>
				</tr>
				<tr>
					<td>��й�ȣ</td>
					<td>
						<form:input path="mem_passward"/>
					</td>
				</tr>
				<tr>
					<td>��й�ȣ Ȯ��</td>
					<td>
						<input type="password"/>
					</td>
				</tr>
				<tr>
					<td>
						<input type="submit" value="ȸ������">
					</td>
				</tr>
				
			</table>			
		</form:form>
</body>
</html>