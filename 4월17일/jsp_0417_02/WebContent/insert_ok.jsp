<%@page import="com.javalec.ex.MemDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<!-- 데이터 입력된 값을 모두 메소드로 전송 -->
<%! 
String m_id,pw,m_name,email,address,phone,birth,gender,news,sms="";
%>
<%
	request.setCharacterEncoding("utf-8");
	MemDao mdao=new MemDao();
	
	m_id=request.getParameter("m_id");
	pw=request.getParameter("pw");
	m_name=request.getParameter("m_name");
	email=request.getParameter("email");
	address=request.getParameter("address");
	phone=request.getParameter("phone");
	birth=request.getParameter("birth");
	gender=request.getParameter("gender");
	news=request.getParameter("news");
	sms=request.getParameter("sms");

	int check=mdao.insert(m_id, pw, m_name, email, address, phone, birth, gender, news, sms);
	switch(check){
	
	case 1:
		response.sendRedirect("select_m3.jsp");
		break;

	case 0:
		response.sendRedirect("insert_form.jsp");
		break;
	}

%>
<!-- 리턴값 체크해서 1이면 m_select.jsp 리 다이렉트, 안되면 다시 폼 -->
</body>
</html>