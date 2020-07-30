<%@page import="com.javalec.ex.Login"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%
	ArrayList list=new ArrayList();
	Login log=null;
	for(int i=0;i<5;i++){
		log= new Login();	
		log.setNum(i+1);
		log.setId("admin"+i);//admin0,admin1,admin2....
		log.setPw("abc"+i);
		list.add(log);
	}
	//ArrayList보내기
	request.setAttribute("test", list); //request1
%>
	<%
		//class 객체 1개 보내기
		Login lo1=new Login(90,"naver","12345");
		request.setAttribute("ldto", lo1);//request5
		
	%>



	<%
		request.setAttribute("user_id", "admin");//request2
		request.setAttribute("user_pw", "1234");//request3
		request.setAttribute("user_name", "홍길동");//request4
		
		//이걸로 보내면 넘어간 페이지에서 request가 유지되어 정상적으로 뜬다.
		RequestDispatcher dispatcher=request.getRequestDispatcher("/result.jsp");
		dispatcher.forward(request, response);
	%>
</body>
</html>