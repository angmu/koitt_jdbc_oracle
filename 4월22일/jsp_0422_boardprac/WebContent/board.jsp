<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="board_ok.jsp" name="board" method="post" enctype="multipart/form-data">
		제목:<input type="text" name="b_title"><br>
		작성자:<input type="text" name="b_user"><br>
		내용:<br><textarea rows="30" cols="40" name="b_content"></textarea><br>
		파일첨부:<input type="file" name="b_file"><br>
		<input type="submit" value="저장">
		<input type="button" value="취소" onclick="javascript:window.location.href='list.jsp'">
	</form>
</body>
</html>