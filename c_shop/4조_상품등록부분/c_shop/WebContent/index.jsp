<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Insert title here</title>
		<link rel="stylesheet" href="css/style_main.css">
		<jsp:include page="common/config.jsp" />
		
	</head>
	<body>
		 <!-- 수정 확인 -->
		 <c:if test="${m_check==1 }">
		  	<script type="text/javascript">
		  		alert("저장이 정상적으로 완료되었습니다.");
		  	</script>
		 </c:if>
		 <c:if test="${m_check==0 }">
		  	<script type="text/javascript">
		  		alert("저장이 정상적으로 이루어지지 않았습니다. 다시 시도해 주세요.");
				history.back(-1);
		  	</script>
		 </c:if>
		 <!-- 로그인 확인 -->
		 <c:if test="${check=='0' }">
			<script>
				alert("아이디나 비밀번호가 틀립니다.");
				history.back(-1);
			</script>
		 </c:if>
	 	<jsp:include page="common/nologin_top-nav.jsp" />
	 	<section>
	 		<div id="top_img">
	 			<div>
	 				<a href="#">
		 				<span>NEW</span>
		 				<span>3/16 신메뉴 출시</span>
		 				<span>따끈한 소울푸드<br>황태콩나물 해장국</span>
			 			<span><span></span>3인분</span>
			 			<span><span></span>조리 15분</span>
	 				</a>
	 				<span>16,800원 <a href="#"></a></span>
	 				<div>
	 					<a href="#"></a>
			 			<span>1/5</span>
			 			<a href="#"></a>
	 				</div>
	 			</div>
	 		</div>
	 		<div id="recomend">
	 			<div>
	 				<div>
		 				<span>얼큰한맛 <a href="#">▼</a></span>
		 				<span>메뉴<br>추천드려요</span>
		 				<span><a href="#">로그인</a>하시면 고객님의 구매내역과<br> 맛취향에 따라 딱맞는 맛있는 메뉴를 추천드려요</span>
		 			</div>
		 			<div></div>
		 			<a href="#"><img alt="우거지탕" src="img/recomand_tang.png"></a>
		 			<div>
		 				<a href="#">얼큰소고기우거지탕</a>
		 				<div>
			 				<span>18,800원</span>
			 				<span>/3인분<a href="#"></a></span>
		 				</div>
	 				</div>
	 			</div>
	 		</div>
	 		<a href="elist.do" id="event_banner"><img alt="" src="pupload/${main_banner }" id="event_bannerimg"></a>
	 		<div id="best">
	 			<h2>실시간 베스트</h2>
	 			<ul>
	 				<li>
	 					<a href="#">
		 					<img alt="참스테이크" src="img/best01.jpg">
		 					<span id="best_top">BEST<br>01</span>
	 					</a>
	 					<a href="#">
		 					<span>부채살 찹스테이크</span>
		 					<span>
		 						20,800원
		 						<span>/2인분</span>
		 					</span>
	 					</a>
	 					<a href="#"></a>
	 				  </li>
	 				<li>
	 					<a href="#">
		 					<img alt="감바스 알아히오" src="img/best02.jpg">
		 					<span>02</span>
	 					</a>
	 					<a href="#">
		 					<span>감바스 알아히오</span>
		 					<span>
		 						20,800원
		 						<span>/3인분</span>
		 					</span>
	 					</a>
	 					<a href="#"></a>
	 				</li>
	 				<li>
	 					<a href="#">
		 					<img alt="소고기 두부전골" src="img/best03.jpg">
		 					<span>03</span>
	 					</a>
	 					<a href="#">
		 					<span>소고기 두부전골</span>
		 					<span>
		 						24,800원
		 						<span>/3인분</span>
		 					</span>
	 					</a>
	 					<a href="#"></a>
	 				</li>
	 				<li>
	 					<a href="#">
		 					<img alt="스키야키" src="img/best04.jpg">
		 					<span>04</span>
	 					</a>
	 					<a href="#">
		 					<span>스키야키</span>
		 					<span>
		 						24,800원
		 						<span>/3인분</span>
		 					</span>
	 					</a>
	 					<a href="#"></a>
	 				</li>
	 				<li>
	 					<a href="#">
		 					<img alt="빠네크림 파스타" src="img/best05.jpg">
		 					<span>05</span>
	 					</a>
	 					<a href="#">
		 					<span>빠네크림 파스타</span>
		 					<span>
		 						20,800원
		 						<span>/2인분</span>
		 					</span>
	 					</a>
	 					<a href="#"></a>
	 				</li>
	 				<li>
	 					<a href="#">
		 					<img alt="부추가득 오리불고기" src="img/best06.jpg">
		 					<span>06</span>
	 					</a>
	 					<a href="#">
		 					<span>부추가득 오리불고기</span>
		 					<span>
		 						24,800원
		 						<span>/3인분</span>
		 					</span>
	 					</a>
	 					<a href="#"></a>
	 				</li>
	 			</ul>
	 		</div>
	 		<div id="review">
	 			<h2>생생한 리뷰</h2>
	 			<div>
	 				<a href="#">
	 				<span></span>
	 				<span>속초식 코다리찜</span>
	 				<span>
						재료가 워낙 좋으니 생선이라도 비린내 걱정
						<br>없이 맛있었어요.나가서 사먹는것보다
						<br>내 집에서 믿고먹는 맛집, 쿡킷입니다!
					</span>
					<span></span>
	 				<span>by.for********</span>
	 				</a>
	 				<div>
	 					<a href="#"></a>
			 			<span>1/5</span>
			 			<a href="#"></a>
	 				</div>
	 			</div>
	 			<img alt="코다리찜1" src="img/review01.jpg">
	 			<img alt="코다리찜2" src="img/review02.png">
	 			<span></span>
	 		</div>
			<div id="menu">
				<div>
					<img alt="메뉴상단01" src="img/menu_top01.jpg">
					<h2>쿡킷 메뉴보기<br>
					Premium Mealkit</h2>
					<span>
					장보기, 재료손질, 레시피검색 <strong>번거로움 OUT!</strong><br>
					초간편함은 물론, 완벽한 맛 쿡킷이 다~ 했네
					</span>
					<ul>
						<c:forEach var="main_menu" items="${main_menu}">
						<li>
							<a href="pcontent_view.do?pId=${main_menu.pId}&page=1">
								<span>
									<img alt="${main_menu.pName}" src="pupload/${main_menu.pTitleimg}">
								</span>
								<span>${main_menu.pName}</span>
								<span>${main_menu.pPrice}원<span>/${main_menu.pAmount}인분</span></span>
								<span class="new_menu">NEW</span>
							</a>
							<a href="#"></a>
						</li>
						</c:forEach>
					</ul>
				</div>
				<div>
					<img alt="핫딜" src="img/menu_hotdeal.jpg">
					<h2>놓칠 수 없는 기회 <br>
					오픈 한정 핫딜</h2>
					<span>파격적인 가격으로<br>
					쿡킷을 경험할 수 있는 기회를 잡으세요.</span>
					<a href="#">
						<img alt="쿡킷소개" src="img/menu_cj_intro.jpg">
						<h2>프리미엄 밀키트<br>
						COOKIT을 소개합니다.</h2>
						<span>COOKIT은 장보기, 재료손질, 계량 등 복잡한 과정 없이도<br>
						누구나 간편하게 특별한 집밥을 만들 수 있도록 도와드립니다.</span>
					</a>
				</div>
			</div>
			<div id="main_notice">
				<a href="list.do">
					<dl>
						<dt>공지사항</dt>
						<dd>미리보는 쿡킷 전체 메뉴 (3月)</dd>
					</dl>
				</a>
			</div>	 		
	 	</section>
		<jsp:include page="common/footer.jsp" />
	</body>
</html>