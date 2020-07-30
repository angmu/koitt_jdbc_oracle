<%@page import="com.javalec.ex.MemberDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%request.setCharacterEncoding("utf-8"); %>
    <jsp:useBean id="mdto" class="com.javalec.ex.MemberDto"/>
    <jsp:setProperty property="*" name="mdto"/>
    <%
    String id=mdto.getId();
    MemberDao mdao=MemberDao.getInstance();
    int check=mdao.updateMember(mdto);
    if(check==1){
    	//수정성공
    %>
    <script>
    	alert('회원정보 수정완료');
    	window.location.href='main.jsp';
    </script>
    <%	
    }else{
   %> 
    <script>
    	alert('회원정보 수정실패');
    	history.back();
    </script>
   	
    <%	
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