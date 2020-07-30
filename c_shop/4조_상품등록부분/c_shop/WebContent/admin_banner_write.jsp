<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ko">
	<head>
	  <title>배너등록</title>
	  <meta charset="UTF-8">
	  <meta name="viewport" content="width=device-width, initial-scale=1.0">
	  <link rel="stylesheet" href="css/write.css">
	  <script type="text/javascript" src="js/check.js"></script>
	  <jsp:include page="common/config.jsp" />
	</head>
	<body>
	  <jsp:include page="common/admin_top-nav.jsp" />
	  <section>
	    <h1>배너등록</h1>
	    <hr>
	
	    <form action="banner_write.do" name="write" method="post"  onsubmit="return writeCheck()" enctype="multipart/form-data">
	      <table>
	        <colgroup>
	          <col width="15%">
	          <col width="85%">
	        </colgroup>
	        <tr>
	          <th>배너이미지 파일</th>
	          <td>
	            <input type="file" name="banner" id="file">
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