<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>아이디 중복검사</title>
<script type="text/javascript">
function idcheck_submit(){
	var id_ch=/^[0-9a-zA-Z]{5,15}$/;
	if(!(id_ch.test(idcheck_form.id_ch.value))){
		alert("아이디를 다시 입력하세요.");
		idcheck_form.id_ch.value="";
		idcheck_form.id_ch.focus();
		return false;
	}
	
	idcheck_form.submit();
}
function return_id(){
	opener.document.getElementById("id").value = document.getElementById("id_ch").value;
	window.close();
}
</script>
</head>
	<body>
		<p>아이디를 입력하세요</p>
		<form action="id_checkok.jsp" name="idcheck_form" method="post">
			<input type="text" name="id_ch" id="id_ch" value="${param.id }">
			<c:if test="${param.check=='1' }">
				<p>중복된 아이디가 있습니다.</p>
			</c:if>
			
			<input type="button" name="id_check" value="중복확인" onclick="idcheck_submit()">
			<!-- 중복되는 아이디 없을때 활성화 -->
			<c:if test="${param.check=='0' }">
			<p>아이디를 사용하실수 있습니다.</p>
			<input type="button" value="입력" onclick="return_id()">
			</c:if>
		</form>
	</body>
</html>