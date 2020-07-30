<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h2>파일명: ${requestScope.select_com }</h2>

<h2>list출력</h2>
<table border="1">
	<tr>
		<th>아이디</th>
		<th>비번</th>
		<th>이름</th>
		<th>이메일</th>
		<th>주소</th>
		<th>가입일</th>
	</tr>
<c:forEach var="dto" items="${dtos }">
	<tr>
		<th><a href="update.jsp?id=${dto.getId() }">${dto.getId() }</a></th>
		<th>${dto.getPw() }</th>
		<th>${dto.getName() }</th>
		<th>${dto.getEmail() }</th>
		<th>${dto.getAddress() }</th>
		<th>${dto.getB_date() }</th>
	</tr>
</c:forEach>
</table>
</body>
</html>