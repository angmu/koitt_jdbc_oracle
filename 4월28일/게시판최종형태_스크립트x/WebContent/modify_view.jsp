<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ko">
<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>글 수정</title>
  <link href="https://fonts.googleapis.com/css?family=Noto+Sans+KR:400,500,700,900&display=swap&subset=korean" rel="stylesheet">
  <link rel="stylesheet" href="css/style.css">
  <link rel="stylesheet" href="css/write.css">
</head>

<body>

  <section>
    <h1>글 수정</h1>
    <hr>

    <form action="modify.do" name="modify" method="post">
      <input type="hidden" value="${modify_view.BId }" name="BId">
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
            <input type="text" name="BTitle" value="${modify_view.BTitle }">
          </td>
        </tr>
        <tr>
          <th>작성자</th>
          <td>
            <input type="text" name="BName" value="${modify_view.BName }" readonly="readonly">
          </td>
        </tr>
        <tr>
          <th>내용</th>
          <td>
            <textarea name="BContent" cols="50" rows="10">
           	 ${modify_view.BContent }
            
            </textarea>
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
        <button type="submit" class="write">수정완료</button>
        <button type="button" onclick="location.href='list.do'">취소</button>
      </div>
    </form>

  </section>

</body>
</html>