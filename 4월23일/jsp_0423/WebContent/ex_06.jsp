<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fnt"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<!-- for문예제 -->
<%-- 	<c:set var="sum" value="0" /> --%>
<%-- 	<c:forEach var="i" begin="1" end="100" step="1"> --%>
<%-- 		${sum=sum+i } &nbsp; --%>
<%-- 	</c:forEach> --%>
<%-- 	<c:set var="sum" value="0" /> --%>
<!-- 	<table border="1"> -->
<!-- 		<tr> -->
<!-- 			<th>변수 i</th> -->
<!-- 			<th>변수 sum</th> -->
<!-- 			<th>합계</th> -->
<!-- 		</tr> -->
<%-- 		<c:forEach var="i" begin="1" end="100" step="1"> --%>
<!-- 		<tr> -->
<%-- 			<td>${i }</td> --%>
<%-- 			<td>${sum }</td> --%>
<%-- 			<td>${sum=i+sum }</td> --%>
<!-- 		</tr> -->
<%-- 		</c:forEach> --%>
<!-- 	</table> -->
	
<!-- 구구단을 표형식으루 2~5단 -->

<!-- 	<table border="1" style="text-align:center;"> -->
<%-- 		<caption>구구단 2~5단</caption> --%>
<%-- 		<colgroup> --%>
<%-- 			<col width="100px"> --%>
<%-- 			<col width="50px"> --%>
<%-- 		</colgroup> --%>
		
<%-- 	<c:forEach var="i" begin="2" end="5" step="1" > --%>
<!-- 			<tr> -->
<%-- 				<td colspan="2">${i }단</td> --%>
<!-- 			</tr>	 -->
<%-- 		<c:forEach var="j" begin="1" end="9" step="1" > --%>
<!-- 			<tr> -->
<%-- 				<td>${i }*${j }=</td> --%>
<%-- 				<td>${i*j }</td> --%>
<!-- 			</tr> -->
<%-- 		</c:forEach> --%>
	
<%-- 	</c:forEach> --%>
	
	
<!-- 	</table> -->
	
	<table border="1" style="text-align:center;">
		<caption>구구단 2~9단 홀수</caption>
		<colgroup>
			<col width="100px">
			<col width="50px">
		</colgroup>
						<!-- step 은 증가량이다. -->
	<c:forEach var="i" begin="2" end="9" step="1" >
			<tr>
				<td colspan="2">${i }단</td>
			</tr>	
		<c:forEach var="j" begin="1" end="9" step="2" >
			<tr>
				<td>${i }*${j }=</td>
				<td>${i*j }</td>
			</tr>
		</c:forEach>
	
	</c:forEach>
	
	
	</table>
</body>
</html>