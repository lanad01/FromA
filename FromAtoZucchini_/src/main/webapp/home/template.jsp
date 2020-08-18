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
	// 서블릿을 호출합니다. 바로 jsp가 아니에요. 서블릿을 호출해야 DB접속부터 시작해서 팀ID호출이 가능해요 
}
function sportsMenu4(){ // 야구선수목록
	location.href="BBPlayerServlet";
}
function sportsMenu5(){
	location.href="GetSoccerTeamsServlet";
	// 서블릿을 호출합니다. 바로 jsp가 아니에요. 서블릿을 호출해야 DB접속부터 시작해서 팀ID호출이 가능해요 
}
function sportsMenu6(){
	location.href="STListServlet";
}
function sportsMenu7(){
	location.href="GetSoccerTeamIdServlet";
	// 서블릿을 호출합니다. 바로 jsp가 아니에요. 서블릿을 호출해야 DB접속부터 시작해서 팀ID호출이 가능해요 
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
<button class="btn btn1" onClick="sportsMenu1()">야구구단 등록</button>
<button class="btn btn1" onClick="sportsMenu2()">야구구단 목록</button>
<button class="btn btn1" onClick="sportsMenu3()">야구선수 등록</button><!--  얘도 마찬가지로, 서블릿에서 DB를 통해 팀목록을 얻고 시작해야한다 -->
<button class="btn btn1" onClick="sportsMenu4()">야구선수 목록</button>
<button class="btn btn2" onClick="sportsMenu5()">축구구단 등록</button>
<button class="btn btn2" onClick="sportsMenu6()">축구구단 목록</button>
<button class="btn btn2" onClick="sportsMenu7()">축구선수 등록</button>
<button class="btn btn2" onClick="sportsMenu8()">축구선수 목록</button>
</div></nav>
</td></tr>
<tr><td>
	<table width="100%">
	<tr>
		<td width="20%" height="300" valign="top" class="main">
			<div id="login">
			<c:choose>
				<c:when test="${sessionScope.LOGIN==null}"> 
				<!--HttpSession의 객체인 session에 LOGIN이 들어가 있을 때!
				   HttpRequest에 있는 파라미터를 호출할 때는 requestScope 
				   HttpSession에서는 그럼 sessionScope
				     -->
				<jsp:include flush="true" page="login.jsp" />
				</c:when>
				<c:otherwise>
				<jsp:include flush="true" page="logout.jsp" />
				</c:otherwise>
			</c:choose>
			</div><br/>
			<!--  로그인이 성공하면 include의 페이지가 바뀌어야한다. -->
<!-- jsp 표준 액션 태그( 콜론으로 시작하면 태그 ) -->
			<div id="menus">
				<a href="template.jsp?BODY=intro.jsp">소개</a><br/>
				<a href="template.jsp?BODY=registerMatjip.jsp">맛집등록</a><br/>
				<a href="template.jsp?BODY=inputMatjip.jsp">맛집추천</a><br/>
				<a href="MatjipListServlet">맛집목록</a><br/>
				<a href="template.jsp?BODY=inputBeer.jsp">맥주추천</a><br/>
				<a href="template.jsp?BODY=penaltyGame.jsp">축구게임</a><br/>
				<a href="template.jsp?BODY=hittingGame.jsp">야구게임</a><br/>
				<a href="template.jsp?BODY=inputGaBaBo.jsp">가위바위보</a><br/>
				<a href="template.jsp?BODY=inputBBS.jsp">게시글쓰기</a><br/>
				<a href="BBSListServlet">게시글목록</a><br/>
				<a href="template.jsp?BODY=inputItem.jsp">상품등록</a><br/>
				<a href="ItemListServlet">상품목록</a><br/>
				<a href="cart-List">장바구니 확인</a><br/>
				</div>
		</td>
		<td id="content"><jsp:include page="${param.BODY }"></jsp:include></td>
<!-- 근데 이러면 버튼 액션이 안되잖아?? -->
<!-- 그러기 위해선 파라미터를 통해 jsp값을 전해주자 -->
	</tr>
</table>
<tr><td>
<img alt="" src="img/1.jpg" width="100%" height="100%">
</td></tr>
</table>
<h3 align="center">CopyLeft 2020. FromaToZucchini</h3>
</body>
</html>