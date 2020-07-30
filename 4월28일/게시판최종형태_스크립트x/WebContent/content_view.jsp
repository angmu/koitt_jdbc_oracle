<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>    
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>뷰페이지</title>
		<link type="text/css" rel="stylesheet" href="css/style.css">
		<link type="text/css" rel="stylesheet" href="css/notice_view.css">
		<script type="text/javascript" src="js/jquery-1.12.3.js"></script>
		<script type="text/javascript" src="js/common.js" defer="defer"></script>
		<style type="text/css">
		.yap {
		float: right;}
		.yap span{
		font-size:20px;
		display: inline-block;
		float: left;
		margin-left: 20px;}
		</style>
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
		<!---------------  본문------------------>
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
					<div>
						<div>
							<div>
								<h2>${content_view.BId } &nbsp;&nbsp; ${content_view.BTitle }
								<div class="yap">
									<span>작성자</span>
									<span>${content_view.BName }</span>
									<span>작성일</span>
									<span>${content_view.BDate }</span>
									<span>조회수</span>
									<span>${content_view.BHit }</span>
								</div>	
								</h2>
							</div>
							<div>
								<!-- 파일의 경우 파일의 개수를 체크 있으면 이미지 태그안에 이미지 이름을 받아서 넣는 형태로 업로드 '0'!! // img src="${content_img_n1}"-->
								${content_view.BContent }
							</div>
						</div>
					</div>
					<!--  버튼 -->
					<div>
						<a href="reply_view.do?bId=${content_view.BId }" role="button">답글달기</a>
						<a href="modify_view.do?bId=${content_view.BId }" role="button">수정</a>
						<a href="delete.do?bId=${content_view.BId }" role="button">삭제</a>
						<!-- 무조건 1페이지로 이동.. -->
						<a href="list.do" role="button">목록</a>
						<a href="#" role="button">이전글</a>
						<!-- 무조건 1페이지로 이동.. -->
						<a href="list.do" role="button">다음글</a>
					</div>
				</div>
			</div>
		</section>
		<!---------------  본문------------------>
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