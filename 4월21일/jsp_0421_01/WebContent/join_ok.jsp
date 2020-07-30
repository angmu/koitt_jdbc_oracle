<%@page import="com.javalec.ex.MemberDao"%>
<%@page import="java.sql.Timestamp"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	request.setCharacterEncoding("utf-8");
	response.setCharacterEncoding("utf-8");
%>    
<jsp:useBean id="mdto" class="com.javalec.ex.MemberDto"/>
<jsp:setProperty property="*" name="mdto"/>
<%
//   아래꺼를 위처럼 간단하게 가능
//   MemberDto mdto=new MemberDto();
//   mdto.setId(request.getParameter("id"));
//   mdto.setPw(request.getParameter("pw"));
	
	//현재시간을 자바에서 입력
// 	mdto.setD_date(new Timestamp(System.currentTimeMillis()));

	//-------------------
	
	MemberDao mdao=MemberDao.getInstance();
	int check=mdao.confirmId(mdto.getId());
	if(check==1){
		//중복아이디가 있을경우
%>		
		<script>
			alert('아이디 존재, 다시 입력하세오');
			history.back();
		</script>
<%		
	}else{
		//중복아이디없음
	int ch=mdao.insertMember(mdto);
		if(ch==1){
			//데이터 저장완료
%>
		<script>
			alert('회원가입이 완료되었습니다');
			window.location.href="login.jsp";
		</script>
			
<%	}else{
			//데이터 저장실패
%>
		<script>
			alert('저장실패, 다시 시도해주세요');
			history.back();
		</script>	
<%
		}
	}
%>
    
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

</body>
</html>