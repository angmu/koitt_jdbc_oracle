<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ko">
	<head>
	  <title>이벤트 등록</title>
	  <meta charset="UTF-8">
	  <meta name="viewport" content="width=device-width, initial-scale=1.0">
	  <link rel="stylesheet" href="css/write.css">
	  <script type="text/javascript" src="js/check.js"></script>
	  <jsp:include page="common/config.jsp" />
	</head>
	<body>
	  <jsp:include page="common/admin_top-nav.jsp" />
	  <section>
	    <h1>이벤트 등록</h1>
	    <hr>
	
	    <form action="ewrite.do" name="write" method="post"  onsubmit="return writeCheck()" enctype="multipart/form-data">
	      <table>
	        <colgroup>
	          <col width="15%">
	          <col width="85%">
	        </colgroup>
	        <tr>
	          <th>제목</th>
	          <td>
	            <input type="text" name="eTitle">
	          </td>
	        </tr>
	        <tr>
	          <th>기간 지정</th>
	          <td>
	            <input type="date" name="eDate_start" class="event_date">&nbsp;&nbsp; ~ &nbsp;&nbsp; 
	            <input type="date" name="eDate_end" class="event_date">
	          </td>
	        </tr>
	        <tr>
	          <th>썸네일 파일</th>
	          <td>
	            <input type="file" name="eTitleimg" id="file">
	          </td>
	        </tr>
	        <tr>
	          <th>본문이미지 파일</th>
	          <td>
	            <input type="file" name="eContentimg" id="file">
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