<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html lang="ko">
<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>이벤트리스트</title>
  <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.12.1/css/all.min.css">
  <link rel="stylesheet" href="css/style.css">
  <link rel="stylesheet" href="css/event_list.css">
  <jsp:include page="common/config.jsp"/>
  <c:if test="${check==1 }">
	  <script type="text/javascript">
		  	alert("저장이 정상적으로 완료되었습니다.");
		  	window.location.href="admin_elist.do";
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
  <jsp:include page="common/admin_top-nav.jsp"/>
  <section>
    <h1>EVENT</h1>

    <article id="event_list">
      <ul>
      	<c:forEach var="list" items="${list }"> 
	        <li>
	          <a href="admin_econtent_view.do?eId=${list.eId }&page=${page }&rnum=${list.rnum}">
	            <img src="upload/${list.eTitleimg }" alt="${list.eTitle }" class="event-img">
	            <c:choose>
		            <c:when test="${list.eFlag=='진행중' }">
		            	<div class="event-now">${list.eFlag }</div>
		            </c:when>
		            <c:when test="${list.eFlag=='종료' }">
		            	<div class="event-end">${list.eFlag }</div>
		            </c:when>
		            <c:otherwise>
		            	<div class="event-yet">${list.eFlag }</div>
		            </c:otherwise>
	            </c:choose>
	            <div class="event-title">${list.eTitle }</div>
	            <div class="event-date">${list.eDate_start} ~ ${list.eDate_end }</div>  
	          </a>
	        </li>
        </c:forEach>
      </ul>
    </article>

    <!-- 하단버튼 -->
    <ul class="page-num">
    	<!-- 첫페이지 이동 -->
      		<a href="admin_elist.do?page=1">
      	<li class="first"></li>
      </a>
      <!-- 이전페이지 이동 -->
      <c:if test="${page<=1 }">
      	<li class="prev"></li>
      </c:if>
      
      <c:if test="${page>1 }">
      		<a href="admin_elist.do?page=${page-1 }">
      		<li class="prev"></li>
      	</a>
      </c:if>
      
      <!-- 순차적 페이지 번호 출력 -->
      <c:forEach var="a" begin="${startpage }" end="${endpage }" step="1">
      	<c:choose>
			<c:when test="${a==page }">
				<li class="num"  style="background: #dfdfdf ;">
					  <div>${a }</div>
				</li>
			</c:when>
			
			<c:when test="${a!=page }">
	      			<a href="admin_elist.do?page=${a }">
					<li class="num">
						  <div>${a }</div>
					 </li>
				</a>
			</c:when>
		</c:choose>
      </c:forEach>
      
      <!-- 다음페이지 이동 -->
      <c:if test="${page>=maxpage }">
      	<li class="next"></li>
      </c:if>
      <c:if test="${page<maxpage }">
     	<a href="admin_elist.do?page=${page+1 }">
	    	<li class="next"></li>
	    </a>
      </c:if>
      
      <!-- 마지막페이지 이동 -->
      <a href="admin_elist.do?page=${maxpage }">
    	  <li class="last"></li>
      </a>
    </ul>
    <a href="admin_ewrite_view.jsp">
      <div class="write">쓰기</div>
    </a>  
  </section>
</body>
</html>