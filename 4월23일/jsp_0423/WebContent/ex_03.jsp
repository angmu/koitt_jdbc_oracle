<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="ex_03_ok.jsp" name="ex_03" method="post">
	이름<input type="text" name="name"><br>
	아이디<input type="text" name="id"><br>
	패스워드<input type="password" name="pw"><br>
	<input type="submit" value="전송">
	</form>
	
	<%
		//아래2개는 너무 오래 살아잇어서 메모리 누수문제로 잘 안씀
		application.setAttribute("appUser_id", "app_admin");
		session.setAttribute("sessUser_id", "sess_admin");
		//아래 page넘기면 사라잔다.
		pageContext.setAttribute("pageUser", "page_admin");
		//이걸 제일많이사용
		request.setAttribute("reqUser", "req_admin");
	%>
</body>
</html>