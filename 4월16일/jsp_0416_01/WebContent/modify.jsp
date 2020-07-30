<%@page import="java.sql.Timestamp"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.PreparedStatement"%>
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
	PreparedStatement pstmt=null;
	ResultSet rs=null;
	String id,pw,name,email,address,phone,gender,news,sms;
	Timestamp birth;
	String sql;
	int check;
%>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%
	
	try{
		//main.jsp?id='id'파라미터값
		id=request.getParameter("id");
// 		out.println(id);
		sql="select * from lms_member where id=?";
// 		out.println(sql);
		Class.forName("oracle.jdbc.driver.OracleDriver");
		con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl","ora_user","1234");
		pstmt=con.prepareStatement(sql);
		pstmt.setString(1, id);
		rs=pstmt.executeQuery();
// 		out.println(rs);
		while(rs.next()){
			pw=rs.getString("pw");
			name=rs.getString("name");
			email=rs.getString("email");
			address=rs.getString("address");
			phone=rs.getString("phone");
			//birth주의
			birth=rs.getTimestamp("birth");
			gender=rs.getString("gender");
			news=rs.getString("news");
			sms=rs.getString("sms");
			%>
			
			<h2>회원정보수정</h2>
	<form action="Modify_Ok" name="modify" method="post">
<!-- 	//readonly> 값을 넘김,disable 값을 안넘김 혹은 hidden 으로 넘겨도된다... -->
	아이디:<input type="text" name="id" value=<%=id %> readonly="readonly"><br>
	패스워드:<input type="password" name="pw" value=<%=pw %>><br>
	패스워드확인:<input type="password" name="pw2"><br>
	이름:<input type="text" name="name" value=<%=name %>><br>
	이메일:<input type="email" name="email" value=<%=email %>><br>
	주소:<input type="text" name="address" value=<%=address %>><br>
	전화번호:<input type="text" name="phone" value=<%=phone %>><br>
	생일:<input type="date" name="birth" value=<%=birth %>><br>
	<p>성별</p>
	<%
	switch(gender){
	case "남성":
		
		%>
		<input type="radio" name="gender" value="남성" checked="checked"> 남성
		<input type="radio" name="gender" value="여성"> 여성<br>
		<%
		
		break;
	case "여성":
		%>
		<input type="radio" name="gender" value="남성"> 남성
		<input type="radio" name="gender" value="여성" checked="checked"> 여성<br>
		<%
		break;
	}
	
	%>
	
	<p>뉴스레터 수신 여부</p>
	<%
	switch(news){
	case "예":
		
		%>
		<input type="radio" name="news" value="예" checked="checked"> 예
		<input type="radio" name="news" value="아니오"> 아니오<br>
		<%
		
		break;
	case "아니오":
		%>
		<input type="radio" name="news" value="예"> 예
		<input type="radio" name="news" value="아니오" checked="checked"> 아니오<br>
		<%
		break;
	}
	
	%>
	<p>SMS 수신 여부</p>
	<%
	switch(sms){
	case "예":
		
		%>
		<input type="radio" name="sms" value="예" checked="checked"> 예
		<input type="radio" name="sms" value="아니오"> 아니오<br>
		<%
		
		break;
	case "아니오":
		%>
		<input type="radio" name="sms" value="예"> 예
		<input type="radio" name="sms" value="아니오" checked="checked"> 아니오<br>
		<%
		break;
	}
	
	%>
	<input type="submit" value="수정하기">
	<input type="button" onclick="history.back(-1)" value="취소">
	</form>
			
			
			
			<%
		}//while문 종료
		
	}catch(Exception e){
		e.printStackTrace();
	}finally{
		try{
		if(rs!=null)rs.close();
		if(pstmt!=null)pstmt.close();
		if(con!=null)con.close();
	}catch(Exception e2){
		e2.printStackTrace();
		}
		}

	
	%>
	
</body>
</html>