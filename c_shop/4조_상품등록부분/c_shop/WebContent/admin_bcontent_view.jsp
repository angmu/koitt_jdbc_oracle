<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="ko">
<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>Document</title>
  <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.12.1/css/all.min.css">
  <link rel="stylesheet" href="css/style.css">
  <link rel="stylesheet" href="css/read.css">
  <jsp:include page="common/config.jsp" />
  <script type="text/javascript">
  	function deletecheck(){
  		var result=confirm("정말로 삭제하시겠습니까?\n 삭제시 복구가 어렵습니다.");
  		if(result==true){
  			window.location.href='delete.do?bId=${content_view[1].bId}';
  		}else{
  			alert("삭제취소");
  		}
  	}
  </script>
  
  <c:if test="${check==1 }">
  	<script type="text/javascript">
  		alert("저장이 정상적으로 완료되었습니다.");
  	</script>
  </c:if>
  <c:if test="${check==0 }">
  	<script type="text/javascript">
  		alert("저장이 정상적으로 이루어지지 않았습니다. 다시 시도해 주세요.");
		history.back(-1);
  	</script>
  </c:if>
  
</head>

<body>
  <jsp:include page="common/admin_top-nav.jsp" />
  <section>
    <h1>NOTICE</h1>
    <table>
      <colgroup>
      	<col width="80%">
      	<col width="10%">
      	<col width="10%">
      </colgroup>	
      <tr>
        <th colspan="3"><span>제목 : </span>${content_view[1].bTitle }</th>
      </tr>
      <tr>
        <td>번호 : <strong>${content_view[1].bId }</strong></td>
        <td>작성자</td>
        <td>${content_view[1].bName }</td>
      </tr>
      <tr>
        <td>작성일 : ${content_view[1].bDate }</td>
        <td>조회수</td>
        <td>${content_view[1].bHit }</td>
      </tr>
      <tr>
        <td class="content" colspan="3">
        ${content_view[1].bContent }
		</td>
      </tr>
	  <tr>
        <td colspan="3">
        	<c:if test="${rnum==1 }">
        		<strong>다음글</strong>
        	</c:if>
        	<c:if test="${rnum!=1 }">
        		<strong>이전글</strong>
        	</c:if> 
	        <span class="separator">|</span>
	        <c:if test="${rnum==1 }"> 
	        	<a href="admin_content_view.do?bId=${content_view[0].bId}&page=${page}&rnum=${rnum+1}&searchflag=${searchflag}&category=${category}&searchcon=${searchcon}">
	        		
	        		${content_view[0].bTitle}
	        	</a>
	        </c:if>
	        <c:if test="${rnum!=1 }"> 
	        	<a href="admin_content_view.do?bId=${content_view[0].bId}&page=${page}&rnum=${rnum-1}&searchflag=${searchflag}&category=${category}&searchcon=${searchcon}">
	        		
	        		${content_view[0].bTitle}
	        	</a>
	        </c:if>
        </td>
      </tr>
      <c:if test="${size==3 }">
	      <tr>
	        <td colspan="3">
	        	<strong>다음글</strong> 
		        <span class="separator">|</span> 
		        <a href="admin_content_view.do?bId=${content_view[2].bId}&page=${page}&rnum=${rnum+1}&searchflag=${searchflag}&category=${category}&searchcon=${searchcon}">
		        	
		        	${content_view[2].bTitle}
		        </a>
	        </td>
	      </tr>
      </c:if>
    </table>
	<c:if test="${searchflag==1 }">
    	<a href="admin_list.do?page=${page }">
	</c:if>
	<c:if test="${searchflag==2 }">
    	<a href="admin_search.do?page=${page }&searchflag=${searchflag}&category=${category}&searchcon=${searchcon}">
	</c:if>
		<div class="list">
	   		 목록
	    </div>
    </a>
    <a onclick="deletecheck()" style="cursor: pointer;">
	    <div class="list">
	    	삭제
	    </div>
    </a>
    <a href="modify_view.do?bId=${content_view[1].bId }&page=${page}&rnum=${rnum}&searchflag=${searchflag}&category=${category}&searchcon=${searchcon}">
	    <div class="list">
	   		 수정
	    </div>
    </a>
    <a href="reply_view.do?bId=${content_view[1].bId }&page=${page}&rnum=${rnum}&searchflag=${searchflag}&category=${category}&searchcon=${searchcon}">
	    <div class="list">
	   		 답글달기
	    </div>
    </a>
  </section>
  
</body>
</html>