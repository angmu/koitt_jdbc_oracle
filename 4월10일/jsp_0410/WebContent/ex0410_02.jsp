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

	String id;
	String pw;
	String name;
	int hobby1;
	int hobby2;
	int hobby3;
	int hobby4;
	String gender;
	String address;
%>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
	table{
	width:1000px;
	border-collapse: collapse;
	text-align: center;
	font-size: 20px;
	margin: 0 auto;
	}
	caption{height: 50px; font-size: 30px; font-weight: bold;}
	tr,th,td{border: 1px solid black;}
</style>
</head>
<body>
	
	<table>
		<caption>KOITT 회원정보</caption>
		<tr>
			<th>아이디</th>
			<th>비밀번호</th>
			<th>이름</th>
			<th>취미1</th>
			<th>취미2</th>
			<th>취미3</th>
			<th>취미4</th>
			<th>성별</th>
			<th>주소</th>
		</tr>
		<%
			
			Class.forName("oracle.jdbc.driver.OracleDriver");
			conn=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl","ora_user","1234");
			stmt=conn.createStatement();
			//이케 찾을수도이따
// 			String sql="select*from member2 where name='홍길동'";
			String sql="select*from member2";
			rs=stmt.executeQuery(sql);
			
			try{
				while(rs.next()){
					id=rs.getString("id");
					pw=rs.getString("pw");
					name=rs.getString("name");
					hobby1=rs.getInt("hobby1");
					hobby2=rs.getInt("hobby2");
					hobby3=rs.getInt("hobby3");
					hobby4=rs.getInt("hobby4");
					gender=rs.getString("gender");
					address=rs.getString("address");
				
					out.println("<tr>");
					out.println("<td>"+id+"</td>");
					out.println("<td>"+pw+"</td>");
					out.println("<td>"+name+"</td>");
					out.println("<td>"+hobby1+"</td>");
					out.println("<td>"+hobby2+"</td>");
					out.println("<td>"+hobby3+"</td>");
					out.println("<td>"+hobby4+"</td>");
					out.println("<td>"+gender+"</td>");
					out.println("<td>"+address+"</td>");
					out.println("</tr>");
				}
				
			}catch(Exception e){
				e.printStackTrace();
			}finally{
				try{
					if(rs!=null) rs.close();
					if(stmt!=null) stmt.close();
					if(conn!=null) conn.close();
				}catch(Exception e2){
					e2.printStackTrace();
				}
			}
		%>
		</table>
	</body>
</html>



