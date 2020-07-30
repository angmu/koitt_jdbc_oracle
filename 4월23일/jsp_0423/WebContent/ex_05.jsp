<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%request.setCharacterEncoding("utf-8"); %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<!-- 7번연습 -->
<h2><c:out value="${param.user_id }"/></h2>



<!--  89점의 학점은 b를 비교문 만들어서 -->

<c:set var="name" value="${param.name}"/>
<c:set var="score" value="${(param.kor+param.eng+param.math)/3}"/>

<!-- 점수비교 -->
<c:if test="${score>=90 }">
<c:out value="${name }"/> 학생의 학점은a입니다. 점수:<c:out value="${score }"/><br>
</c:if>

<c:if test="${score<90&&score>=80 }">
<c:out value="${name }"/> 학생의 학점은b입니다. 점수:<c:out value="${score }"/><br>
</c:if>

<c:if test="${score<80&&score>=70 }">
<c:out value="${name }"/> 학생의 학점은c입니다. 점수:<c:out value="${score }"/><br>
</c:if>
<c:if test="${score<70&&score>=60 }">
<c:out value="${name }"/> 학생의 학점은d입니다. 점수:<c:out value="${score }"/><br>
</c:if> 

<c:if test="${score<60}">
<c:out value="${name }"/> 학생의 학점은f입니다. 점수:<c:out value="${score }"/><br>
</c:if>

<!-- 이름 테스트 -->
<c:if test="${param.name =='홍길동'}">
	${param.name}입니다
</c:if>
<c:if test="${param.name !='홍길동'}">
	홍길동이 아닙니다. ${param.name}입니다
</c:if>
</body>
</html>