<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<script type="text/javascript" src="js/custom.js"></script>
<title>Insert title here</title>
</head>
<body>
	<form action="join_ok.jsp" name="join" method="post">
	<label for="id">아이디</label>:<input type="text" name="id" id="id"><br>
	<label for="pw">패스워드</label>:<input type="password" name="pw" id="pw"><br>
	<label for="pw_check">패스워드 확인</label>:<input type="password" name="pw_check" id="pw_check"><br>
	<label for="name">이름</label>:<input type="text" name="name" id="name"><br>
	<label for="email">이메일</label>:<input type="email" name="email" id="email"><br>
	<label for="address">주소</label>:<input type="text" name="address" id="address"><br>
	<input type="button" onclick="join_check()" value="회원가입완료"><input type="button" onclick="javascript:location.href='login.jsp'" value="취소">
	</form>
</body>
</html>