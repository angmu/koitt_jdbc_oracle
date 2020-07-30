<%@page import="com.javalec.ex.MemberDto"%>
<%@page import="com.javalec.ex.MemberDao"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%--섹션이 있는지 확인해서 없으면 로그인하게 보냄 --%>
<% 
	if(session.getAttribute("authUser")==null){
%>		
	<script>
		alert('로그인을 하지않음');
		location.href='login.jsp';
	</script>
<%-- 	<jsp:forward page="login.jsp"/>	 --%>
	<%}
%>    
<%
	ArrayList<MemberDto> list=new ArrayList<MemberDto>();
	String id=(String)session.getAttribute("id");
	MemberDao mdao=MemberDao.getInstance();
	list=mdao.getMembers();

%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h2>관리자페이지</h2>
	<p><%=session.getAttribute("name") %>님 로그인하였습니다.</p>
	<p><a href="logout.jsp">로그아웃</a></p>
	<table border="1">
		<tr>
			<th>아이디</th>
			<th>패스워드</th>
			<th>이름</th>
			<th>이메일</th>
			<th>주소</th>
			<th>가입일</th>
		</tr>
		<%
		for(int i=0;i<list.size();i++){
			MemberDto mdto=list.get(i);
		%>
		<tr>
			<td><a href="modify.jsp?id=<%=mdto.getId() %>"><%=mdto.getId() %></a></td>
			<td><%=mdto.getPw() %></td>
			<td><%=mdto.getName() %></td>
			<td><%=mdto.getEmail() %></td>
			<td><%=mdto.getAddress() %></td>
			<td><%=mdto.getD_date() %></td>
		</tr>
		<%
		}
		%>
	</table>

</body>
</html>