<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ko">
<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>Pages - Login</title>
  <link href="https://fonts.googleapis.com/css?family=Noto+Sans+KR:400,500,700,900&display=swap&subset=korean" rel="stylesheet">
  <link rel="stylesheet" href="css/style.css">
  <link rel="stylesheet" href="css/write.css">
  <script type="text/javascript" src="js/check.js"></script>
</head>

<body>

  <section>
    <h1>관리자 글쓰기</h1>
    <hr>

    <form action="write_view.do" name="write" method="post">
      <table>
        <colgroup>
          <col width="15%">
          <col width="85%">
        </colgroup>
        <tr>
          <th>분류</th>
          <td>
            <div class="category-wrapper">
              <select name="category" id="category">
                <option value="notice">공지</option>
                <option value="event">이벤트</option>
              </select>  
            </div>
          </td>
        </tr>
        <tr>
          <th>제목</th>
          <td>
            <input type="text" name="bTitle" >
          </td>
        </tr>
        <tr>
          <th>작성자</th>
          <td>
            <input type="text" name="bName">
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
        <button type="button" onclick="insert_check()" class="write">작성완료</button>
        <button type="button" onclick="location.href='list.do'">취소</button>
      </div>
    </form>

  </section>

</body>
</html>