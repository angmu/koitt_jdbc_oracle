<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <title>게시판 관리</title>
    <link type="text/css" rel="stylesheet" href="css/manage_main.css">
    <link rel="stylesheet" href="css/admin_main.css">
    <link rel="stylesheet" href="css/admin_board.css">
	<link rel="stylesheet" href="css/admin_header.css">
	<link rel="stylesheet" href="css/main_notice.css">
	<script src="js/jquery-1.12.3.js"></script>
	<script src="js/admin_left_nav_function.js"></script>
	<script>
		$(document).ready(()=>{
			$('.doors').click((e) => {
				const numbering = $(e.target).closest('td').prev('td').text();
				location.href = 'admin_view.jsp?' + numbering;
			});
		});
	</script>
</head>
<body>
	<!-- 관리자 헤더 입니다------------------------------------------------------------------------>
	<header id="topfix">
	    <div id="header">
	        <div class="logo_txt">
	            <span>+++++</span> <a href="admin_main.html">관리자 페이지</a> <span>+++++</span>
	        </div>
	        <ul class="top_menu">
	            <li>
	                <table class="table0">
	                    <tbody>
	                    <tr>
	                        <td>
	                            <span class="float_right">
	                                    <a href="#">
	                                        <img alt="자물쇠" src="images/admin_main/logout.png">
	                                    </a>
	                                        <span class="float_right">관리자모드</span>
	                            </span>
	                        </td>
	                    </tr>
	                    </tbody>
	                </table>
	            </li>
	        </ul>
	    </div>
	    <nav id="gnb">
	        <ul class="gnb_navi">
	            <p>&nbsp;</p>
	            <li>
	                <a href="admin_board.html">
	                    <span class="menuIcon0">공지사항</span>
	                </a>
	            </li>
	            <li>
	                <a href="#">
	                    <span class="menuIcon1">환경설정</span>
	                </a>
	            </li>
	            <li>
	                <a href="manage_main.html">
	                    <span class="menuIcon2">회원관리</span>
	                </a>
	            </li>
	            <li>
	                <a href="#">
	                    <span class="menuIcon3">주문관리</span>
	                </a>
	            </li>
	            <li>
	                <a href="#">
	                    <span class="menuIcon4">상품관리</span>
	                </a>
	            </li>
	            <li>
	                <a href="admin_event.html">
	                    <span class="menuIcon5">이벤트관리</span>
	                </a>
	            </li>
	            <li>
	                <a href="main.html">
	                    <span class="menuIcon6">홈페이지</span>
	                </a>
	            </li>
	        </ul>
	    </nav>
	</header>
<!-- 여기까지 관리자 헤더 입니다------------------------------------------------------------------------>
	<div id="wrap">
	    <div id="manage_main">
	        <div>
			<!---------- 좌측메뉴 ---------->
					<div id="leftArea">
						<div>
							<h2><em></em>&nbsp;관리자 게시판</h2>
							<ul class="menu">
								<li class="on">
									<a href="#" onclick="Submenu_OC('1'); return false;"> 게시판 관리
										<span id="icon-plus-minus1" class="icon-list-minus">ListIcon</span>
									</a>
								</li>
								<div class="submenu" id="LeftMenuID1">
									<li class="on"><a href="#"><img src="images/manage/icon_title_left.png">&nbsp;공지사항</a></li>
									<li><a href="#"><img src="images/manage/icon_title_left.png">&nbsp;묻고답하기(Q&A)</a></li>
									<li><a href="#"><img src="images/manage/icon_title_left.png">&nbsp;쪽지함</a></li>
								</div>
								<li>
									<a href="#"	onclick="Submenu_OC('2'); return false;">서비스 사용 현황
										<span id="icon-plus-minus2" class="icon-list-minus">ListIcon</span>
									</a>
								</li>
								<div class="submenu" id="LeftMenuID2">
									<li><a href="#"><img src="images/manage/icon_title_left.png">&nbsp;사용자(계약자) 정보</a></li>
									<li><a href="#"><img src="images/manage/icon_title_left.png">&nbsp;서비스 결제 정보</a></li>
								</div>
								<div>
									<li>
										<span>
											<a href="#" onclick="menufavorite_pop();">
												<img src="images/manage/icon_setting03.png" title="설정" alt="설정">
											</a>
											즐겨찾기&nbsp;메뉴
										</span>
									</li>
									<div></div>
								</div>
							</ul>
						</div>
					</div>
					<!--------- 좌측메뉴 ---------->
				</div>
			</div>
		</div>
			
