<%@page import="com.javalec.ex.MemberDto"%>
<%@page import="com.javalec.ex.MemberDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% 
	String id=request.getParameter("id");
	String pw=request.getParameter("pw");
	
	
	MemberDao mdao=MemberDao.getInstance();
	int check=mdao.userCheck(id,pw); //리턴값 0,1,-1
	if(check==-1){
%>    
  <script type="text/javascript">
		alert('아이디가 존재하지않습니다');
		history.back();
	</script>
<%}
	else if(check==0){
		%>
	<script type="text/javascript">
		alert('패스워드가 일치하지 않습니다');
		history.back();
	</script>
		
		
	<%	
	}else if(check==1){
	MemberDto mdto=mdao.getMember(id);
	session.setAttribute("id", id);
	session.setAttribute("pw", pw);
	session.setAttribute("name", mdto.getName());
	session.setAttribute("authUser", id);
	response.sendRedirect("main.jsp");
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