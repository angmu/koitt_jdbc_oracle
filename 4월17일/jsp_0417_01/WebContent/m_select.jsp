<%@page import="com.javalec.ex.MemberDao"%>
<%@page import="com.javalec.ex.MemberDto"%>
<%@page import="java.util.ArrayList"%>
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
	<table border="1">
		<tr>
			<th>아이디</th>
			<th>패스워드</th>
			<th>이름</th>
			<th>전화번호1</th>
			<th>전화번호2</th>
			<th>전화번호3</th>
			<th>성별</th>
		</tr>
<%
	MemberDao mdao=new MemberDao();	
	ArrayList dtos;
	MemberDto mdto;
	String id,pw,name,phone1,phone2,phone3,gender;
	
	dtos=mdao.member_Select();
	
	for(int i=0;i<dtos.size();i++){
		mdto=(MemberDto)dtos.get(i);
		id=mdto.getId();
		pw=mdto.getPw();
		name=mdto.getName();
		phone1=mdto.getPhone1();
		phone2=mdto.getPhone2();
		phone3=mdto.getPhone3();
		gender=mdto.getGender();
%>		
		<tr>
			<td><a href="#"><%=id %></a></td>
			<td><%=pw %></td>
			<td><%=name %></td>
			<td><%=phone1 %></td>
			<td><%=phone2 %></td>
			<td><%=phone3 %></td>
			<td><%=gender %></td>
		</tr>	
<%		
	}
%>
	</table>
</body>
</html>