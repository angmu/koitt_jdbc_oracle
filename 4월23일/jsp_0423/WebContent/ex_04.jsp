<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!-- 통상적으로 core의c를 따서 prefix에 c라고 선언으 ㄹ많이한다. -->
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<!-- 변수선언 -->
<c:set var="id" value="admin"/>
<c:set var="pw" value="1234"/>
<%-- <c:remove var="pw"/> --%>
<c:set var="str" value="^&a"/>

<h2>JSTL core태그</h2>
아이디<c:out value="${id }"/><br>
비번<c:out value="${pw }"/><br>
문자<c:out value="${str }"/><br>
----------------------------------<br>

<!-- 에러 -->
<c:catch var="error">
	<%=2/0 %>
</c:catch>
<!-- 에러출력 -->
<c:out value="${error }"/>
<hr>

<!-- if문연습1 숫자는 그냥비교 -->
<c:if test="${pw==1234 }">
	비밀번호일치 :<c:out value="${pw }"/><br>
</c:if>

<!-- else if,else가없다. -->
<c:if test="${pw!=1234 }">
	비번이 틀림!<c:out value="${pw }"/><br>
</c:if>


<!-- if문연습2 문자는 ''를 쓰고비교 -->
<c:if test="${'admin'==id }">
	아이디일치 :<c:out value="${id }"/><br>
</c:if>

<!-- else if,else가없다. -->
<c:if test="${'admin'!=id }">
	아이디 틀림!<c:out value="${id }"/><br>
</c:if>




<%
// 	String id2="admin";
// 	String pw2="1234";
%>	
<!-- <h2>스크립트릿태그</h2> -->
<%-- 아이디<%=id2 %><br> --%>
<%-- 비번<%=pw2 %><br> --%>


</body>
</html>