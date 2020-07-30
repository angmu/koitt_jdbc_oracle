<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>집밥을 특별하게, 쿡킷</title>
		<script type="text/javascript" src="js/common.js"></script>
		<link type="text/css" rel="stylesheet" href="css/menu_detail.css">
		<jsp:include page="common/config.jsp"/>
	</head>
	<body>
		<jsp:include page="common/top-nav.jsp"/>
		<section>
			<!-- 상품상세 -->
			<div id="detail_box">
			<article id="de_food_top">
				<div id="food_main">
					<img src="pupload/${pcon.pContentimg1 }">
					<ul>
						<li><img src="img/top_food01.jpg"></li>
						<li><img src="img/top_food02.jpg"></li>
						<li><img src="img/top_food03.jpg"></li>
						<li><img src="img/top_food04.jpg"></li>
						<li><img src="img/top_food05.jpg"></li>
						<li><img src="img/top_food06.jpg"></li>
					</ul>
					<div>
						<button></button>
						<button></button>
					</div>
				</div>
				<div id="food_main_sub">
					<div>
						<a href="#tap_menu3">
						<span class="star"></span>
						<span class="num">4.9</span>
						<span class="txt">리뷰수</span>
						<span class="num">52</span></a>
						<span>레시피</span>
						<span>공유하기</span>
					</div>
				</div>	
				<div id="food_top_info_box">
					<h2></h2>
					<p>${pcon.pName }</p>
					<h5>${pcon.pCategory }</h5>
					<span>${pcon.pAmount}인분</span><span class="pro_info">조리 ${pcon.pTime}분</span><span class="pro_info fire_m">약간 매운맛</span>
						<table>
						<colgroup>
						<col width="140px">
						<col width="360px">
						</colgroup>
						<tr>
							<td>판매가</td>
							<td><fmt:formatNumber value="${pcon.pPrice}" type="currency" />원</td>
						</tr>
						<tr>
							<td>포인트적립</td>
							<td>CJ ONE 포인트 <span class="lime qt">0.2%적립</span></td>
						</tr>
						<tr>
							<td>배송방법</td>
							<td><span class="qt">새벽배송 &nbsp;&nbsp; 배송가능여부조회</span></td>
						</tr>
						<tr>
							<td>배송비</td>
							<td><fmt:formatNumber value="${pcon.pDelivery}" type="currency" />원<span>4만원 이상 구매 시 무료배송</span></td>
						</tr>
						</table>
						<form name="basket_f" method="post" action="">
							<input type="radio" id="basket" name="baorgi" checked="checked"  class="radio"><label for="basket">장바구니</label>
							<input type="radio" id="gift" name="baorgi" class="radio"><label for="gift">선물하기</label>
							<span class="qt">주문마감시간 오전 7시</span>
							<select name="order_date" class="order_dsel">
								<option value="" selected="selected" disabled="disabled" hidden="hidden">배송받을 날짜를 선택하세요</option>
								<option value="today">04월 02일 (목)</option>
								<option value="today_p1">04월 03일 (금)</option>
								<option value="today_p2">04월 04일 (토)</option>
								<option value="today_p3">04월 05일 (일)</option>
								<option value="today_p4">04월 06일 (월)</option>
							</select>
							<p>수량 0개<span>0원</span></p>
							<button name="favorit" onclick="" class="f_basket_heart"><span></span></button><input type="submit" value="장바구니 담기" class="submit_btn">
						</form>
						
				</div>
			</article>
			<article id="detail_view_nav_box">	
				<div id="detail_nav">
					<ul>
						<li><a href="#tap_menu1">상세설명</a></li>
						<li><a href="#tap_menu2">상품정보</a></li>
						<li><a href="#tap_menu3">리뷰 (<span>52개</span>)</a></li>
						<li><a href="#tap_menu4">배송/반품/문의</a></li>
					</ul>				
				</div>
			</article>	
			<article id="detail_view_menu">
				<div id="detail_wrap">
					<div class="tap_menu" id="tap_menu1">
						<img src="img/copyright_top.gif">
						<div class="detail_view_box01">
							<p>주문정보안내</p>
							<span>오전 7시 이전에 구매하시면 다음날 새벽에 받아보실 수 있습니다.</span>
							<ul>
								<li>
								<i class="d_ico dico01"></i>
								<span>오전 7시 이전<br>주문/결제 완료</span>
								</li>
								<li>
								<i class="d_ico dico02"></i>
								<span>재료<br>준비/발송</span>
								</li>
								<li>
								<i class="d_ico dico03"></i>
								<span>다음날<br>새벽수령</span>
								</li>
							</ul>
						</div>
					</div>
					<div class="p_detail">
						<img alt="${pcon.pName }" src="pupload/${pcon.pContentimg2 }">
						<div class="p_content">
						${pcon.pContent}
						</div>
					</div>
				</div>
			</article>
			</div>
			<div class="clear"></div>
		</section>
		<jsp:include page="common/footer.jsp"/>
	</body>
</html>