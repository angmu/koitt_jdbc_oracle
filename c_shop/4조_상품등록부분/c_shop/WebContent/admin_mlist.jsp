<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Insert title here</title>
		<link rel="stylesheet" href="css/style_admin_mlist.css">
		<jsp:include page="common/config.jsp" />
	</head>
	<body>
		<jsp:include page="common/admin_top-nav.jsp" />
		<section>
		    <h1>회원관리</h1>
		
		    <article id="event_list">
		      <table border="1" id="member_list">
				    <tr>
						<th>회원 아이디</th>
						<th>비밀번호</th>
						<th>이름</th>
						<th>이메일</th>
						<th>주소</th>
						<th>휴대전화</th>
						<th>생년월일</th>
						<th>성별</th>
						<th>뉴스레터 수신여부</th>
						<th>SMS 수신여부</th>
				    </tr>
					<c:forEach var="mdto" items="${list }">
						<tr>
							<td><a href="stu_modify.jsp?id=${mdto.getId() }">${mdto.getId() }</a></td>
							<td>${mdto.getPw() }</td>
							<td>${mdto.getName() }</td>
							<td>${mdto.getEmail_head()} @ ${mdto.getEmail_tail() }</td>
							<td>${mdto.getAddress() }</td>
							<td>${mdto.getPhone_head()} - ${mdto.getPhone_mid()} - ${mdto.getPhone_tail() }</td>
							<td>${mdto.getBirth() }</td>
							<td>${mdto.getGender() }</td>
							<td>${mdto.getNews() }</td>
							<td>${mdto.getSms() }</td>
						</tr>
				 	</c:forEach>			
			    </table>
		    </article>
		</section>
	</body>
</html>