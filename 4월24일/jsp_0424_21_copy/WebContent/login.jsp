<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<script type="text/javascript" src="js/custom.js"></script>
<title>로그인페이지입니다</title>
</head>
<body>
	<form action="login_ok.jsp" name="login" method="post">
		<label for="id">아이디</label><input type="text" name="id" id="id"><br>
		<label for="pw">비밀번호</label><input type="password" name="pw" id="pw"><br>
		<input type="button" onclick="login_ch()" value="로그인"><input type="button" onclick="javascript.window.location.href='join.jsp'" value="회원가입">	
	</form>
</body>
</html>