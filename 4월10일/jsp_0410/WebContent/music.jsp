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
	String kind;
	String code;
	String p_name;
	String rental;
	int warrenty;
	String phone;
	String warrenty_txt;


%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
table{
 width:800px;
 margin: 50px auto;
 border-collapse: collapse;
 text-align: center;
 font-size: 20px;
}
caption{
font-size:30px; height: 50px;}
td,th,tr{
	border: 1px solid black;
}

</style>
</head>
<body>
	<table>
		<caption>KOITT악기상 대여일지</caption>
		<tr>
			<th>상품구분</th>
			<th>상품코드</th>
			<th>상품명</th>
			<th>임대인</th>
			<th>보증여부</th>
			<th>연락처</th>
		</tr>
		<%
			Class.forName("oracle.jdbc.driver.OracleDriver");
			conn=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl","ora_user","1234");
			stmt=conn.createStatement();
			rs=stmt.executeQuery("select * from instrument");
			
			try{
				while(rs.next()){
					kind=rs.getString("kind");
					code=rs.getString("code");
					p_name=rs.getString("p_name");
					rental=rs.getString("rental");
					warrenty=rs.getInt("warrenty");
					switch(warrenty){
					case 1:
						warrenty_txt="보증인 있음";
						break;
					
					case 0:
						warrenty_txt="보증인 없음";
						break;
						
					}
					phone=rs.getString("phone");
					
					out.println("<tr>");
					out.println("<td>"+kind+"</td>");
					out.println("<td>"+code+"</td>");
					out.println("<td>"+p_name+"</td>");
					out.println("<td>"+rental+"</td>");
					out.println("<td>"+warrenty_txt+"</td>");
					out.println("<td>"+phone+"</td>");
					out.println("</tr>");
					
				}
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
	</table>
</body>
</html>