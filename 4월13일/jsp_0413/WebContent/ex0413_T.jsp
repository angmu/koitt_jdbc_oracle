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
	String emp_name,job_id,sql=null;
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

		String s_check=request.getParameter("search");
		
		switch(s_check){
		//이름검색
		case "name_search" :
			String name1= request.getParameter("input1");
			sql="select employee_id,job_id,emp_name,salary from employees where emp_name like '%"+name1+"%' order by employee_id asc";
			break;
		//월급검색	
		case "salary_search" :
			String input1=request.getParameter("input1");
			String input2=request.getParameter("input2");
			//between 구문
			sql="select employee_id,job_id,emp_name,salary from employees where salary between "+input1+" and "+input2+" order by salary asc";

			break;
		
		}
		
		
			rs=stmt.executeQuery(sql);
		
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
		
		
		
		out.println("<a href='form3.html'>다시검색</a>");
		
		
	}catch(Exception e){
		//이케하면 오류가 안보인다 out.println(e); 로찍어내면 뭐가 틀렷는지 알수있다.
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