<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript">
function check(){
	var n_che=/^[가-힣]*$/;
	var s_che=/^[0-9]*$/;
	var kk=parseInt(form.kor.value);
	var ee=parseInt(form.eng.value);
	var mm=parseInt(form.math.value);
	
	if(form.name.value==""){
		alert('이름을 입력하세오');
		return false;
	}
	if(!(n_che.test(form.name.value))){
		alert('이름은 국문만 가능');
		return false;
	}
	if(form.math.value==""||form.kor.value==""||form.eng.value==""){
		alert('점수를 입력하세오');
		return false;
	}
	if(!(s_che.test(form.math.value))){
		alert('점수는 숫자만 가능');
		return false;
	}
	if(!(s_che.test(form.kor.value))){
		alert('점수는 숫자만 가능');
		return false;
	}
	if(!(s_che.test(form.eng.value))){
		alert('점수는 숫자만 가능');
		return false;
	}
	if(!(kk>=0&&kk<=100&&ee>=0&&ee<=100&&mm>=0&&mm<=100)){
		alert('점수는 0~100점만 가능');
		return false;
	}
	return form.submit();
}
</script>
</head>

<body>
	<form action="ex_05.jsp" name="form" method="post">
		이름:<input type="text" name="name"><br>
		국어:<input type="text" name="kor"><br>
		영어:<input type="text" name="eng"><br>
		수학:<input type="text" name="math"><br>
		<input type="button" onclick="check()" value="전송">
	</form>
</body>
</html>