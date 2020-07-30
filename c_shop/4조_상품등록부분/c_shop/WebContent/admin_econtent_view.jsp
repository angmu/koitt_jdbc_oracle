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
	  <script type="text/javascript">
	  	function deletecheck(){
	  		var result=confirm("정말로 삭제하시겠습니까?\n 삭제시 복구가 어렵습니다.");
	  		if(result==true){
	  			window.location.href='edelete.do?eId=${econtent_view[1].eId}';
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
		        	<a href="admin_econtent_view.do?eId=${econtent_view[0].eId}&page=${page}&rnum=${rnum+1}">
		        		${econtent_view[0].eTitle}
		        	</a>
		        </c:if>
		        <c:if test="${rnum!=1 }"> 
		        	<a href="admin_econtent_view.do?eId=${econtent_view[0].eId}&page=${page}&rnum=${rnum-1}">
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
			        <a href="admin_econtent_view.do?eId=${econtent_view[2].eId}&page=${page}&rnum=${rnum+1}">${econtent_view[2].eTitle}</a>
		        </td>
		      </tr>
	      </c:if>
	    </table>
	
	    <a href="admin_elist.do?page=${page}"><div class="list">목록</div></a>
	    <a onclick="deletecheck()" style="cursor: pointer;"><div class="list">삭제</div></a>
    	<a href="emodify_view.do?eId=${econtent_view[1].eId}&page=${page}&rnum=${rnum}">
    		<div class="list">수정</div>
    	</a>
	  </section>
	
	</body>
</html>