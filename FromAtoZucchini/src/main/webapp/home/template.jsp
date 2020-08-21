<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" 
	prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>From A To Zucchini</title>
<style type="text/css">
body{height:100%;}
table.main{ width:90%; height:80%;
	border:1px solid blue; border-collapse:collapse;
	margin-left:20px; margin-right:20px;}
td.main{border:1px solid blue;}
#login{width:80%; border:1px dashed grey;
	padding:10px; margin-top:10px; margin-left:10px;}
#menus{	margin-top:10px;margin-left:20px;}
#content {background-color:orange;}
a:hover {background-color:yellow;}
td.main {background-color:lime;}

.btn{
	border:none; color:white; padding:15px 32px;
	text-align:center; text-decoration:none;
	display:inline-block; font-size:16px;
	margin:4px 2px; cursor:pointer;
}
.btn1 {background-color:#4CAF50;}
.btn2 {background-color:#008CBA;}
.btn1:hover {background-color:#008CBA;}
.btn2:hover {background-color:#4CAF50;}
#friends_menu{position:absolute; top:20%; left:45%;
	z-index:99;}
</style>
</head>
<body>
<div id="friends_menu">
<a href="template.jsp?BODY=inputFriends.jsp">
<img alt="" src="imgs/friends.png">
</a>
</div>
<script type="text/javascript">
function sportsMenu1(){
	location.href="SelectHometownServlet";
}
function sportsMenu3(){
	location.href="GetBBIdNameServlet";
}
function sportsMenu5(){
	location.href="GetSoccerTeamsServlet"
}
function sportsMenu7(){
	location.href="GetSoccerTeamsIdServlet";
}
function sportsMenu2(){
	location.href="BBListServlet";
}
function sportsMenu4(){
	location.href="BBPlayerServlet";
}
function sportsMenu6(){
	location.href="STListServlet";
}
function sportsMenu8(){
	location.href="SPList";
}
</script>
<h2 align="center"><img alt="" src="../imgs/logo.gif"></h2>
<table class="main">
<tr><td>
<img alt="" src="../imgs/1.jpg" height="10%" width="100%">
<nav><div align="center">
<button class="btn btn1" onClick="sportsMenu1()">
야구구단 등록</button>
<button class="btn btn1" onClick="sportsMenu2()">
야구구단 목록</button>
<button class="btn btn1" onClick="sportsMenu3()">
야구선수 등록</button>
<button class="btn btn1" onClick="sportsMenu4()">
야구선수 목록</button>
<button class="btn btn2" onClick="sportsMenu5()">
축구구단 등록</button>
<button class="btn btn2" onClick="sportsMenu6()">
축구구단 목록</button>
<button class="btn btn2" onClick="sportsMenu7()">
축구선수 등록</button>
<button class="btn btn2" onClick="sportsMenu8()">
축구선수 목록</button>
</div></nav>
</td></tr>
<tr><td>
	<table width="100%">
		<tr><td width="20%" height="300" valign="top"
					class="main">
				<div id="login">
					<c:choose>
						<c:when test="${sessionScope.loginUser != null }">
							<jsp:include page="logout.jsp"/>
						</c:when>
						<c:when test="${HEADER != null }">
							<jsp:include page="${HEADER }"/>
						</c:when>
						<c:otherwise>
							<jsp:include page="../login/login.html"/>
						</c:otherwise>					
					</c:choose>
				</div><br/>
				<div id="menus">
					<a href="writeFormServlet">답글 및 이미지 게시판</a><br/>
					<a href="imageList">이미지 게시판 목록</a><br/>
					<a href="jjimBBPList">찜한 야구선수 목록</a><br/>
					<a href="jjimSPList">찜한 축구선수 목록</a><br/>
					<a href="../home/intro.html?BODY=intro.jsp">소개</a><br/>
					<a href="template.jsp?BODY=registerMatjip.jsp">맛집 등록</a><br/>
					<a href="template.jsp?BODY=inputMatjip.jsp">맛집추천</a><br/>
					<a href="MatjipListServlet">맛집목록</a><br/>
					<a href="jjimMatjipList">찜한 맛집 보기</a><br/>
					<a href="template.jsp?BODY=inputBeer.jsp">맥주추천</a><br/>
					<a href="template.jsp?BODY=penaltyGame.jsp">축구게임</a><br/>
					<a href="template.jsp?BODY=hittingGame.jsp">야구게임</a><br/>
					<a href="template.jsp?BODY=inputGaBaBo.jsp">가위,바위,보 게임</a><br/>
					<a href="../home/bbsTemplate.html">게시글 쓰기</a><br/>
					<a href="../read/read.html">게시글 목록</a><br/>
					<a href="../item/inputItem.html">상품 등록</a><br/>
					<a href="../item/itemList.html">상품 목록</a><br/>
					<a href="cart-List">장바구니 보기</a><br/>
					<br/>
				</div>
			</td>
			<td id="content">
			<c:choose>
				<c:when test="${BODY != null }">
					<jsp:include page="${BODY }"/>			
				</c:when>
				<c:otherwise>
					BODY가 없다.
				</c:otherwise>
			</c:choose>
			</td>
		</tr>
	</table>
</td></tr>
<tr><td>
<img alt="" src="../imgs/1.jpg" width="100%" height="10%">
</td></tr>
</table>
<h3 align="Center">CopyLeft 2020. FromAtoZucchini</h3>
</body>
</html>









