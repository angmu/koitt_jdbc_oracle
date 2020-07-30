<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<html lang="ko">
	<head>
	  <meta charset="UTF-8">
	  <meta name="viewport" content="width=device-width, initial-scale=1.0">
	  <title>이벤트리스트</title>
	  <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.12.1/css/all.min.css">
	  <link rel="stylesheet" href="css/style.css">
	  <link rel="stylesheet" href="css/admin_product_list.css">
	  <jsp:include page="common/config.jsp"/>
	  <c:if test="${check==1 }">
		  <script type="text/javascript">
			  	alert("저장이 정상적으로 완료되었습니다.");
			  	window.location.href="admin_plist.do";
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
	    <h1>상품목록</h1>
	
	    
       <table border="1" id="product_list">
      	 <c:forEach var="list" items="${list }"> 
	        <tr>
	          <th>
		          <a href="pmodify_view.do?pId=${list.pId}&page=${page}">
		          	[${list.pId }]
		          </a>  <!-- 상세페이지 이동링크 -->
	          </th>
	          <td>
	              <span>상품명 : ${list.pName}</span><br>  <!-- 상품이름 -->
	              <span>가격 : ${list.pPrice} 원</span>  <!-- 가격 -->
	              <span>등록일 : <fmt:formatDate value="${list.pDate }" type="date" dateStyle="short"/></span>  <!-- 등록일 -->
	          </td>
	        </tr>
         </c:forEach>
       </table>
	    
	
	    <!-- 하단버튼 -->
	    <ul class="page-num">
	    	<!-- 첫페이지 이동 -->
	      		<a href="admin_plist.do?page=1">
	      	<li class="first"></li>
	      </a>
	      <!-- 이전페이지 이동 -->
	      <c:if test="${page<=1 }">
	      	<li class="prev"></li>
	      </c:if>
	      
	      <c:if test="${page>1 }">
	      		<a href="admin_plist.do?page=${page-1 }">
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
		      			<a href="admin_plist.do?page=${a }">
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
	     	<a href="admin_pelist.do?page=${page+1 }">
		    	<li class="next"></li>
		    </a>
	      </c:if>
	      
	      <!-- 마지막페이지 이동 -->
	      <a href="admin_plist.do?page=${maxpage }">
	    	  <li class="last"></li>
	      </a>
	    </ul>
	    <a href="admin_pwrite_view.jsp">
	      <div class="write">상품등록</div>
	    </a>  
	  </section>
	</body>
</html>