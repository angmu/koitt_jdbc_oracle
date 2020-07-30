<%@page import="com.javalec.ex.MemberDto"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.javalec.ex.MemberDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	MemberDao mdao=MemberDao.getInstance();
	ArrayList<MemberDto> list=mdao.getBoard();
	MemberDto mdto=null;
%>    
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<table border="1">
		<tr>
			<th>번호</th>
			<th>제목</th>
			<th>내용</th>
			<th>작성자</th>
			<th>파일이름</th>
			<th>다운로드</th>
		</tr>
<%
	for(int i=0;i<list.size();i++){
			mdto=(MemberDto)list.get(i);
%>
		<tr>
			<td><%=mdto.getB_num() %></td>
			<td><%=mdto.getB_title() %></td>
			<td><%=mdto.getB_content() %></td>
			<td><%=mdto.getB_user() %></td>
			<td><%=mdto.getB_file() %></td>
			<td><a href="upload/<%=mdto.getB_file()%>">파일보기</a></td>
		</tr>
 <%}%>
	</table>
</body>
</html>