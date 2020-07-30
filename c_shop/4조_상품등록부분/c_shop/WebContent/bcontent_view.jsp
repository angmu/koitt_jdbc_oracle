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
</head>

<body>
  <jsp:include page="common/top-nav.jsp" />
  <section>
    <h1>NOTICE</h1>
    <table>
      <colgroup>
      	<col width="80%">
      	<col width="10%">
      	<col width="10%">
      </colgroup>	
      <tr>
        <th colspan="3"><span>제목 : </span>${content_view[1].bTitle}</th>
      </tr>
      <tr>
        <td>번호 : <strong>${content_view[1].bId}</strong></td>
        <td>작성자</td>
        <td>${content_view[1].bName}</td>
      </tr>
      <tr>
        <td>작성일 : ${content_view[1].bDate}</td>
        <td>조회수</td>
        <td>${content_view[1].bHit}</td>
      </tr>
      <tr>
        <td class="content" colspan="3">
        ${content_view[1].bContent}
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
	        	<a href="content_view.do?bId=${content_view[0].bId}&page=${page}&rnum=${rnum+1}&searchflag=${searchflag}&category=${category}&searchcon=${searchcon}">
	        		${content_view[0].bTitle}
	        	</a>
	        </c:if>
	        <c:if test="${rnum!=1 }"> 
	        	<a href="content_view.do?bId=${content_view[0].bId}&page=${page}&rnum=${rnum-1}&searchflag=${searchflag}&category=${category}&searchcon=${searchcon}">
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
		        <a href="content_view.do?bId=${content_view[2].bId}&page=${page}&rnum=${rnum+1}&searchflag=${searchflag}&category=${category}&searchcon=${searchcon}">
		        	${content_view[2].bTitle}
		        </a>
	        </td>
	      </tr>
      </c:if>
    </table>

    <c:if test="${searchflag==1 }">
    	<a href="list.do?page=${page }">
	</c:if>
	<c:if test="${searchflag==2 }">
    	<a href="search.do?page=${page }&searchflag=${searchflag}&category=${category}&searchcon=${searchcon}">
	</c:if>
	    <div class="list">
	   		 목록
	    </div>
    </a>
  </section>
  
</body>
</html>