<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
		
		<c:if test="${admin_id==null }">
			<script>
				alert("허용되지 않은 접근입니다.");
				window.location.href="index.jsp";
			</script>
		</c:if>
		<header>
	 		<div id="nav_up">
	 			<ul>
	 				<li><a href="#"><strong>${name } 님 </strong></a></li>
	 				<li><a href="logout.jsp">로그아웃</a></li>
	 			</ul>
	 		</div>
	 		<nav>
	 			<a href="admin_main.jsp"></a>
	 			<ul>
	 				<li class="menu_list"><a href="admin_mlist.do">회원관리</a></li>
	 				<li class="menu_list"><a href="admin_plist.do">상품관리</a></li>
	 				<li class="menu_list"><a href="admin_elist.do">이벤트관리</a></li>
	 				<li class="menu_list"><a href="admin_list.do">공지사항관리</a></li>
	 				<li class="menu_list"><a href="admin_banner_write.jsp">배너등록</a></li>
	 			</ul>
	 		</nav>
	 	</header>