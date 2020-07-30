<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.Timestamp"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

	<% 
	//체크안하면안된다리 'ㅁ'!!
	response.setCharacterEncoding("utf-8");
	String authUser=(String)session.getAttribute("authUser");
	if(authUser==null){
		String str;
		//서블릿과 달리 이미 html선언이 되어있음
		   str="<script type=\"text/javascript\">\r\n" + 
		     "      alert(\"로그인을 하지않았습니다. 로그인페이지로 이동합니다.\");\r\n" + 
		     "      location.href='login.jsp';\r\n" + 
		     "   </script>";
		out.println(str);
	}
	%>
   <%!
   Connection con=null;
   Statement stmt=null;
   ResultSet rs=null;
   String id,pw,name,email,address,phone,gender,news,sms;
   String sql;
   //날짜를 받는 객체
   Timestamp birth;
   %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h2>회원전체리스트</h2>
	<p><a href="join.jsp">회원정보추가</a></p>
	<table border="1">
		<tr>
			<th>회원아이디</th>
			<th>패스워드</th>
			<th>이름</th>
			<th>이메일</th>
			<th>주소</th>
			<th>휴대전화</th>
			<th>생년월일</th>
			<th>성별</th>
			<th>이메일수신여부</th>
			<th>SMS수신여부</th>
		</tr>


<%
	
	try {
		//db연결부분
		sql="select * from lms_member";
		Class.forName("oracle.jdbc.driver.OracleDriver");
		con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl","ora_user","1234");
		stmt=con.createStatement();
		rs=stmt.executeQuery(sql);
		//id,pw데이터
		while(rs.next()){
			id=rs.getString("id");
			pw=rs.getString("pw");
			name=rs.getString("name");
			email=rs.getString("email");
			address=rs.getString("address");
			phone=rs.getString("phone");
			//날짜변수
			birth=rs.getTimestamp("birth");
			gender=rs.getString("gender");
			news=rs.getString("news");
			sms=rs.getString("sms");
%>			
		<tr>
			<td><a href="modify.jsp?id=<%=id %>"><%=id %></a></td>
			<td><%=pw %></td>
			<td><%=name %></td>
			<td><%=email %></td> 
			<td><%=address %></td>
			<td><%=phone %></td>
			<td><%=birth %></td>
			<td><%=gender %></td>
			<td><%=news %></td>
			<td><%=sms %></td>
		</tr>
		
<%
	}//while 마지막

	}catch(Exception e) {
		e.printStackTrace();
		}finally {
			try{
				if(rs!=null)rs.close();
				if(stmt!=null)stmt.close();
				if(con!=null)con.close();
			}catch(Exception e2) {
				e2.printStackTrace();
				}
	}
	


%>

	</table>
</body>
</html>