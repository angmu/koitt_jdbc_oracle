<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%! int check1=1; %>
	<!-- 섞어서 쓰면 제일 맨 위의 조건에 부합하는거만 뜬다.. -->
	<c:set var="check" value="1"/>
	<c:choose>
		<c:when test="<%=check1==1%>">
			<p>5개의 풀옵션 차량 선택</p>
			<c:param name="user_id" value="admin"/>
			<!-- redirect로 하면 바로넘어간다,... -->
			<c:redirect url="ex_05.jsp"/>
		</c:when>
		<c:when test="${check==1}">
			<p>10개의 풀옵션 차량 선택</p>
		</c:when>
		<c:when test="${check==3}">
			<p>3개의 풀옵션 차량 선택</p>
		</c:when>
		<c:otherwise>
			<p>선택한 옵션이 없습니다.</p>
		</c:otherwise>
	</c:choose>
</body>
</html>