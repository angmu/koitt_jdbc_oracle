<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%!
	//밖으로 꺼낸이유 >>try catch문 안에서 선언하면.. finally에서 사용이 불가한다..엉엉
	Connection conn;
	Statement stmt;
	ResultSet rs;
	
	int s_number;
	int s_grade;
	String s_name;
	String payok;
	String s_subject;
	int s_price;
	String payway;


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
		<caption>KOITT학교 학생 현황</caption>
		<tr>
			<th>번호</th>
			<th>학년</th>
			<th>이름</th>
			<th>납부여부</th>
			<th>과목</th>
			<th>금액</th>
			<th>납부유형</th>		
		</tr>
		<%
			//jdbc 연결
			Class.forName("oracle.jdbc.driver.OracleDriver");
			//connection연결	
			conn=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl","ora_user","1234");
			//sql구문실행용 객체생성
			stmt=conn.createStatement();
			//sql query구문
			String sql="select * from member3";
			//sql구문을 실행후 rs로 객체 받음
			rs=stmt.executeQuery(sql);
			
			try{
				while(rs.next()){
					s_number=rs.getInt("s_number");
					s_grade=rs.getInt("s_grade");
					s_name=rs.getString("s_name");
					payok=rs.getString("payok");
					//만약 숫자였다면.. 
// 					String pay_text;
// 					switch(payok){
					
// 					case 1:
// 						pay_text="예";
// 						break;
// 					case 0:
// 						pay_text="아니오";
// 						break;
					
// 					} //요런식으로 고쳐주고 찍을때는 out.pringln(pay_text) 형태로 찍어야함 :>
					
					
					s_subject=rs.getString("s_subject");
					s_price=rs.getInt("s_price");
					payway=rs.getString("payway");
					
					out.println("<tr>");
					out.println("<td>"+s_number+"</td>");
					out.println("<td>"+s_grade+"</td>");
					out.println("<td>"+s_name+"</td>");
					out.println("<td>"+payok+"</td>");
					out.println("<td>"+s_subject+"</td>");
					out.println("<td>"+s_price+"</td>");
					out.println("<td>"+payway+"</td>");
					out.println("</tr>");
					
				}	
			}catch(Exception e){
				e.printStackTrace();
			}finally{
				try{
					if(rs !=null) rs.close();
					if(stmt != null) stmt.close();
					if(conn != null) conn.close();
					
				}catch(Exception e2){
					e2.printStackTrace();
				}
				
			}
			
			
		
		
		%>	
	
	
	</table>
</body>
</html>