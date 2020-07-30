<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
  <link href="https://fonts.googleapis.com/css?family=Noto+Sans+KR:400,500,700,900&display=swap&subset=korean" rel="stylesheet">
  <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.12.1/css/all.min.css">
  <link rel="stylesheet" href="css/style.css">
  <link rel="stylesheet" href="css/read.css">
  <script type="text/javascript">
  function check(){
	  var result = confirm("ㄹㅇ???????");
	  if(result==true){
		  alert('삭제하겠습니다.');
		  window.location.href='delete.do?bId=${content_view.bid}';
	  }
  }
  </script>
<title>Insert title here</title>
</head>
<body>
<section>
    <h1>NOTICE</h1>

    <table>
    <colgroup>
        <col width="80%">
        <col width="10%">
        <col width="10%">
      </colgroup>
      <tr>
        <th colspan="3">${content_view.btitle }</th>
      </tr>
      <tr>
      	<th colspan="3"><strong>${content_view.bid }</strong></th>
      </tr>
      <tr>
        <td>${content_view.bdate }</td>
      	<td>조회수</td>
      	<td>${content_view.bhit }</td>
      </tr>
      <tr>
        <td colspan="3" class="article">${content_view.bcontent }</td>
      </tr>
      <tr>
        <td colspan="3"><strong>다음글</strong> <span class="separator">|</span> [키즈잼] 2월 프로그램 안내</td>
      </tr>
      <tr>
        <td colspan="3"><strong>이전글</strong> <span class="separator">|</span> [키즈잼] 2020년 1분기 정기 휴관일 안내</td>
      </tr>
    </table>

    <a href="list.do"><div class="list">목록</div></a>
   	<a href="delete.do?bid=${content_view.bid }"><div class="list">삭제</div></a>
   	<a href="modify_view.do?bid=${content_view.bid }"><div class="list">수정</div></a>
   	<a href="reply_view.do?bid=${content_view.bid }"><div class="list">지식인답변</div></a>
  </section>

</body>
</html>