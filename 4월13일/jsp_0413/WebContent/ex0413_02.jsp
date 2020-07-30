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
	int employee_id;
	float salary;
	String emp_name,job_id=null;
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
// 		String in2=request.getParameter("id");
		//아이디 역순 검색
// 		String sql="select*from member where id like '%"+in2+"%' order by id desc";

		//employees활용
// 		String sql="select employee_id,job_id,emp_name,salary from employees order by employee_id asc";
		
		//employees활용 >>salary 5000-10000
// 		String sql="select employee_id,job_id,emp_name,salary from employees where salary between 5000 and 10000 order by salary asc";
		String num1=request.getParameter("num1");
		String num2=request.getParameter("num2");
		//between 구문
		String sql="select employee_id,job_id,emp_name,salary from employees where salary between "+num1+" and "+num2+" order by salary asc";

		//String sql="select employee_id,job_id,emp_name,salary from employees where salary >="+num1+" and salary<="+num2+" order by salary asc";
		rs=stmt.executeQuery(sql);
		
		out.println("<h2>급여범위를입력하세오</h2>");
		
		while(rs.next()){
			employee_id=rs.getInt("employee_id");
			emp_name=rs.getString("emp_name");
			job_id=rs.getString("job_id");
			salary=rs.getFloat("salary");
			
			out.println("사원번호:"+employee_id+" ");
			out.println("사원이름:"+emp_name+" ");
			out.println("월급:"+salary+" ");
			out.println("부서명:"+job_id+" ");
			out.println("<br>");
			
		}
		
		out.println("<a href='form.html'>다시검색</a>");
		
		
	}catch(Exception e){
		//이케하면 오류가 안보인다 out.println(e); 로찍어내면 뭐가 틀렷는지 알수있다.
		out.println(e);
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