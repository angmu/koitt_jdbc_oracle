<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<header>
   <div id="nav_up">
	  <ul>
		 <c:if test="${id!=null }">
			<li><a href="#"><strong>${name } 님 </strong></a></li>
			<li><a href="logout.jsp">로그아웃</a></li>
		 </c:if>
		 <c:if test="${id==null }">
			<li><a href="join.jsp">회원가입</a></li>
			<li><a href="login.jsp">로그인</a></li>
		 </c:if>
		 <li><a href="adminlogin.jsp">관리자로그인</a></li>
	 </ul>
  </div>
  <nav>
	<a href="index.jsp"></a>
	<ul>
		<li class="menu_list"><a href="plist.do">COOKIT메뉴</a></li>
		<li class="menu_list"><a href="elist.do">이벤트</a></li>
		<li class="menu_list"><a href="list.do">공지사항</a></li>
		<li class="menu_list"><a href="mmodify_view.do">MY쿡킷</a></li>
	</ul>
	<ul>
		<li><a href="#"><span>장바구니</span></a></li>
		<li><a href="#"><span>메뉴찾기</span></a></li>
	</ul>
		
  </nav>
</header>