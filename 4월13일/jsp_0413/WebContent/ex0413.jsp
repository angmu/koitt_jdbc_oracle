<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%!
	Connection conn;
	Statement stmt;
	ResultSet rs;
	
	String id,pw,name,phone=null;
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>DB연결</title>
</head>
<body>
	<%
	request.setCharacterEncoding("utf-8");
	try{
		Class.forName("oracle.jdbc.driver.OracleDriver");
		conn=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl","ora_user","1234");
		stmt=conn.createStatement();
		//이름
// 		String in1=request.getParameter("name");
// 		String sql="select*from member where name like '%"+in1+"%'";
		//아이디
		String in2=request.getParameter("id");
		//아이디 역순 검색
// 		String sql="select*from member where id like '%"+in2+"%' order by id desc";

		String sql="select*from member where id like '%"+in2+"%' order by id desc";
		rs=stmt.executeQuery(sql);
		
		out.println("<h2>회원정보</h2>");
		
		while(rs.next()){
			id=rs.getString("id");
			pw=rs.getString("pw");
			name=rs.getString("name");
			phone=rs.getString("phone");
			
			out.println("아이디:"+id+" ");
			out.println("비밀번호:"+pw+" ");
			out.println("이름:"+name+" ");
			out.println("전화번호:"+phone+" ");
			out.println("<br>");
			
		}
		
		out.println("<a href='form.html'>다시검색</a>");
		
		
	}catch(Exception e){
		e.printStackTrace();
	}finally{
		try{
			if(rs!=null) rs.close();
			if(stmt!=null)stmt.close();
			if(conn!=null)conn.close();
		}catch(Exception e2){
			e2.printStackTrace();
		}
	}
	%>
</body>
</html>