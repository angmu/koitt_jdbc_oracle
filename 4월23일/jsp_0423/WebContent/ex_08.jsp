<%@page import="java.util.Date"%>
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
<c:set var="money1" value="10000000000"/>
<jsp:useBean id="t_date" class="java.util.Date"/>
<h2>현재날짜:<fmt:formatDate value="${t_date }" pattern="yyyy/MM/dd"/></h2>
날짜와 시간을 같이 출력-both:<fmt:formatDate value="<%=new Date() %>" type="both"/><br>
날짜만 출력-date:<fmt:formatDate value="<%=new Date() %>" type="date"/><br>
시간만 출력-time:<fmt:formatDate value="<%=new Date() %>" type="time"/><br>
<hr>

<!-- 1000단위 쉼표 -->
<fmt:formatNumber value="${money1 }" groupingUsed="true"/><br>
<!-- 0으로 패턴하면 부족한 자릿수에 0부터 나오고 # 으로하면 나오지않는다. 소숫점아래 자릿수부족시 반올림-->
<fmt:formatNumber value="3.1548564" pattern="00.###"/><br>
<fmt:formatNumber value="1" pattern="0000"/><br>
<fmt:formatNumber value="342.155" pattern="#####.#"/><br>
<fmt:formatNumber value="34256666.151" pattern="#####"/><br>

</body>
</html>