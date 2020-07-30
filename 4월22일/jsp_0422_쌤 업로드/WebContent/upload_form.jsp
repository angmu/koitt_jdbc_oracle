<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
  <form action="upload_formok.jsp" name="form" method="post" enctype="multipart/form-data">
      번호<input type="text" name="b_num"><br>
      제목<input type="text" name="b_title"><br>
      내용<input type="text" name="b_content"><br>
      작성자<input type="text" name="b_user"><br>
      파일첨부1 :<input type="file" name="file"><br> 
      파일첨부2 :<input type="file" name="file2"><br>  
    <input type="submit" value="저장"><br>     
  
  
  </form>



</body>
</html>