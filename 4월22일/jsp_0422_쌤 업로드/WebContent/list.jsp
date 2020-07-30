<%@page import="com.javalec.ex.BoardDto"%>
<%@page import="com.javalec.ex.BoardDao"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!-- 섹션추가 -->    
<%
  
  ArrayList list = new ArrayList();
  BoardDao bdao = BoardDao.getInstance();
  list = bdao.getBoards();
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
    <th>파일다운로드</th>
  </tr>
  <% for(int i=0;i<list.size();i++){
	  BoardDto bdto = (BoardDto) list.get(i);  
  %>
  <tr>
    <td><a href="update.jsp?b_num=<%= bdto.getB_num() %>"><%= bdto.getB_num() %></a></td>
    <td><%= bdto.getB_title() %></td>
    <td><%= bdto.getB_content() %></td>
    <td><%= bdto.getB_user() %></td>
    <td><a href="upload/<%=bdto.getB_file()%>"><%=bdto.getB_file()%></a></td>
  </tr>  
  <%} %>
</table>
<button onclick="javascript:window.location.href='board.jsp'">글쓰기</button>

</body>
</html>