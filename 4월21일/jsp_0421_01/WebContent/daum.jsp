<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<script src="https://t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>
<script>
	function openDaumZipAddress(){
	    new daum.Postcode({
	        oncomplete: function(data) {
	      		jQuery("#zonecode").val(data.zonecode);
	      		jQuery("#address").val(data.address);
	      		jQuery("#address_etc").focus();
	        }
	    }).open();
	}
</script>
</head>
<body>
	<form action="join_ok.jsp" name="join" method="post">
		<input type="text" id="zonecode" value="" readonly="readonly">&nbsp;&nbsp;
		<input type="button" onclick="openDaumZipAddress()" value="우편번호찾기"><br>
		
		<input type="text" id="address" value="" readonly="readonly">&nbsp;&nbsp;
		<input type="text" id="address_etc" value="" readonly="readonly" style="width:200px">&nbsp;&nbsp;
	</form>
</body>
</html>