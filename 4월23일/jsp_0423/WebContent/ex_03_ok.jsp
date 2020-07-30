<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <!-- 자바빈 선언전에 리퀘스트 인코딩 하는거이 나음 -->
   <%request.setCharacterEncoding("utf-8");%>
<jsp:useBean id="ldto" class="com.javalec.ex.MemberInfo"/>
<jsp:setProperty property="*" name="ldto"/>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h2>EL태그 사용1:자바빈</h2>
	이름: ${ldto.name }<br>
	아이디: ${ldto.id }<br>
	비밀번호: ${ldto.pw }<br>
	
	<!-- request 혹은 자바빈을 안써도 가능!! -->
	<h2>EL태그 사용2 :파람</h2>
	이름: ${param.name }<br>
	아이디: ${param.id }<br>
	비밀번호: ${param.pw }<br>
	
	-----------------------------<br>
	<h2>스크립트릿</h2>
	<!-- 디자이너가 쓰기에는 힘듬.. -->
	이름: <%=request.getParameter("name") %><br>
	아이디:<%=request.getParameter("id") %><br>
	비밀번호:<%=request.getParameter("pw") %><br>
	
	-----------------------------<br>
	<h2>내장객체:application</h2>
	<!-- 디자이너가 쓰기에는 힘듬.. -->
	applicationScope아이디:  ${applicationScope.appUser_id }<br>
	sessionScope아이디: ${sessionScope.sessUser_id }<br>
	
	<!-- 결과값에서 아래 2개는 뜨지 않는다. -->
	pageScope아이디: ${pageScope.pageUser_ide }<br>
	requestScope아이디: ${requestScope.reqUser_ide }<br>
</body>
</html>