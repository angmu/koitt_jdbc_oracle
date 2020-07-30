<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="ko">
	<head>
	  <meta charset="UTF-8">
	  <meta name="viewport" content="width=device-width, initial-scale=1.0">
	  <title>이벤트 세부페이지</title>
	  <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.12.1/css/all.min.css">
	  <link rel="stylesheet" href="css/style.css">
	  <link rel="stylesheet" href="css/read.css">
	  <jsp:include page="common/config.jsp" />
	</head>
	
	<body>
	  <jsp:include page="common/top-nav.jsp" />
	  <section>
	    <h1>EVENT</h1>
	
	    <table>
	      <tr>
	        <th>${econtent_view[1].eTitle }</th>
	      </tr>
	      <tr>
	        <td>${econtent_view[1].eDate_start } ~ ${econtent_view[1].eDate_end }</td>
	      </tr>
	      <tr>
	        <td class="article">
	          <img src="upload/${econtent_view[1].eContentimg }" alt="${econtent_view[1].eTitle }" class="econtentimg">
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
		        	<a href="econtent_view.do?eId=${econtent_view[0].eId}&page=${page}&rnum=${rnum+1}">
		        		${econtent_view[0].eTitle}
		        	</a>
		        </c:if>
		        <c:if test="${rnum!=1 }"> 
		        	<a href="econtent_view.do?eId=${econtent_view[0].eId}&page=${page}&rnum=${rnum-1}">
		        		${econtent_view[0].eTitle}
		        	</a>
		        </c:if>
	        </td>
	      </tr>
	      <c:if test="${size==3 }">
		      <tr>
		        <td colspan="3">
		        	<strong>다음글</strong> 
			        <span class="separator">|</span> 
			        <a href="econtent_view.do?eId=${econtent_view[2].eId}&page=${page}&rnum=${rnum+1}">${econtent_view[2].eTitle}</a>
		        </td>
		      </tr>
	      </c:if>
	    </table>
	
	    <a href="elist.do?page=${page }"><div class="list">목록</div></a>
	  </section>
	
	  <jsp:include page="common/footer.jsp" />
	</body>
</html>