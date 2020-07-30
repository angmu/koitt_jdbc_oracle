<%@page import="com.javalec.ex.MemberDto"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.javalec.ex.MemberDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	//로그인체크
	if(session.getAttribute("authUser")==null){
%>
	<script type="text/javascript">
		alert('권한이 없습니다. 로그인해주세요');
		window.location.href='login.jsp';
	</script>
<%		
	}
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
	<h2>관리자 페이지</h2>
	<p><%=session.getAttribute("name") %>님 환영합니다</p>
	<p><a href="logout.jsp">로그아웃</a></p>
	<table border="1">
		<tr>
			<th>아이디</th>
			<th>패스워드</th>
			<th>이름</th>
			<th>이메일</th>
			<th>우편번호</th>
			<th>주소</th>
			<th>나머지주소</th>
			<th>가입일</th>
			<th>최종업데이트일</th>
		</tr>
<%
	for(int i=0;i<list.size();i++){
%>		
		<tr>
			<td><%=list.get(i).getId() %></td>
			<td><%=list.get(i).getPw() %></td>
			<td><%=list.get(i).getName() %></td>
			<td><%=list.get(i).getEmail() %></td>
			<td><%=list.get(i).getAddress1() %></td>
			<td><%=list.get(i).getAddress2() %></td>
			<td><%=list.get(i).getAddress3() %></td>
			<td><%=list.get(i).getB_date() %></td>
			<td><%=list.get(i).getU_date() %></td>
		</tr>

<%		
	}
%>		
	</table>
</body>
</html>