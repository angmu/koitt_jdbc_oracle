<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
   <%
   String authUser=(String)session.getAttribute("authUser");
   if(authUser==null){
	   String str;
		//서블릿과 달리 이미 html선언이 되어있음
		   str="<script type=\"text/javascript\">\r\n" + 
		     "      alert(\"로그인이 되어있지않습니다. 로그인해주세요.\");\r\n" + 
		     "      location.href='login.jsp';\r\n" + 
		     "   </script>";
		out.println(str);
   }
   
   %> 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h2>회원정보입력</h2>
	<form action="Join_Ok" name="join" method="post">
	아이디:<input type="text" name="id"><br>
	패스워드:<input type="password" name="pw"><br>
	패스워드확인:<input type="password" name="pw2"><br>
	이름:<input type="text" name="name"><br>
	이메일:<input type="email" name="email"><br>
	주소:<input type="text" name="address"><br>
	전화번호:<input type="text" name="phone"><br>
	생일:<input type="date" name="birth"><br>
	<p>성별</p>
	<input type="radio" name="gender" value="남성" checked="checked"> 남성
	<input type="radio" name="gender" value="여성"> 여성<br>
	<p>뉴스레터 수신 여부</p>
	<input type="radio" name="news" value="예" checked="checked"> 예
	<input type="radio" name="news" value="아니오"> 아니오<br>
	<p>SMS 수신 여부</p>
	<input type="radio" name="sms" value="예" checked="checked"> 예
	<input type="radio" name="sms" value="아니오"> 아니오<br>
	<input type="submit" value="가입하기">
	<input type="reset" value="취소">
	</form>
</body>
</html>