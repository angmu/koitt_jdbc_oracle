<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h2>스크립트릿</h2>
	<%=10 %><br>
	<%=99.99 %><br>
	<%="abc" %><br>
	<%=true %><br>
	<%=1+2 %><br>
	<%=1-2 %><br>
	<%=1*2 %><br>
	<%=1/2 %><br>
	<%=1>2 %><br>
	<%=1<2 %><br>
	<%=(1>2)?1:2 %><br>
	
	
<!-- 	아래처럼 표현 -->
	<h2>el태그</h2>
	${10 }<br>
	${99.99 }<br>
	${"abc" }<br>
	${true}<br>
	${1+2 }<br>
	${1-2 }<br>
	${1*2 }<br>
	${1/2 }<br>
	${1>2 }<br>
	${1<2 }<br>
	${(1>2)?1:2}<br>
</body>
</html>