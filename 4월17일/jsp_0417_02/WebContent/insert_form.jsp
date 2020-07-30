<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
th {text-align: left;}

</style>
<script>
function check(){
	return form.submit();
}

</script>
</head>
<body>
	<form action="insert_ok.jsp" method="post" name="form">
		<table>
		<tr>	
			<th>아이디</th>
			<td><input type="text" name="m_id"></td>
		</tr>	
		<tr>
			<th>비밀번호</th>
			<td><input type="password" name="pw"></td>
		</tr>
		<tr>
			<th>비밀번호확인</th>
			<td><input type="password" name="pw2"></td>
		</tr>
		<tr>	
			<th>이름</th>
			<td><input type="text" name="m_name"></td>
		</tr>
		<tr>	
			<th>이메일</th>
			<td><input type="email" name="email"></td>
		</tr>
		<tr>	
			<th>주소</th>
			<td><input type="text" name="address"></td>
		</tr>
		<tr>
			<th>전화번호</th>
			<td><input type="text" name="address"></td>
		</tr>
		<tr>
			<th>생년월일</th>
			<td><input type="date" name="birth"></td>
		</tr>
		<tr>
			<th>성별</th>
			<td><input type="radio" name="gender" value="남성" id="m" checked="checked"><label for="m">남성</label>
			<input type="radio" name="gender" value="여성" id="f"><label for="f">여성</label>
			</td>
		</tr>
		<tr>
			<th>뉴스레터 수신여부</th>
			<td><input type="radio" name="news" value="예" id="n_y" checked="checked"><label for="n_y">예</label>
			<input type="radio" name="news" value="아니오" id="n_n"><label for="n_n">아니오</label>
			</td>
		</tr>
		<tr>
			<th>SMS 수신여부</th>
			<td><input type="radio" name="sms" value="예" id="s_y" checked="checked"><label for="s_y">예</label>
			<input type="radio" name="sms" value="아니오" id="s_n"><label for="s_n">아니오</label>
			</td>
		</tr>
		<tr>
			<td colspan="2"><input type="button" value="등록" onclick="check()"><input type="button" value="취소" onclick="location.href='history.back(-1)'"></td>		
		</tr>
		</table>
	</form>
</body>
</html>