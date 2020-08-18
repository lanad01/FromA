<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>From a to Zucchini</title>
<style type="text/css">
body{height:100%;}
table.main{width:90%; height:80%; border:1px solid blue; border-collapse:collapse;
	margin-left:20px; margin-right:20px; }
td.main{border:1px solid blue; }
#login{ width:80%; border:1px dashed grey; padding:10px; margin-top:10px; margin-left:10px;}
#menus{ margin-top:10px;}
#content{ background-color:orange; }
.btn{border:none; color:white; padding:15px 32px; text-align:center; text-decoration:none;
 display:inline-block; font-size:16px; margin:4px 2px; cursor:pointer; }
.btn1 { background-color:#4CAF50;}
.btn2{ background-color:#008CBA;}
.btn1:hover{background-color:#008CBA; }
.btn2:hover{background-color:#4CAF50; }
#friends_menu{position:absolute; top:10%; left:45%; z-index:99;}
</style>
</head>
<body>
<div id="friends_menu">
<a href="template.jsp?BODY=inputFriends.jsp">
<img alt="" src="img/friend.png">
</a>
</div>
<script type="text/javascript">
function sportsMenu1(){
	location.href="SelectHometown"; 
}
function sportsMenu2(){
	location.href="BBListServlet";
}
function sportsMenu3(){
	location.href="GetBBIdNameServlet";
	// ������ ȣ���մϴ�. �ٷ� jsp�� �ƴϿ���. ������ ȣ���ؾ� DB���Ӻ��� �����ؼ� ��IDȣ���� �����ؿ� 
}
function sportsMenu4(){ // �߱��������
	location.href="BBPlayerServlet";
}
function sportsMenu5(){
	location.href="GetSoccerTeamsServlet";
	// ������ ȣ���մϴ�. �ٷ� jsp�� �ƴϿ���. ������ ȣ���ؾ� DB���Ӻ��� �����ؼ� ��IDȣ���� �����ؿ� 
}
function sportsMenu6(){
	location.href="STListServlet";
}
function sportsMenu7(){
	location.href="GetSoccerTeamIdServlet";
	// ������ ȣ���մϴ�. �ٷ� jsp�� �ƴϿ���. ������ ȣ���ؾ� DB���Ӻ��� �����ؼ� ��IDȣ���� �����ؿ� 
}
function sportsMenu8(){
	location.href="SPListServlet";
}

</script>.
<h2 align="center"><img alt="" src="img/logo.gif" ></h2>
<table class="main">
<tr><td>
<img alt="" src="img/1.jpg" height="100px" width="100%">
<nav><div align="center">
<button class="btn btn1" onClick="sportsMenu1()">�߱����� ���</button>
<button class="btn btn1" onClick="sportsMenu2()">�߱����� ���</button>
<button class="btn btn1" onClick="sportsMenu3()">�߱����� ���</button><!--  �굵 ����������, �������� DB�� ���� ������� ��� �����ؾ��Ѵ� -->
<button class="btn btn1" onClick="sportsMenu4()">�߱����� ���</button>
<button class="btn btn2" onClick="sportsMenu5()">�౸���� ���</button>
<button class="btn btn2" onClick="sportsMenu6()">�౸���� ���</button>
<button class="btn btn2" onClick="sportsMenu7()">�౸���� ���</button>
<button class="btn btn2" onClick="sportsMenu8()">�౸���� ���</button>
</div></nav>
</td></tr>
<tr><td>
	<table width="100%">
	<tr>
		<td width="20%" height="300" valign="top" class="main">
			<div id="login">
			<c:choose>
				<c:when test="${sessionScope.LOGIN==null}"> 
				<!--HttpSession�� ��ü�� session�� LOGIN�� �� ���� ��!
				   HttpRequest�� �ִ� �Ķ���͸� ȣ���� ���� requestScope 
				   HttpSession������ �׷� sessionScope
				     -->
				<jsp:include flush="true" page="login.jsp" />
				</c:when>
				<c:otherwise>
				<jsp:include flush="true" page="logout.jsp" />
				</c:otherwise>
			</c:choose>
			</div><br/>
			<!--  �α����� �����ϸ� include�� �������� �ٲ����Ѵ�. -->
<!-- jsp ǥ�� �׼� �±�( �ݷ����� �����ϸ� �±� ) -->
			<div id="menus">
				<a href="template.jsp?BODY=intro.jsp">�Ұ�</a><br/>
				<a href="template.jsp?BODY=registerMatjip.jsp">�������</a><br/>
				<a href="template.jsp?BODY=inputMatjip.jsp">������õ</a><br/>
				<a href="MatjipListServlet">�������</a><br/>
				<a href="template.jsp?BODY=inputBeer.jsp">������õ</a><br/>
				<a href="template.jsp?BODY=penaltyGame.jsp">�౸����</a><br/>
				<a href="template.jsp?BODY=hittingGame.jsp">�߱�����</a><br/>
				<a href="template.jsp?BODY=inputGaBaBo.jsp">����������</a><br/>
				<a href="template.jsp?BODY=inputBBS.jsp">�Խñ۾���</a><br/>
				<a href="BBSListServlet">�Խñ۸��</a><br/>
				<a href="template.jsp?BODY=inputItem.jsp">��ǰ���</a><br/>
				<a href="ItemListServlet">��ǰ���</a><br/>
				<a href="cart-List">��ٱ��� Ȯ��</a><br/>
				</div>
		</td>
		<td id="content"><jsp:include page="${param.BODY }"></jsp:include></td>
<!-- �ٵ� �̷��� ��ư �׼��� �ȵ��ݾ�?? -->
<!-- �׷��� ���ؼ� �Ķ���͸� ���� jsp���� �������� -->
	</tr>
</table>
<tr><td>
<img alt="" src="img/1.jpg" width="100%" height="100%">
</td></tr>
</table>
<h3 align="center">CopyLeft 2020. FromaToZucchini</h3>
</body>
</html>