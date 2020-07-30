<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%request.setCharacterEncoding("utf-8"); %>
    <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
	//request가 총 5개 넘어옴 
	String user_id=(String)request.getAttribute("user_id");
	String user_pw=(String)request.getAttribute("user_pw");
	String user_name=(String)request.getAttribute("user_name");
%>

<h2>스크립트릿으로 받기</h2>
아이디:<%=user_id %><br>
비번:<%=user_pw %><br>
이름:<%=user_name %><br>
<hr>
<!-- ex_03.jsp방식으로하면 이제 뷰페이지에서 메소드를 호출안해도 출력가능해짐. -->
	<h2>클래스 1개 출력</h2> <!-- 게시판 글 불러올때, 회원정보 1개 불러올때 활용가능! -->
	<table border="1">
	<tr>
		<th>번호</th>
		<th>아이디</th>
		<th>패스워드</th>
	</tr>
	<tr>
		<th>${requestScope.ldto.getNum() }</th>
		<th>${requestScope.ldto.getId() }</th>
		<th>${requestScope.ldto.getPw() }</th>
	</tr>
	</table>


	<h2>ArrayList 출력</h2><!-- 게시판 리스트, select로 값이 여러개 나올때 활용가능! -->
	<table border="1">
	<tr>
		<th>번호</th>
		<th>아이디</th>
		<th>패스워드</th>
	</tr>
	<c:forEach var="dto" items="${test }">
	<tr>
		<th>${dto.getNum() }</th>
		<th>${dto.getId() }</th>
		<th>${dto.getPw() }</th>
	</tr>
	</c:forEach>
	</table>



	<h2>EL태그</h2><!-- 특정페이지, 이름등 1게만 부를때 활용가능!  -->
	아이디:${requestScope.user_id }<br>
	비번:${requestScope.user_pw }<br>
	이름:${requestScope.user_name }<br>


</body>
</html>