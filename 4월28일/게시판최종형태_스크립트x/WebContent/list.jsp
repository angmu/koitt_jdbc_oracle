<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% request.setCharacterEncoding("utf-8"); %>    
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>    

<!DOCTYPE html>
<html lang="ko">
<head>
	<style>
		table td:last-child {
		text-align: center;
}
	</style>
    <meta charset="UTF-8">
    	<link rel="stylesheet" type="text/css" href="css/list_style.css">
		<link type="text/css" rel="stylesheet" href="css/style.css">
		<script type="text/javascript" src="js/jquery-1.12.3.js"></script>
		<script type="text/javascript" src="js/common.js" defer="defer"></script>
		
    <title>집밥을 특별하게, 쿡킷</title>
</head>
<body>
	<header>
			<div id="nav_up">
				<ul>
					<li><a href="signup.html">회원가입</a></li>
					<li><a href="login.html">로그인</a></li>
					<li><a href="list.html">고객행복센터</a></li>
					<li><a href="#">배송지역검색</a></li>
					<li><a href="#">기프트카드 등록</a></li>
					<li><a href="admin_login.html">관리자페이지</a></li>
				</ul>
			</div>
			<nav>
				<h1><a href="main.html"></a></h1>
				<ul>
					<li><a href="#">COOKIT소개</a></li>
					<li><a href="#">COOKIT메뉴</a><span>.</span></li>
					<li><a href="#">리뷰</a></li>
					<li><a href="event_list.html">이벤트</a></li>
					<li><a href="#">MY쿡킷</a></li>
				</ul>
				<ul>
					<li><a href="#"><span>장바구니</span></a></li>
					<li><a href="#"><span>메뉴찾기</span></a></li>
				</ul>
			</nav>
		</header>
		<section>
		
		<div id="content">
				<div>
					<h1>고객행복센터</h1>
					<div>
						<ul>
							<li><a href="#"><span>FAQ</span></a></li>
							<li><a href="list.html"><span>공지사항</span></a></li>
							<li><a href="#"><span>새벽배송/이용안내</span></a></li>
						</ul>
					</div>
				</div>
		</div>			

        <article id="art_table">
            <table border-top="3">
            	<!-- 제목부분 -->
                <tr>
                    <th scope="row">번호</th>
                    <th scope="row">제목</th>
                    <th scope="row">등록일</th>
                    <th scope="row">조회수</th>
                </tr>
                <!-- 내용부분 -->
                <c:forEach var="dto" items="${list }">
	                <tr>
	                    <td>${dto.BId }</td>
	                    <td>
	                    <!-- 들여쓰기 -->
	                    <c:forEach begin="1" end="${dto.BIndent }">▶            
	                    </c:forEach>
	                    
	                    <a href="content_view.do?bId=${dto.BId }">${dto.BTitle }</a></td>
	                    <td>${dto.BDate }</td>
	                     <td>${dto.BHit }</td>
	                </tr>
                </c:forEach>
                
                
               
            </table>
            <div id="pagination">
                <div>
					<button type="button" onclick="location.href='write.do'"><span>글쓰기</span></button>
				</div>
                <div>
                    <span>1</span>
                    <span>2</span>
                </div>

            </div>

        </article>
</section>
		<footer>
			<div id="footer">
			<div>
				<h1>
					<a href="#"></a>
				</h1>
				<p>© COOKIT ALL RIGHTS RESERVED</p>
			</div>
			<div>
				<ul>
					<li><a href="#">이용약관</a></li>
					<li class="lime"><a href="#">개인정보처리 방침</a></li>
					<li><a href="#">법적고지</a></li>
					<li><a href="#">사업자정보 확인</a></li>
				</ul>
				<p>씨제이제일제당(주)</p>
				<p>대표이사 : 손경식,강신호,신현재</p>
				<p class="right_n">사업자등록번호 : 104-86-09535</p>
				<p>주소 : 서울 중구 동호로 330 CJ제일제당 센터 (우) 04560</p>
				<p>통신판매업신고 중구 제 07767호</p>
				<p class="right_n">개인정보보호책임자 : 조영민</p>
				<p>이메일 : cjon@cj.net</p>
				<p class="right_n">호스팅제공자 : CJ올리브네트웍스㈜</p>
				<p class="right_n">
					고객님은 안전거래를 위해 현금등으로 결제시 LG U+ 전자 결제의 매매보호(에스크로) 서비스를 이용하실 수 있습니다.<a
						href="#">가입 사실 확인</a>
				</p>
			</div>
			<div>
				<p id="f_menubtn">
					CJ그룹계열사 바로가기 <span class="entypo-down-open"></span>
				</p>
				<div id="hide_menu">
					<ul>
						<li>CJ그룹
							<ul>
								<li><a href="#">CJ주식회사</a></li>
							</ul>
						</li>
						<li>식품&amp;식품서비스
							<ul>
								<li><a href="#">CJ제일제당(식품)</a></li>
								<li><a href="#">CJ푸드빌</a></li>
								<li><a href="#">CJ프레시웨이</a></li>
								<li><a href="#">CJ엠디원</a></li>
							</ul>
						</li>
						<li>생명공학
							<ul>
								<li><a href="#">CJ제일제당(바이오)</a></li>
							</ul>
						</li>
						<li>신유통
							<ul>
								<li><a href="#">CJ ENM(오쇼핑)</a></li>
								<li><a href="#">CJ대한통운</a></li>
								<li><a href="#">CJ텔레닉스</a></li>
								<li><a href="#">CJ올리브영</a></li>
							</ul>
						</li>
						<li>엔터테인먼트&amp;미디어
							<ul>
								<li><a href="#">CJ ENM(E&amp;M)</a></li>
								<li><a href="#">CJ CGV</a></li>
								<li><a href="#">CJ파워캐스트</a></li>
							</ul>
						</li>
						<li>인프라
							<ul>
								<li><a href="#">CJ대한통운(건설)</a></li>
								<li><a href="#">CJ올리브네트웍스</a></li>
							</ul>
						</li>
					</ul>
				</div>
				<p>고객행복센터</p>
				<p>1668-1920</p>
				<div id="f_btn">1:1문의</div>
			</div>
		</div>
		</footer>
</body>
</html>