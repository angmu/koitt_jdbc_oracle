<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>관리자 페이지</title>
		<jsp:include page="common/config.jsp"/>
	</head>
	<body>
		<c:if test="${lcheck==0 }">
			<script>
				alert("권한이 없거나 정보가 틀립니다.");
				history.back(-1);
			</script>
		</c:if>
		<c:if test="${banner_check==1}">
		<script type="text/javascript">
			 alert("저장이 정상적으로 완료되었습니다.");
		</script>
		</c:if>
		<c:if test="${banner_check==0}">
			<script type="text/javascript">
			     alert("저장이 정상적으로 이루어지지 않았습니다. 다시 시도해 주세요.");
				 history.back(-1);
			</script>
		</c:if>
		<jsp:include page="common/admin_top-nav.jsp"/>
		<section>
			<h1 style="text-align: center; margin-top: 40px;"> 관리자 메인 </h1>
			<div id="main_list" style="width:600px; margin: 0 auto; margin-top:40px;">
			<img alt="" src="img/logo2.jpg" width="600px" height="300px">
				
			</div>
		</section>
	</body>
</html>