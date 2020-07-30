<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
 if(session.getAttribute("authUser")!=null){
%>    
<jsp:forward page="main.jsp"/>
<%} %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="js/custom.js">
 
</script>
</head>
<body>
	<form action="login_ok.jsp" name="login" method="post">
	<label for="id">아이디</label>:<input type="text" name="id" id="id"><br>
	<label for="pw">패스워드</label>:<input type="password" name="pw" id="pw"><br>
	<input type="button" onclick="login_check()" value="로그인"><input type="button" onclick="javascript:window.location='join.jsp'" value="회원가입">
	</form>
</body>
</html>