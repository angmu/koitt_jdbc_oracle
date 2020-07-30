<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<script>
	function post(){
	    new daum.Postcode({
	        oncomplete: function(data) {
	        	jQuery("#address1").val(data.zonecode);
	      		jQuery("#address2").val(data.address);
	      		jQuery("#address3").focus();
	        }
	    }).open();
	}
</script>
</head>
<body>
	<form action="join_ok.jsp" name="join" method="post">
		<label for="id">아이디</label><input type="text" name="id" id="id"><br>
		<label for="pw">패스워드</label><input type="password" name="pw" id="pw"><br>
		<label for="pw2">패스워드확인</label><input type="password" name="pw2" id="pw2"><br>
		<label for="name">이름</label><input type="text" name="name" id="name"><br>
		<label for="email">이메일</label><input type="text" name="email" id="email"><br>
		<label for="address1">우편번호</label><input type="text" name="address1" id="address1" readonly="readonly"><input type="button" onclick="post()" value="우편번호 검색"><br>
		<label for="address2">주소</label><input type="text" name="address2" id="address2" readonly="readonly">
		<input type="text" name="address3" id="address3"><br>
		<input type="button" onclick="check()" value="전송"><input type="button" value="취소" onclick="javascript.location.href='login.jsp'">
	</form>
</body>
</html>