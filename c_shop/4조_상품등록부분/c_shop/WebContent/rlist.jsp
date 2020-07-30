<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
	<head>
	  <title>리뷰게시판(구현아직안됨)</title>
	  <meta charset="UTF-8">
	  <meta name="viewport" content="width=device-width, initial-scale=1.0">
	  <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.12.1/css/all.min.css">
	  <link rel="stylesheet" href="css/style.css">
	  <link rel="stylesheet" href="css/notice_list.css">
	  <jsp:include page="common/config.jsp" />
	  <c:if test="${check==1}">
		  <script type="text/javascript">
			  	alert("저장이 정상적으로 완료되었습니다.");
		  </script>
	  </c:if>
	  <c:if test="${check==0}">
		  <script type="text/javascript">
		  		alert("저장이 정상적으로 이루어지지 않았습니다. 다시 시도해 주세요.");
				history.back(-1);
		  </script>
	  </c:if>
	</head>
	<body>
		<jsp:include page="common/top-nav.jsp" />
		<section>
		    <h1>REVIEW</h1>
		    <div class="wrapper">
		      <form action="rsearch.do" name="rsearch" method="post">
		        <select name="category" id="category">
		          <option value="whole">전체</option>
		          <option value="rTitle">제목</option>
		          <option value="rContent">내용</option>
		        </select>
		
		        <div class="title">
		          <input type="text" name="searchcon" size="16">
		        </div>
		  
		        <button type="submit"><i class="fas fa-search"></i></button>
		      </form>
		    </div>
		
		    <table>
		      <colgroup>
		        <col width="18%">
		        <col width="50%">
		        <col width="18%">
		        <col width="10%">
		      </colgroup>
		      <tr>
		        <th>No.</th>
		        <th>제목</th>
		        <th>작성일</th>
		        <th>조회수</th>
		      </tr>
		      <!-- 내용부분 -->
		      <c:forEach var="dto" items="${list}">
			      <tr>
			        <td>
				        <span class="table-notice">
				      	  	${dto.rNum}
				        </span>
			        </td>
			        <td class="table-title">
				        <a href="rcontent_view.do?rNum=${dto.rNum}&page=${page}" >
				        	<!-- 댓글일 경우 들여쓰기 부분 -->
				        	<c:forEach begin="1" end="${dto.rIndent}">&nbsp;&nbsp;→</c:forEach>
				        	${dto.rTitle}
				        </a>
			        </td>
			        <td>${dto.rDate}</td>
			        <td>${dto.rHit}</td>
			      </tr>
		      </c:forEach>
		    </table>
		    
		    
			<!-- 하단버튼 -->
		    <ul class="page-num">
		    	<!-- 첫페이지 이동 -->
		    		<c:if test="${searchflag=='2'}">
		      			<a href="rsearch.do?searchflag=${searchflag}&category=${rcategory}&searchcon=${rsearchcon}&page=1">
		      		</c:if>
		      		<c:if test="${searchflag!='2'}">
		      			<a href="rlist.do?searchflag=${searchflag}&page=1">
		      		</c:if>
		      	<li class="first"></li>
		      </a>
		      <!-- 이전페이지 이동 -->
		      <c:if test="${page<=1}">
		      	<li class="prev"></li>
		      </c:if>
		      
		      <c:if test="${page>1}">
		      		<c:if test="${searchflag=='2'}">
		      			<a href="rsearch.do?searchflag=${searchflag}&category=${category}&searchcon=${searchcon }&page=${page-1}">
		      		</c:if>
		      		<c:if test="${searchflag!='2'}">
		      			<a href="rlist.do?searchflag=${searchflag}&page=${page-1}">
		      		</c:if>
		      		<li class="prev"></li>
		      	</a>
		      </c:if>
		      
		      <!-- 순차적 페이지 번호 출력 -->
		      <c:forEach var="a" begin="${startpage}" end="${endpage}" step="1">
		      	<c:choose>
					<c:when test="${a==page}">
						<li class="num"  style="background: #dfdfdf ;">
							  <div>${a }</div>
						</li>
					</c:when>
					<c:when test="${a!=page}">
							<c:if test="${searchflag=='2'}">
			      				<a href="rsearch.do?searchflag=${searchflag}&category=${category}&searchcon=${searchcon}&page=${a}">
			      			</c:if>
			      			<c:if test="${searchflag!='2' }">
			      				<a href="rlist.do?searchflag=${searchflag}&page=${a}">
			      			</c:if>
							<li class="num">
								  <div>${a}</div>
							 </li>
						</a>
					</c:when>
				</c:choose>
		      </c:forEach>
		      
		      <!-- 다음페이지 이동 -->
		      <c:if test="${page>=maxpage}">
		      	<li class="next"></li>
		      </c:if>
		      <c:if test="${page<maxpage}">
		      		<c:if test="${searchflag=='2'}">
	      			<a href="rsearch.do?searchflag=${searchflag}&category=${category}&searchcon=${searchcon}&page=${page+1}">
	      			</c:if>
	      			<c:if test="${searchflag!='2'}">
	      				<a href="rlist.do?searchflag=${searchflag}&page=${page+1}">
	      			</c:if>
			    	<li class="next"></li>
			    </a>
		      </c:if>
		      
		      <!-- 마지막페이지 이동 -->
		      	  <c:if test="${searchflag=='2'}">
      			  	<a href="rsearch.do?searchflag=${searchflag}&category=${category}&searchcon=${searchcon}&page=${maxpage}">
      			  </c:if>
      			  <c:if test="${searchflag!='2' }">
      				<a href="rlist.do?searchflag=${searchflag}&page=${maxpage}">
      			  </c:if>
		    	  <li class="last"></li>
		      </a>
		      
		    </ul>
		</section>
		<jsp:include page="common/footer.jsp" />
	</body>
</html>