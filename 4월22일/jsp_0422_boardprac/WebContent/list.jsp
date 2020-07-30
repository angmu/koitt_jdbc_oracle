<%@page import="com.javalec.ex.BoardDao"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.javalec.ex.BoardDto"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    <%
    BoardDao bdao=BoardDao.getInstance();
    ArrayList list=bdao.getBoards();
    BoardDto bdto=null;
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
			<th>다운로드</th>
		</tr>
<%
	for(int i=0;i<list.size();i++){
			bdto=(BoardDto)list.get(i);
%>
		<tr>
<%-- 		<td><a href="modify.jsp?b_num=<%=bdto.getB_num()%>"><%=bdto.getB_num() %></a></td> --%>
			<td><a href="update.jsp?b_num=<%=bdto.getB_num()%>"><%=bdto.getB_num() %></a></td>
			<td><%=bdto.getB_title() %></td>
			<td><%=bdto.getB_content() %></td>
			<td><%=bdto.getB_user() %></td>
			<td><a href="upload/<%=bdto.getB_file()%>"><%=bdto.getB_file()%></a></td>
		</tr>
 <%
 }
 %>
	</table>
	<button onclick="javascript:window.location.href='board.jsp'">글쓰기</button>
</body>
</html>