<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html lang="ko">
	<head>
	  <meta charset="UTF-8">
	  <meta name="viewport" content="width=device-width, initial-scale=1.0">
	  <title>상품리스트</title>
	  <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.12.1/css/all.min.css">
	  <link rel="stylesheet" href="css/style.css">
	  <link rel="stylesheet" href="css/product_list.css">
	  <jsp:include page="common/config.jsp"/>
	</head>
	<body>
	  <jsp:include page="common/top-nav.jsp"/>
	  <section>
	    <h1>상품목록</h1>
	
	    <article id="product_list">
	      <ul>
	      	<c:forEach var="list" items="${list }"> 
		        <li>
		          <a href="pcontent_view.do?pId=${list.pId}&page=${page}">  <!-- 상세페이지 이동링크 -->
		            <img src="pupload/${list.pTitleimg }" alt="${list.pName }" class="event-img">  <!-- 썸네일 -->
		            <div class="price">${list.pPrice} 원</div>  <!-- 가격 -->
		            <div class="product_name">${list.pName}</div>  <!-- 상품이름 -->
		            <span class="pdetail">${list.pAmount}인분</span><span class="pdetail">조리 ${list.pTime }분</span>
		          </a>
		        </li>
	        </c:forEach>
	      </ul>
	    </article>
	
	    <!-- 하단버튼 -->
	    <ul class="page-num">
	    	<!-- 첫페이지 이동 -->
	      		<a href="plist.do?page=1">
	      	<li class="first"></li>
	      </a>
	      <!-- 이전페이지 이동 -->
	      <c:if test="${page<=1 }">
	      	<li class="prev"></li>
	      </c:if>
	      
	      <c:if test="${page>1 }">
	      		<a href="plist.do?page=${page-1 }">
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
		      			<a href="plist.do?page=${a }">
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
	     	<a href="pelist.do?page=${page+1 }">
		    	<li class="next"></li>
		    </a>
	      </c:if>
	      
	      <!-- 마지막페이지 이동 -->
	      <a href="plist.do?page=${maxpage }">
	    	  <li class="last"></li>
	      </a>
	    </ul>
	  </section>
	  <jsp:include page="common/footer.jsp"/>
	</body>
</html>