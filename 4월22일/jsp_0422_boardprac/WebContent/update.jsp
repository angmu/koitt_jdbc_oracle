<%@page import="java.net.URLEncoder"%>
<%@page import="com.javalec.ex.BoardDao"%>
<%@page import="com.javalec.ex.BoardDto"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	int b_num=Integer.parseInt(request.getParameter("b_num"));
	BoardDao bdao=BoardDao.getInstance();
	BoardDto bdto=bdao.getBoard(b_num);
%>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="update_ok2.jsp" name="board" method="post" enctype="multipart/form-data">
		<!-- 숨겨놓고 파라미터로 보내믄된다 '0' -->
		<input type="hidden" name="b_num" value="<%=bdto.getB_num() %>">
		제목:<input type="text" name="b_title" value="<%=bdto.getB_title() %>"><br>
		작성자:<input type="text" name="b_user" value="<%=bdto.getB_user() %>" readonly="readonly" ><br>
		내용:<br><textarea rows="30" cols="40" name="b_content" ><%=bdto.getB_content() %></textarea><br>
		기존파일:<input type="text" name="old_file" value="<%=bdto.getB_file() %>" readonly="readonly"><br>
		파일첨부:<input type="file" name="b_file"><br>
		<input type="submit" value="저장">
		<input type="button" value="취소" onclick="javascript:window.location.href='list.jsp'">
	</form>
</body>
</html>