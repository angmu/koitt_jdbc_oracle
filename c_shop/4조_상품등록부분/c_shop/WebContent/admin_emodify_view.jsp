<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ko">
	<head>
	  <title>이벤트 수정</title>
	  <meta charset="UTF-8">
	  <meta name="viewport" content="width=device-width, initial-scale=1.0">
	  <link rel="stylesheet" href="css/write.css">
	  <script type="text/javascript" src="js/check.js"></script>
	  <jsp:include page="common/config.jsp" />
	  <script type="text/javascript">
	  $(document).ready(function() {
			$("#newfile1").change(function() {
				$('#file1').val($('#newfile1').val());
			});
			
			$("#newfile2").change(function() {
				$('#file2').val($('#newfile2').val());
			});
			
	  });
	  
	  </script>
	</head>
	<body>
	  <jsp:include page="common/admin_top-nav.jsp" />
	  <section>
	    <h1>이벤트 수정</h1>
	    <hr>
	
	    <form action="emodify.do?page=${page }" name="write" method="post"  onsubmit="return writeCheck()" enctype="multipart/form-data">
	      <table>
	        <colgroup>
	          <col width="15%">
	          <col width="85%">
	        </colgroup>
	        <tr>
	          <th>제목 ${rnum }</th>
	          <td>
	            <input type="hidden" name="eId" value="${econtent_view.eId}">
	            <input type="hidden" name="rnum" value="${rnum}">
	            <input type="text" name="eTitle" value="${econtent_view.eTitle}">
	          </td>
	        </tr>
	        <tr>
	          <th>기간 지정</th>
	          <td>
	            <input type="date" name="eDate_start" value="${econtent_view.eDate_start }" class="event_date">&nbsp;&nbsp; ~ &nbsp;&nbsp; 
	            <input type="date" name="eDate_end" value="${econtent_view.eDate_end }" class="event_date">
	          </td>
	        </tr>
	        <tr>
	          <th>썸네일 파일</th>
	          <td>
	            <label for="newfile1">파일 선택</label>
	            <input type="file" name="eTitleimg" id="newfile1" class="oldfile">
	            <input type="text" name="newfile1" id="file1" value="${econtent_view.eTitleimg }" readonly >
	          </td>
	        </tr>
	        <tr>
	          <th>본문이미지 파일</th>
	          <td>
	          	<label for="newfile2">파일 선택</label>
	            <input type="file" name="eContentimg" id="newfile2" class="oldfile">
	            <input type="text" name="newfile2" id="file2" value="${econtent_view.eContentimg }" readonly>
	          </td>
	        </tr>
	        
	      </table>
	      <hr>
	      <div class="button-wrapper">
	        <button type="submit" class="write">수정완료</button>
	        <button type="reset" onclick="javascript:history.back(-1)" class="cancel">취소</button>
	      </div>
	    </form>
	  </section>
	</body>
</html>