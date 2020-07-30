<%@page import="java.sql.Timestamp"%>
<%@page import="com.javalec.ex.MemDto"%>
<%@page import="java.util.ArrayList"%>
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
<h2>회원정보 리스트</h2>
<p><a href="insert.jsp">회원정보추가</a></p>
<table border="1">
	<tr>
		<th>회원번호</th>
		<th>아이디</th>
		<th>비밀번호</th>
		<th>이름</th>
		<th>이메일</th>
		<th>주소</th>
		<th>전화번호</th>
		<th>생년월일</th>
		<th>성별</th>
		<th>뉴스레터 수신여부</th>
		<th>SMS 수신여부</th>
		<th>가입일자</th>
	</tr>
<%
	MemDao m_dao=new MemDao();
	ArrayList dtos;
	MemDto mdto;
	int m_num;
	Timestamp birth,m_date;
	String m_id,pw,m_name,email,address,phone,gender,news,sms;
	
	dtos=m_dao.select();	
	for(int i=0;i<dtos.size();i++){
		mdto=(MemDto)dtos.get(i);
		m_num=mdto.getM_num();
		m_id=mdto.getM_id();
		pw=mdto.getPw();
		m_name=mdto.getM_name();
		email=mdto.getEmail();
		address=mdto.getAddress();
		phone=mdto.getPhone();
		birth=mdto.getBirth();
		gender=mdto.getGender();
		news=mdto.getNews();
		sms=mdto.getSms();
		m_date=mdto.getM_date();
		
%>		
	<tr>
		<td><a href="#"><%=m_num %></a></td>
		<td><%=m_id %></td>
		<td><%=pw %></td>
		<td><%=m_name %></td>
		<td><%=email %></td>
		<td><%=address %></td>
		<td><%=phone %></td>
		<td><%=birth %></td>
		<td><%=gender %></td>
		<td><%=news %></td>
		<td><%=sms %></td>
		<td><%=m_date %></td>
	</tr>
<%		
	}
%>






</table>
</body>
</html>