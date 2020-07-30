<!-- 데이터베이스 연결 -->    
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.Connection" %>
<%@page import="java.sql.Statement" %>
<%@page import="java.sql.ResultSet" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%! 
	Connection conn;
	Statement stmt;
	ResultSet rs;
	
	String driver="oracle.jdbc.driver.OracleDriver";
	String url="jdbc:oracle:thin:@localhost:1521:orcl";
	String uid="ora_user";
	String upw="1234";
	String query="select*from member";

%>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>DB연결</title>
</head>
<body>
<%
	try{
		
		//jdbc 드라이버연결, 오라클 프로그램실행
		Class.forName(driver);
		//connection 연결, 오라클 로그인
		conn=DriverManager.getConnection(url,uid,upw);
		//statement객체 -sql구문입력
		stmt =conn.createStatement();
		//resultSet데이터받음
		rs=stmt.executeQuery(query);
		
		//next()읽어올 데이터가 있는지 확인
		  while(rs.next()){
			  String id=rs.getString("id");
			  String pw=rs.getString("pw");
			  String name=rs.getString("name");
			  String phone=rs.getString("phone");
			  
			  out.println("아이디:"+id);
			  out.println("비번:"+pw);
			  out.println("이름:"+name);
			  out.println("전화번호:"+phone+"<br>");
					  	  
		  }
		
		
		
	}catch(Exception e){
		e.printStackTrace();
	}finally{
		try{
		if(rs!=null)rs.close();
		if(stmt!=null)stmt.close();
		if(conn!=null)conn.close();
		}
		catch(Exception e2){
		e2.printStackTrace();
		}
	}
%>
</body>
</html>