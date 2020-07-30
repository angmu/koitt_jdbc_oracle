<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
	//uri > /jsp_0424/ex_05.jsp
	String uri=request.getRequestURI();
	//프로젝트명 > /jsp_0424
	String conPath=request.getContextPath();
	//파일이름 > /ex_05.jsp
	String com=uri.substring(conPath.length());
	
	String str="abcdefg";
	String result=str.substring(4); //결과값: efg
%>
</body>
</html>