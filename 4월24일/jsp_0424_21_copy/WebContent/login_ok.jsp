<%@page import="com.javalec.ex.MemberDto"%>
<%@page import="com.javalec.ex.MemberDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
 String id=request.getParameter("id");
 String pw=request.getParameter("pw");
 MemberDao mdao=MemberDao.getInstance();
 int check=mdao.login_check(id, pw);
 switch(check){
 case 1: 
	MemberDto mdto=mdao.getMember(id);
	session.setAttribute("authUser", id);
	session.setAttribute("id", id);
	session.setAttribute("pw", pw);
	session.setAttribute("name", mdto.getName());
%>	 
	<script type="text/javascript">
		alert('로그인 성공');
		window.location.href='main.jsp';
	</script>
<%	 
	break;
 case 0:
%>
	<script type="text/javascript">
		alert('비밀번호가 틀립니다');
		window.location.href='login.jsp';
	</script>
<%
	 break;
 case -1:
%>
	<script type="text/javascript">
		alert('아이디가 존재하지 않습니다');
		window.location.href='login.jsp';
	</script>
<%
	 break;
 }
%>   
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

</body>
</html>