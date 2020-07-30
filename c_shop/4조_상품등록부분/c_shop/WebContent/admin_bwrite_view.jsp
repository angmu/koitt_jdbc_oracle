<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ko">
	<head>
	  <title>글쓰기</title>
	  <meta charset="UTF-8">
	  <meta name="viewport" content="width=device-width, initial-scale=1.0">
	  <link rel="stylesheet" href="css/style.css">
	  <link rel="stylesheet" href="css/write.css">
	  <script type="text/javascript" src="js/check.js"></script>
	  <jsp:include page="common/config.jsp" />
	</head>
	<body>
	  <jsp:include page="common/admin_top-nav.jsp" />
	  <section>
	    <h1>관리자 글쓰기</h1>
	    <hr>
	
	    <form action="write.do" name="write" method="post"  onsubmit="return writeCheck()">
	      <table>
	        <colgroup>
	          <col width="15%">
	          <col width="85%">
	        </colgroup>
	        <tr>
	          <th>작성자</th>
	          <td>
	            <input type="text" name="bName" value="${name }" readonly>
	          </td>
	        </tr>
	        <tr>
	          <th>제목</th>
	          <td>
	            <input type="text" name="bTitle">
	          </td>
	        </tr>
	        <tr>
	          <th>내용</th>
	          <td>
	            <textarea name="bContent" cols="50" rows="10"></textarea>
	          </td>
	        </tr>
	        <tr>
	          <th>이미지 표시</th>
	          <td>
	            <input type="file" name="file" id="file">
	          </td>
	        </tr>
	      </table>
	      <hr>
	      <div class="button-wrapper">
	        <button type="submit" class="write">작성완료</button>
	        <button type="reset" onclick="javascript:history.back(-1)" class="cancel">취소</button>
	      </div>
	    </form>
	  </section>
	</body>
</html>