<!-- 관리자 게시판 content 입니다------------------------------------------>


<!-- 관리자 게시판 입니다------------------------------------------------------------------------>

		<div id="contentArea">
		    <div class="sub_title_bar">
		        <ul class="ptit">
		            <li>
		          	      공지사항
		                <div class="float_r">
		                    <a href="#"><p class="listed"></p></a>
		                </div>
		                <div class="float_r">
		                    <a href="#"><p class="favorite"></p></a>
		                </div>
		                <div></div>
		            </li>
		        </ul>
		    </div>
			<div class="sub_content_area">
			<div id="wrap">
				<div>
					<div class="cont">
						<table id="board_search">
							<tr>
								<td>
									<select id="search_cat">
										<option value>선택
										<option value="subject">제목
										<option value="content">내용
										<option value="writer">작성자
									</select>
									<input type="text" id="search_box">
									<button id="search_button" onclick=""></button>
								
								</td>
							</tr>
						</table>
						<table class="list_table">
						<colgroup>
							<col width="60px;">
							<col width>
							<col width="80px;">
							<col width="80px;">
							<col width="50px;">
						</colgroup>
							<thead>
								<tr>
									<th>No.</th>
									<th>제목</th>
									<th>날짜</th>
									<th>작성자</th>
									<th>조회수</th>
								</tr>
							</thead>
							<tbody>
								<tr>
									<td>8</td>
									<td><a href="#" class="doors">사이트 약관 소개</a></td>
									<td>2019-09-12</td>
									<td>관리자</td>
									<td class="view_count">155</td>
								</tr>
								<tr>
									<td>7</td>
									<td><a href="#" class="doors">1:2 영어 수업 같이 하실 파트너분 찾습니다.</a></td>
									<td>2019-04-15</td>
									<td>관리자</td>
									<td class="view_count">166</td>
								</tr>
								<tr>
									<td>6</td>
									<td><a href="#" class="doors">카드 무이자 할부 중단 안내 (3월1일부터)</a></td>
									<td>2019-04-15</td>
									<td>관리자</td>
									<td class="view_count">166</td>
								</tr>
								<tr>
									<td>5</td>
									<td><a href="#" class="doors">연휴 휴강/휴무 안내</a></td>
									<td>2019-04-15</td>
									<td>관리자</td>
									<td class="view_count">166</td>
								</tr>
								<tr>
									<td>4</td>
									<td><a href="#" class="doors">4월 수강료 50%할인권, 스타벅스 기프티콘 2장 100% 증정</a></td>
									<td>2019-04-15</td>
									<td>관리자</td>
									<td class="view_count">166</td>
								</tr>
								<tr>
									<td>3</td>
									<td><a href="#" class="doors">추천인 입력시 포인트 적릭해드립니다.</a></td>
									<td>2019-04-15</td>
									<td>관리자</td>
									<td class="view_count">166</td>
								</tr>
								<tr>
									<td>2</td>
									<td><a href="#" class="doors">3.1절 휴무 관련 안내입니다.</a></td>
									<td>2019-04-15</td>
									<td>관리자</td>
									<td class="view_count">166</td>
								</tr>
								<tr>
									<td>1</td>
									<td><a href="#" class="doors">사이트 오픈 이벤트 실시!</a></td>
									<td>2019-03-29</td>
									<td>관리자</td>
									<td class="view_count">166</td>
								</tr>
							</tbody>
						</table>
						<div class="border_btn">
							<p class="float_r">
								<button class="btnIcon" onclick="location.href='admin_input.jsp?bId=${bId}&bName=${bName }'">글쓰기</button>
							</p>
						</div>
					</div>
				</div>
			</div>
		</div>
       <article id="foot">
           <p>© COOKIT ALL RIGHTS RESERVED</p>
       </article>
    </div>
<!-- 여기까지 content 입니다------------------------------------------------>
</body>
</html>