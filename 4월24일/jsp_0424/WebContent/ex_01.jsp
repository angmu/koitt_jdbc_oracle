<%@page import="com.javalec.ex.Login"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
    <%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
    <%@taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<!-- 오후추가 -->
<h2>function출력</h2>
<c:set var="test1" value="function test"/>
입력된문자:${test1}<br>
대문자변환:${fn:toUpperCase(test1) }<br>

<c:set var="test2" value="        name:홍       길동         "/>
공백포함:${test2}<br>
공백제거:${fn:trim(test2) }<br>
<c:if test="${fn:contains(test2,'동')==true }">
이름:${fn:trim(test2) }, 당신의 이름에는 길이라는 이름이 포함되어있습니다.
</c:if>
<c:if test ="${fn:contains(test2,'동')!=true }">
이름:${fn:trim(test2) }, 당신의 이름에는 길이라는 이름이 포함되어있지 않습니다.
</c:if>

<!--  -->
<br>
<hr>

<h2>지정된 지역출력</h2>
<c:forEach var="item" items="서울,부산,경기,인천,대전">
	지역:${item }<br>
</c:forEach>

<!-- item에 객체가 들어가면 이렇게 출력. -->
<!-- 지역:서울 -->
<!-- 지역:부산 -->
<!-- 지역:경기 -->
<!-- 지역:인천 -->
<!-- 지역:대전 -->
<hr>
<%
	ArrayList list=new ArrayList();
// MemberDao mdao=MemberDao.getInstance();		
// list=mdao.getInstance();
	Login log=null;
	for(int i=0;i<5;i++){
		log= new Login();	
		log.setNum(i+1);
		log.setId("admin"+i);//admin0,admin1,admin2....
		log.setPw("abc"+i);
		list.add(log);
	}
	request.setAttribute("test", list);
%>
	<h2>ArrayList출력</h2>
	<table border="1">
	<tr>
		<th>번호</th>
		<th>아이디</th>
		<th>패스워드</th>
	</tr>
	<c:forEach var="dto" items="${test }">
	<tr>
		<th>${dto.getNum() }</th>
		<th>${dto.getId() }</th>
		<th>${dto.getPw() }</th>
	</tr>
	</c:forEach>
	</table>




<hr>
<c:set var="sum" value="0"/>
<c:forEach var="i" begin="0" end="10" step="1">
	${sum= sum+i }<br>
</c:forEach>

</body>
</html>