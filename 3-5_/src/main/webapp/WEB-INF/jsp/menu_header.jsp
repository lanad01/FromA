<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!--  기존의 jsp에 들어가는 jsp이므로 DocType이나 html태그 관련해서는 전부 삭제 -->
<div align="center">
<table class="header">
	<tr><td width="160"><a href="../index/index.html">목록으로 돌아가기</a></td>
	    <td width="160"><a href="../checkout/checkout.html">계산하러 가기</a></td>
	    <td width="160"><a href="../cart/cartConfirm.html">카트 확인하기</a></td>
	    <td width="160"><a href="../cart/cartClear.html"> 카트 비우기</a></td>
	    <td width="160">
	    	<c:choose>
	    		<c:when test="${not empty loginUser }">
	    			<font color="red">환영합니다<br/>
	    			${loginUser.id }님.
	    			<a href="../logout/logout.html?id=${loginUser.id }">로그아웃</a></font>
	    		</c:when>
	    		<c:when test="${empty loginUser }">
	    			<font color="red">
	    				<a href="../loginform/login.html">로그인하기</a>
	    				<!--  loginformController 찾아가고 그곳의 login.jsp -->
	    			</font>
	    		</c:when>
	    	</c:choose>
	    </td>
	   </tr>
</table>
</div>
